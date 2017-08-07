package action;

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
    private String classroom_name;
    private int schooltime_id;
    private String schooltime_desc;
    private int teacher_id;
    private String teacher_name;
    private String create_time;
    private String write_time;
    private List<Course> courses;
    private List<Schooltime> schooltimes;
    private List<Classroom> classrooms;
    private List<Teacher> teachers;

    class Teacher {
        private int id;
        private String name;

        public Teacher(int id, String name) {
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

    class Classroom {
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
        private String classroom_name;
        private int schooltime_id;
        private String schooltime_desc;
        private int teacher_id;
        private String teacher_name;
        private String create_time;
        private String write_time;

        public Course(int id, String name, int classroom_id, String classroom_name, int schooltime_id, String schooltime_desc, String create_time, String write_time) {
            this.id = id;
            this.name = name;
            this.classroom_id = classroom_id;
            this.classroom_name = classroom_name;
            this.schooltime_id = schooltime_id;
            this.schooltime_desc = schooltime_desc;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public Course(int id, String name, int classroom_id, String classroom_name, int schooltime_id, String schooltime_desc, int teacher_id, String teacher_name, String create_time, String write_time) {
            this.id = id;
            this.name = name;
            this.classroom_id = classroom_id;
            this.classroom_name = classroom_name;
            this.schooltime_id = schooltime_id;
            this.schooltime_desc = schooltime_desc;
            this.teacher_id = teacher_id;
            this.teacher_name = teacher_name;
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

        public String getClassroom_name() {
            return classroom_name;
        }

        public void setClassroom_name(String classroom_name) {
            this.classroom_name = classroom_name;
        }

        public String getSchooltime_desc() {
            return schooltime_desc;
        }

        public void setSchooltime_desc(String schooltime_desc) {
            this.schooltime_desc = schooltime_desc;
        }

        public int getTeacher_id() {
            return teacher_id;
        }

        public void setTeacher_id(int teacher_id) {
            this.teacher_id = teacher_id;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
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
            String sql3 = "select id, name from s_user where grade = 2";
            ResultSet rs = DB.executeQuery(sql);
            ResultSet rs2 = DB.executeQuery(sql2);
            ResultSet rs3 = DB.executeQuery(sql3);
            try {
                schooltimes = new LinkedList<>();
                while (rs.next()) {
                    schooltimes.add(new Schooltime(rs.getInt("id"), rs.getString("desc")));
                }
                classrooms = new LinkedList<>();
                while (rs2.next()) {
                    classrooms.add(new Classroom(rs2.getInt("id"), rs2.getString("name")));
                }
                teachers = new LinkedList<>();
                while (rs3.next()) {
                    teachers.add(new Teacher(rs3.getInt("id"), rs3.getString("name")));
                }
                return "add";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "insert into s_course (name, classroom_id, schooltime_id, teacher_id, create_time) values ('" +
                    name + "' , " + classroom_id + ", " + schooltime_id + "," + teacher_id + ",'" + Util.getCurrentTime() + "')";
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
            int id = (int) request.get("id");
//            String sql = "select * from s_course where id = " + id;
            String sql = "select i.*, a.name classroom_name, b.`desc` schooltime_desc, c.name teacher_name from ((" +
                    "s_course i left join s_classroom a on i.classroom_id = a.id and i.id = " + id + ")" +
                    "left join s_schooltime b on i.schooltime_id = b.id)" +
                    "left join s_user c on c.id = i.teacher_id";
            ResultSet rs = DB.executeQuery(sql);
            if (fill(rs, courses) != null) {
                String sql3 = "select id, `desc` from s_schooltime";
                String sql2 = "select id, name from s_classroom";
                String sql4 = "select id, name from s_user where grade = 2";
                ResultSet rs3 = DB.executeQuery(sql3);
                ResultSet rs2 = DB.executeQuery(sql2);
                ResultSet rs4 = DB.executeQuery(sql4);
                try {
                    schooltimes = new LinkedList<>();
                    while (rs3.next()) {
                        schooltimes.add(new Schooltime(rs3.getInt("id"), rs3.getString("desc")));
                    }
                    classrooms = new LinkedList<>();
                    while (rs2.next()) {
                        classrooms.add(new Classroom(rs2.getInt("id"), rs2.getString("name")));
                    }
                    teachers = new LinkedList<>();
                    while (rs4.next()) {
                        teachers.add(new Teacher(rs4.getInt("id"), rs4.getString("name")));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return "modifyCourse";
            }
//            }
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String sql = "update s_course set ";
            sql += "name = '" + name + "', ";
            if (classroom_id != 0)
                sql += "classroom_id = " + classroom_id + ", ";
            if (schooltime_id != 0)
                sql += "schooltime_id = " + schooltime_id + ", ";
            if (teacher_id != 0)
                sql += "teacher_id = " + teacher_id + ", ";
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
//        String sql = "select * from s_course";
        String sql = "select i.* , a.name as classroom_name, b.`desc` as schooltime_desc, c.name as teacher_name from ((s_course i left join" +
                " s_classroom a on a.id = i.classroom_id) left join s_schooltime b on b.id = i.schooltime_id) " +
                "left join s_user c on c.id = i.teacher_id";
        ResultSet rs = DB.executeQuery(sql);
        if (fill(rs, courses) != null)
            return "getCourse_success";
        return "error";
    }

    public List<Course> fill(ResultSet rs, List<Course> list) {
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int classroom_id = rs.getInt("classroom_id");
                String classroom_name = rs.getString("classroom_name");
                int schooltime_id = rs.getInt("schooltime_id");
                String schooltime_desc = rs.getString("schooltime_desc");
                int teacher_id = rs.getInt("teacher_id");
                String teacher_name = rs.getString("teacher_name");
                String create_time = rs.getString("create_time");
                String write_time = rs.getString("write_time");
                list.add(new Course(id, name, classroom_id, classroom_name, schooltime_id, schooltime_desc, teacher_id,teacher_name, create_time, write_time));
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

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public String getSchooltime_desc() {
        return schooltime_desc;
    }

    public void setSchooltime_desc(String schooltime_desc) {
        this.schooltime_desc = schooltime_desc;
    }


    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }


    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

}
