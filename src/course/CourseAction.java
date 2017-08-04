package course;

import database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CourseAction {
    private String name;
    private String classroom_id;
    private String schooltime_id;
    private String create_time;
    private String write_time;
    private List<Course> courses;

    class Course {
        private String id;
        private String name;
        private String classroom_id;
        private String schooltime_id;
        private String create_time;
        private String write_time;

        public Course(String id, String name, String classroom_id, String schooltime_id, String create_time, String write_time) {
            this.id = id;
            this.name = name;
            this.classroom_id = classroom_id;
            this.schooltime_id = schooltime_id;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getClassroom_id() {
            return classroom_id;
        }

        public void setClassroom_id(String classroom_id) {
            this.classroom_id = classroom_id;
        }

        public String getSchooltime_id() {
            return schooltime_id;
        }

        public void setSchooltime_id(String schooltime_id) {
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    /**
     * 添加课程信息
     * @return
     */
    public String add() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if (name == null) {
            return "add";
        } else {
            String sql = "insert into s_course (name, classroom_id, schooltime_id, create_time) values ('"+
                    name+"' , " +Integer.parseInt(classroom_id)+", " + Integer.parseInt(schooltime_id) +",'" +df.format(new Date())+"')";
            if (DB.executeUpdate(sql)) {
                return "addCourse_success";
            } else {
                return "addCouse_error";
            }
        }
    }

    /**
     * 修改课程信息
     * @return
     */
    public String modify() {
        if (name == null) {
            return "modify";
        } else {

        }
        return "success";
    }

    /**
     * 删除课程信息
     * @return
     */
    public String delete() {

        return "success";
    }

    /**
     * 得到课程信息
     * @return
     */
    public String get() {
        courses = new LinkedList<>();
        String sql = "select * from s_course";
        ResultSet rs = DB.executeQuery(sql);
        try {
            while (rs.next()) {
                String c_id = "" + rs.getInt("id");
                String c_name = rs.getString("name");
                String c_classroom_id = "" + rs.getInt("classroom_id");
                String c_schooltime_id = "" + rs.getInt("schooltime_id");
                String c_create_time = rs.getString("create_time");
                String c_write_time = rs.getString("write_time");
                courses.add(new Course(c_id, c_name, c_classroom_id, c_schooltime_id, c_create_time, c_write_time));
            }
            return "getCourse_success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(String classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getSchooltime_id() {
        return schooltime_id;
    }

    public void setSchooltime_id(String schooltime_id) {
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
}
