package user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import database.DB;
import org.apache.struts2.ServletActionContext;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class UserAction extends ActionSupport {
    private String phone;
    private String password;
    private String name;
    private String sex;
    private String grade;
    private String avactor;
    private String address;

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
}
