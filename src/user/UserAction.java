package user;

import com.opensymphony.xwork2.ActionSupport;
import database.DB;

import java.sql.SQLException;

public class UserAction extends ActionSupport {
    private String phone;
    private String password;

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
            return "success";
        } else {
            return "error";
        }
    }

    public String register() {
        String sql =  "insert into s_user (phone, password) values ('" + phone +"' , '" + PersonUtil.EncoderBySHA(password) + "')";
        if (DB.executeUpdate(sql)) {
            return "success";
        } else {
            return "error";
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
}
