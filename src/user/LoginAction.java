package user;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
//        System.out.println("1231231231231231231231231");
//        System.out.println(getUsername());
//        if (getUsername().equals("")) {
//            System.out.println("username is empty");
//        } else {
//            System.out.println("what happen");
//        }
        System.out.println(getUsername());
        System.out.println(getPassword());
        System.out.println(username);

        if (username.equals("admin") && password.equals("admin")) {
            return "success";
        } else {
            return "error";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
