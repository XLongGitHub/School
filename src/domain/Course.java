package domain;

import javax.persistence.*;

@Entity
@Table(name = "s_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int classroom_id;
    private int schooltime_id;
    private int teacher_id;
    private String create_time;
    private String write_time;

    public Course() {}

    public Course(String name, int classroom_id, int schooltime_id, int teacher_id, String create_time, String write_time) {
        this.name = name;
        this.classroom_id = classroom_id;
        this.schooltime_id = schooltime_id;
        this.teacher_id = teacher_id;
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

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public int getSchooltime_id() {
        return schooltime_id;
    }

    public void setSchooltime_id(int schooltime_id) {
        this.schooltime_id = schooltime_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
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
