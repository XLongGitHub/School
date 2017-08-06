package user;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserAction extends ActionSupport {
    private int id;
    private String phone;
    private String password;
    private String name;
    private int sex;
    private int grade;
    private String avactor;
    private String address;
    private List<User> users;



    class User {
        private int id;
        private String name;
        private String avactor;
        private int sex;
        private int grade;
        private String address;
        private String phone;
        private String create_time;
        private String write_time;

        public User(int id, String name, String avactor, int sex, int grade, String address, String phone, String create_time, String write_time) {
            this.id = id;
            this.name = name;
            this.avactor = avactor;
            this.sex = sex;
            this.grade = grade;
            this.address = address;
            this.phone = phone;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvactor() {
            return avactor;
        }

        public void setAvactor(String avactor) {
            this.avactor = avactor;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getWrite_time() {
            return write_time;
        }

        public void setWrite_time(String write_time) {
            this.write_time = write_time;
        }
    }

    /**
     * 判断该用户是否存在
     *
     * @param phone
     * @param password
     * @return
     */
    public boolean isUser(String phone, String password) {
        String sql = "SELECT * FROM s_user WHERE phone = '" + phone + "' and password = '" + Util.EncoderBySHA(password) + "' ";
        try {
            if (DB.executeQuery(sql).next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 用户登陆判断
     *
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        if (isUser(phone, password)) {
            ActionContext ac = ActionContext.getContext();
            Map session = ac.getSession();
            session.put("phone", phone);
            return "login_success";
        } else {
            return "login_error";
        }
    }

    /**
     * 用户注册
     *
     * @return
     */
    public String add() {
        if (phone == null || phone.equals(""))
            return "add";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String sqlget = "select * from s_user where phone = '" + phone + "'";
        try {
            if (DB.executeQuery(sqlget).next())
                return "register_error";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into s_user (phone, password, create_time) values ('" + phone + "' , '" + Util.EncoderBySHA(password) + "' ,'" + df.format(new Date()) + "')";
        if (DB.executeUpdate(sql)) {
            return "register_success";
        } else {
            return "register_error";
        }
    }

    /**
     * 用户修改完善个人信息
     *
     * @return
     */
    public String modify() {
//        String method = ServletActionContext.getRequest().getMethod();
//        System.out.println(method);
//        if(method.equals("POST"){
//            System.out.println("POST请求");
//        }else{
//            System.out.println("GET请求");
//        }


        if (id != 0 && name == null && address == null && avactor == null) {
            String sql = "select * from s_user where id = " + id;
            ResultSet rs = DB.executeQuery(sql);
            users = new LinkedList<>();
            if (fill(rs, users) != null)
                return "modify_detail";
        }
//        String phone = (String) ActionContext.getContext().getSession().get("phone");

        String sql = "update s_user set";
        if (name != null && !name.equals(""))
            sql += " name = '" + name + "', ";
//        if (sex != null && !sex.equals("")) {
//            int sexNum = 0;
//            if (sex.equals("male")) {
//                sexNum = 1;
//            } else if (sex.equals("female")) {
//                sexNum = 2;
//            } else {
//                sexNum = 0;
//            }
        sql += " sex = " + sex + " ,";
//        }
        if (address != null && !address.equals("")) {
            sql += " address = '" + address + "',";
        }
        if (avactor != null && !avactor.equals("")) {
            sql += " avactor = '" + avactor + "', ";
        }
//        if (grade != null && !grade.equals("")) {
//            int gradeNum = 0;
//            if (grade.equals("student")) {
//                gradeNum = 1;
//            } else if(grade.equals("teacher")) {
//                gradeNum = 2;
//            } else if (grade.equals("admin")){
//                gradeNum = 9;
//            }
        sql += " grade = " + grade;
//        }
        sql += ", write_time = '" + Util.getCurrentTime() + "'";
        sql += " where id = " + id;
        if (DB.executeUpdate(sql)) {
            return "modify_success";
        } else {
            return "modify_error";
        }
    }

    /**
     * 根据条件查看所有用户
     *
     * @return
     */
    public String get() {
        users = new LinkedList<>();
        ResultSet rs = DB.executeQuery("SELECT id,avactor,name,sex,address,phone, grade, create_time, write_time FROM s_user");
//            while (usersSet.next()){
        //map 根据key-value去去掉多余部分
//                users.put("name", usersSet.getString("name"));
//                users.put("avactor", usersSet.getString("avactor"));
//                users.put("sex", "" + usersSet.getInt("sex"));
//                users.put("address", usersSet.getString("address"));
//                users.put("phone", usersSet.getString("phone"));
//                users.put("grade", usersSet.getString("grade"));
//                users.put("create_time", usersSet.getString("create_time"));
//                int id = usersSet.getInt("id");
//                String name = usersSet.getString("name");
//                String avator =   usersSet.getString("avactor");
//                int sex = usersSet.getInt("sex");
//                int grade = usersSet.getInt("grade");
//                String address = usersSet.getString("address");
//                String phone = usersSet.getString("phone");
//                String create_time = usersSet.getString("create_time");
//                String write_time = usersSet.getString("write_time");
//                users.add(new User(id, name, avator, sex, grade, address, phone, create_time, write_time));
        if (fill(rs, users) != null) {
            System.out.println(users.size());
            return "users_success";
        }
        return "error";
    }

    /**
     * 删除用户
     * param 电话号码
     *
     * @return
     */
    public String delete() {
        //拿到get请求参数
        Map request = (Map) ActionContext.getContext().get("request");
        String phone = (String) request.get("phone");
        String sql = "delete from s_user where phone = '" + phone + "'";
        if (DB.executeUpdate(sql)) {
            return "delete_user_success";
        } else {
            return "delete_user_error";
        }
    }

    public List<User> fill(ResultSet rs, List<User> list) {
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String avator = rs.getString("avactor");
                int sex = rs.getInt("sex");
                int grade = rs.getInt("grade");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String create_time = rs.getString("create_time");
                String write_time = rs.getString("write_time");

                list.add(new User(id, name, avator, sex, grade, address, phone, create_time, write_time));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String fillEmpty(String str) {
        if (str == null) {
            str = "empty";
        } else if (str != null && str.equals("")) {
            str = "empty";
        }
        return str;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAvactor() {
        return avactor;
    }

    public void setAvactor(String avactor) {
        this.avactor = avactor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
