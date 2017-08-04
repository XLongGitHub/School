package user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserAction extends ActionSupport {
    private String phone;
    private String password;
    private String name;
    private String sex;
    private String grade;
    private String avactor;
    private String address;
    private List<User> users = new LinkedList<>();

    class User {
        private String u_name;
        private String u_avator;
        private String u_sex;
        private String u_address;
        private String u_phone;
        private String u_grade;
        private String u_create_time;


        public User(String u_name, String u_avator, String u_sex, String u_address, String u_phone, String u_grade, String u_create_time) {
            this.u_name = u_name;
            this.u_avator = u_avator;
            this.u_sex = u_sex;
            this.u_address = u_address;
            this.u_phone = u_phone;
            this.u_grade = u_grade;
            this.u_create_time = u_create_time;
        }

        public String getU_name() {
            return u_name;
        }

        public void setU_name(String u_name) {
            this.u_name = u_name;
        }

        public String getU_avator() {
            return u_avator;
        }

        public void setU_avator(String u_avator) {
            this.u_avator = u_avator;
        }

        public String getU_sex() {
            return u_sex;
        }

        public void setU_sex(String u_sex) {
            this.u_sex = u_sex;
        }

        public String getU_address() {
            return u_address;
        }

        public void setU_address(String u_address) {
            this.u_address = u_address;
        }

        public String getU_phone() {
            return u_phone;
        }

        public void setU_phone(String u_phone) {
            this.u_phone = u_phone;
        }

        public String getU_grade() {
            return u_grade;
        }

        public void setU_grade(String u_grade) {
            this.u_grade = u_grade;
        }

        public String getU_create_time() {
            return u_create_time;
        }

        public void setU_create_time(String u_create_time) {
            this.u_create_time = u_create_time;
        }
    }

    /**
     * 判断该用户是否存在
     * @param phone
     * @param password
     * @return
     */
    public boolean isUser(String phone, String password) {
        String sql = "SELECT * FROM s_user WHERE phone = '" + phone + "' and password = '" + PersonUtil.EncoderBySHA(password) +"' ";
        try {
            if (DB.executeQuery(sql).next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

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

    public String register() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String sqlget = "select * from s_user where phone = '" + phone + "'";
        try {
            if (DB.executeQuery(sqlget).next())
                return "register_error";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql =  "insert into s_user (phone, password, create_time) values ('" + phone +"' , '" + PersonUtil.EncoderBySHA(password) + "' ,'"+ df.format(new Date()) +"')";
        if (DB.executeUpdate(sql)) {
            return "register_success";
        } else {
            return "register_error";
        }
    }

    /**
     * 用户修改完善个人信息
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


        if (name == null && sex == null && address == null && grade == null && avactor == null) {
            return "modify_detail";
        }
        String phone = (String) ActionContext.getContext().getSession().get("phone");
        String sql = "update s_user set";
        if (name != null && !name.equals(""))
            sql += " name = '" + name + "', ";
        if (sex != null && !sex.equals("")) {
            int sexNum = 0;
            if (sex.equals("male")) {
                sexNum = 1;
            } else if (sex.equals("female")) {
                sexNum = 2;
            } else {
                sexNum = 0;
            }
            sql += " sex = " + sexNum + " ,";
        }
        if (address != null && !address.equals("")) {
            sql += " address = '" +address+ "',";
        }
        if (avactor != null && !avactor.equals("")) {
            sql += " avactor = '" + avactor+"', ";
        }
        if (grade != null && !grade.equals("")) {
            int gradeNum = 0;
            if (grade.equals("student")) {
                gradeNum = 1;
            } else if(grade.equals("teacher")) {
                gradeNum = 2;
            } else if (grade.equals("admin")){
                gradeNum = 9;
            }
            sql += " grade = " + gradeNum ;
        }
        sql += " where phone = '" + phone + "'";

        if (DB.executeUpdate(sql)) {
            return "modify_success";
        } else {
            return "modify_error";
        }
    }

    /**
     * 根据条件查看所有用户
     * @return
     */
    public String users() {
        ResultSet usersSet =  DB.executeQuery("SELECT avactor,name,sex,address,phone, grade, create_time FROM s_user");
        try {
            while (usersSet.next()){
                //map 根据key-value去去掉多余部分
//                users.put("name", usersSet.getString("name"));
//                users.put("avactor", usersSet.getString("avactor"));
//                users.put("sex", "" + usersSet.getInt("sex"));
//                users.put("address", usersSet.getString("address"));
//                users.put("phone", usersSet.getString("phone"));
//                users.put("grade", usersSet.getString("grade"));
//                users.put("create_time", usersSet.getString("create_time"));

                String u_name = usersSet.getString("name");
                String u_avator =   usersSet.getString("avactor");
                String u_sex = "" + usersSet.getInt("sex");
                String u_address = usersSet.getString("address");
                String u_phone = usersSet.getString("phone");
                String u_grade = "" + usersSet.getInt("grade");
                String u_create_time = usersSet.getString("create_time");

                users.add(new User(u_name, u_avator, u_sex, u_address, u_phone, u_grade, u_create_time));
            }
            System.out.println(
                    users.size()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "users_success";
//        if (rs.next())
    }

    private static String fillEmpty(String str) {
        if (str == null) {
            str = "empty";
        } else if (str != null && str.equals("")) {
            str = "empty";
        }
        return  str;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
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

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
