package schedule;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScheduleAction {
    private int id;
    private int user_id;
    private int course_id;
    private String create_time;
    private String write_time;
    private List<Schedule> schedules;
    private List<CourseDetail> courseDetails;

    class Schedule {
        private int id;
        private int user_id;
        private int course_id;
        private String create_time;
        private String write_time;

        public Schedule(int id, int user_id, int course_id, String create_time, String write_time) {
            this.id = id;
            this.user_id = user_id;
            this.course_id = course_id;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
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

    class CourseDetail {
        private int id;
        private String name;
        private int classroom_id;
        private int schooltime_id;
        private int teacher_id;
        private String classroom_name;
        private String schooltime_desc;
        private String teacher_name;

        public CourseDetail(int id, String name, String classroom_name, String schooltime_desc, String teacher_name) {
            this.id = id;
            this.name = name;
            this.classroom_name = classroom_name;
            this.schooltime_desc = schooltime_desc;
            this.teacher_name = teacher_name;
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

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }
    }

    public String add() {
        if (id <= 0) {
            String sql = "select i.*, a.name classroom_name, b.`desc` schooltime_desc, c.name teacher_name from ((" +
                    "s_course i left join s_classroom a on i.classroom_id = a.id )" +
                    "left join s_schooltime b on i.schooltime_id = b.id)" +
                    "left join s_user c on c.id = i.teacher_id";
            ResultSet rs = DB.executeQuery(sql);
            courseDetails = new LinkedList<>();
            if (fill(rs, courseDetails) != null) {
                return "addSchedule";
            }
        } else {
            int user_id = (int)ActionContext.getContext().getSession().get("user_id");
            int course_id = (int) ((Map)ActionContext.getContext().get("request")).get("id");
            String sql = "insert into s_schedule (user_id, course_id, create_time) values" +
                    "("+user_id+", " + course_id + ", '" + Util.getCurrentTime()+"')";
            if (DB.executeUpdate(sql)) {
                return "success";
            } else {
                return "error";
            }
        }
        return "error";
    }


    public String get() {
        int user_id = (int)ActionContext.getContext().getSession().get("user_id");
        String sql = "select i.*, a.name classroom_name, b.`desc` schooltime_desc, c.name teacher_name from (((" +
                "s_schedule d left join s_course i on d.course_id = i.id and d.user_id = "+ user_id +")" +
                "left join s_classroom a on i.classroom_id = a.id )" +
                "left join s_schooltime b on i.schooltime_id = b.id)" +
                "left join s_user c on c.id = i.teacher_id";
//        String sql = "select i.*, a.name classroom_name, b.`desc` schooltime_desc, c.name teacher_name from ((" +
//                "s_course i left join s_classroom a on i.classroom_id = a.id and i.id = "+ user_id +  ")" +
//                "left join s_schooltime b on i.schooltime_id = b.id)" +
//                "left join s_user c on c.id = i.teacher_id";
        courseDetails = new LinkedList<>();
        ResultSet rs = DB.executeQuery(sql);
        if (fill(rs, courseDetails) != null) {
            return "showSchedule";
        }
        return "error";
    }

    public String delete() {
        int user_id = (int)ActionContext.getContext().getSession().get("user_id");
        int course_id = (int) ((Map)ActionContext.getContext().get("request")).get("id");
        String sql = "delete from s_schedule where user_id = " + user_id + " and course_id = " + course_id;
        if (DB.executeUpdate(sql)) {
            return "success";
        } else {
            return "error";
        }
    }

    public List<CourseDetail> fill(ResultSet rs, List<CourseDetail> list) {
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String classroom_name = rs.getString("classroom_name");
                String schooltime_desc = rs.getString("schooltime_desc");
                String teacher_name = rs.getString("teacher_name");
                list.add(new CourseDetail(id, name, classroom_name, schooltime_desc, teacher_name));
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<CourseDetail> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(List<CourseDetail> courseDetails) {
        this.courseDetails = courseDetails;
    }
}
