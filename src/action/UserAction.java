package action;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDaoImpl;
import database.DB;
import domain.User;

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
    private UserDaoImpl userDao = new UserDaoImpl();

    /**
     * 用户登陆判断
     *
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        String hql = "from User u where u.phone = '" + phone + "' and password = '" + Util.EncoderBySHA(password) + "'";
        List us = userDao.find(hql);
        if (us != null) {
            ActionContext ac = ActionContext.getContext();
            Map session = ac.getSession();
            session.put("phone", phone);
            User u = (User) us.get(0);
            session.put("user_id", u.getId());
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
//        String hql = "select * from User u where u.phone = ?0";
        String hql = "from User u where u.phone = '" + phone + "'";
        if (userDao.find(hql) != null) {
            return "register_error";
        }
        domain.User user = new domain.User();
        user.setName("新用户");
        user.setPhone(phone);
        user.setPassword(Util.EncoderBySHA(password));
        user.setCreate_time(Util.getCurrentTime());
//        userDao.save(user);    此处写重，导致插入两遍
        if (userDao.save(user) != null) {
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
        if (id != 0 && name == null && address == null && avactor == null) {
            users = new LinkedList<>();
            users.add(userDao.get(User.class, id));
            return "modify_detail";
        }
//        String sql = "update s_user set";
//        if (name != null && !name.equals(""))
//            sql += " name = '" + name + "', ";
//        sql += " sex = " + sex + " ,";
//        if (address != null && !address.equals("")) {
//            sql += " address = '" + address + "',";
//        }
//        if (avactor != null && !avactor.equals("")) {
//            sql += " avactor = '" + avactor + "', ";
//        }
//        sql += " grade = " + grade;
//        sql += ", write_time = '" + Util.getCurrentTime() + "'";
//        sql += " where id = " + id;

//        User user = new User();  //需从数据库中拿出来，再进行更改
        User user = userDao.get(User.class, id);
        user.setName(name);
        user.setAddress(address);
        user.setAvactor(avactor);
        user.setWrite_time(Util.getCurrentTime());
        user.setGrade(grade);
//        userDao.save(user);
        userDao.update(user);
//        if (DB.executeUpdate(sql)) {
            return "modify_success";
//        } else {
//            return "modify_error";
//        }
    }

    /**
     * 根据条件查看所有用户
     *
     * @return
     */
    public String get() {
        users = userDao.findAll(User.class);
        if (users != null) return "users_success";
        return "error";
    }

    /**
     * 删除用户
     * param 电话号码
     *
     * @return
     */
    public String delete() {
        Map request = (Map) ActionContext.getContext().get("request");
        int id = (int) request.get("id");
        userDao.delete(User.class, id);
        return "delete_user_success";
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
