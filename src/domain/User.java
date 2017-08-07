package domain;

import javax.persistence.*;

@Entity
@Table(name = "s_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int sex;
    private String address;
    private String password;
    private int grade;
    private String phone;
    private String avactor;
    private String create_time;
    private String write_time;

    public User() {}

    public User(String name, int sex, String address, String password, int grade, String phone, String avactor, String create_time, String write_time) {
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.password = password;
        this.grade = grade;
        this.phone = phone;
        this.avactor = avactor;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvactor() {
        return avactor;
    }

    public void setAvactor(String avactor) {
        this.avactor = avactor;
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
