package course;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CourseAction {
    private int id;
    private String name;
    private int classroom_id;
    private int schooltime_id;
    private String create_time;
    private String write_time;
    private List<Course> courses;
    private List<Schooltime> schooltimes;
    private List<Classroom> classrooms;

    class Classroom{
        private int id;
        private String name;

        public Classroom(int id, String name) {
            this.id = id;
            this.name = name;
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
    }

    class Schooltime {
        private int id;
        private String desc;

        public Schooltime(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    class Course {
        private int id;
        private String name;
        private int classroom_id;
        private int schooltime_id;
        private String create_time;
        private String write_time;

        public Course(int id, String name, int classroom_id, int schooltime_id, String create_time, String write_time) {
            this.id = id;
            this.name = name;
            this.classroom_id = classroom_id;
            this.schooltime_id = schooltime_id;
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
     * 添加课程信息
     *
     * @return
     */
    public String add() {
        if (name == null) {
            String sql = "select id, `desc` from s_schooltime";
            String sql2 = "select id, name from s_classroom";
            ResultSet rs = DB.executeQuery(sql);
            ResultSet rs2 = DB.executeQuery(sql2);
            try {
                schooltimes = new LinkedList<>();
                while (rs.next()) {
                    schooltimes.add(new Schooltime(rs.getInt("id"), rs.getString("desc")));
                }
                classrooms = new LinkedList<>();
                while (rs2.next()) {
                    classrooms.add(new Classroom(rs2.getInt("id"), rs2.getString("name")));
                }
                return "add";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "insert into s_course (name, classroom_id, schooltime_id, create_time) values ('" +
                    name + "' , " + classroom_id + ", " + schooltime_id + ",'" + Util.getCurrentTime() + "')";
            if (DB.executeUpdate(sql)) {
                return "addCourse_success";
            } else {
                return "addCouse_error";
            }
        }
        return "error";
    }


    /**
     * 修改课程信息
     *
     * @return
     */
    public String modify() {
        Map request = (Map) ActionContext.getContext().get("request");
        courses = new LinkedList<>();
//        System.out.println(request.get("id"));
//        System.out.println(request.containsKey("id"));  //false

        if (name == null || name.equals("")) {
            System.out.println("but");
//            if (request.containsKey("id")) {
            int id = Integer.parseInt((String) request.get("id"));
            String sql = "select * from s_course where id = " + id;
            ResultSet rs = DB.executeQuery(sql);
            if (fill(rs, courses) != null)
                return "modifyCourse";
//            }
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String sql = "update s_course set ";
            sql += "name = '" + name + "', ";
            if (classroom_id != 0)
                sql += "classroom_id = " + classroom_id + ", ";
            if (schooltime_id != 0)
                sql += "schooltime_id = " + schooltime_id + ", ";
            sql += "write_time = '" + df.format(new Date()) + "'";
            sql += "where id = " + id;
            if (DB.executeUpdate(sql)) {
                System.out.println("here");
                return "modifyCourse_success";
            } else {
                System.out.println("here");
                return "modifyCourse_error";
            }
        }
        return "error";
    }

    /**
     * 删除课程信息
     *
     * @return
     */
    public String delete() {
        Map request = (Map) ActionContext.getContext().get("request");
//        if (request.containsKey("id")) {
        int id = Integer.parseInt((String) request.get("id"));
        String sql = "delete from s_course where id = " + id;
        if (DB.executeUpdate(sql)) {
            return "deleteCourse_success";
        } else {
            return "deleteCourse_error";
        }
//        }
    }

    /**
     * 得到课程信息
     *
     * @return
     */
    public String get() {
        courses = new LinkedList<>();
        String sql = "select * from s_course";
        ResultSet rs = DB.executeQuery(sql);
        if (fill(rs, courses) != null)
            return "getCourse_success";
        return "error";
    }

    public List<Course> fill(ResultSet rs, List<Course> list) {
        try {
            while (rs.next()) {
                int c_id = rs.getInt("id");
                String c_name = rs.getString("name");
                int c_classroom_id = rs.getInt("classroom_id");
                int c_schooltime_id = rs.getInt("schooltime_id");
                String c_create_time = rs.getString("create_time");
                String c_write_time = rs.getString("write_time");
                list.add(new Course(c_id, c_name, c_classroom_id, c_schooltime_id, c_create_time, c_write_time));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Schooltime> getSchooltimes() {
        return schooltimes;
    }

    public void setSchooltimes(List<Schooltime> schooltimes) {
        this.schooltimes = schooltimes;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
}
