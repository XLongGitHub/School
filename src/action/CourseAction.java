package action;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import dao.*;
import database.DB;
import domain.Classroom;
import domain.Course;
import domain.Schooltime;
import domain.User;

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
    private List<CourseBean> courseBeans;
    private List<Schooltime> schooltimes;
    private List<Classroom> classrooms;
    private List<User> teachers;

    private SchooltimeDaoImpl schooltimeDao;
    private ClassroomDaoImpl classroomDao;
    private UserDaoImpl userDao;
    private CourseDaoImpl courseDao;

    public void setSchooltimeDao(SchooltimeDaoImpl schooltimeDao) {
        this.schooltimeDao = schooltimeDao;
    }

    public void setClassroomDao(ClassroomDaoImpl classroomDao) {
        this.classroomDao = classroomDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void setCourseDao(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }
//    private BaseDaoImpl baseDao = new BaseDaoImpl();

    class CourseBean {
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

        public CourseBean(int id, String name, int classroom_id, String classroom_name, int schooltime_id, String schooltime_desc, String create_time, String write_time) {
            this.id = id;
            this.name = name;
            this.classroom_id = classroom_id;
            this.classroom_name = classroom_name;
            this.schooltime_id = schooltime_id;
            this.schooltime_desc = schooltime_desc;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public CourseBean(int id, String name, int classroom_id, String classroom_name, int schooltime_id, String schooltime_desc, int teacher_id, String teacher_name, String create_time, String write_time) {
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
            String hql = "select schooltime from Schooltime schooltime";
            String hql2 = "select classroom from Classroom classroom";
            String hql3 = "select user from User user where user.grade = 2";
            schooltimes = schooltimeDao.find(hql);
            classrooms = classroomDao.find(hql2);
//            System.out.println(classrooms.get(1).getClass().getSimpleName()); //java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to domain.Classroom
            teachers = userDao.find(hql3);
            return "add";
        } else {
            Course course = new Course();
            course.setName(name);
            course.setClassroom_id(classroom_id);
            course.setSchooltime_id(schooltime_id);
            course.setTeacher_id(teacher_id);
            course.setCreate_time(Util.getCurrentTime());
            courseDao.save(course);
            return "addCourse_success";
        }
    }


    /**
     * 修改课程信息
     *
     * @return
     */
    public String modify() {
        Map request = (Map) ActionContext.getContext().get("request");
//        System.out.println(request.get("id"));
//        System.out.println(request.containsKey("id"));  //false

        if (name == null || name.equals("")) {
            System.out.println("but");
            int id = (int) request.get("id");
//            String sql = "select i.*, a.name classroom_name, b.description schooltime_desc, c.name teacher_name from ((" +
//                    "s_course i left join s_classroom a on i.classroom_id = a.id and i.id = " + id + ")" +
//                    "left join s_schooltime b on i.schooltime_id = b.id)" +
//                    "left join s_user c on c.id = i.teacher_id";
            String sql = "select i.*, a.name classroom_name, b.description schooltime_desc, c.name teacher_name from ((" +
                    "(select * from s_course t where t.id = " + id + ") i left join s_classroom a on i.classroom_id = a.id )" +
                    "left join s_schooltime b on i.schooltime_id = b.id)" +
                    "left join s_user c on c.id = i.teacher_id";
//            baseDao.findMysql(sql);
            ResultSet rs = DB.executeQuery(sql);
            courseBeans = new LinkedList<>();
            if (fill(rs, courseBeans) != null) {
                String hql = "from Schooltime schooltime";
                String hql2 = "from Classroom classroom";
                String hql3 = "from User user where user.grade = 2";
                schooltimes = schooltimeDao.find(hql);
                classrooms = classroomDao.find(hql2);
                teachers = userDao.find(hql3);
                return "modifyCourse";
            }
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Course course = courseDao.get(Course.class, id);
            course.setName(name);
            course.setClassroom_id(classroom_id);
            course.setSchooltime_id(schooltime_id);
            course.setTeacher_id(teacher_id);
            course.setWrite_time(Util.getCurrentTime());
            courseDao.update(course);
            return "modifyCourse_success";
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
        int id = (int) request.get("id");
        courseDao.delete(Course.class, id);
        return "deleteCourse_success";
    }

    /**
     * 得到课程信息
     *
     * @return
     */
    public String get() {
        courseBeans = new LinkedList<>();
        String sql = "select i.* , a.name as classroom_name, b.description as schooltime_desc, c.name as teacher_name from ((s_course i left join" +
                " s_classroom a on a.id = i.classroom_id) left join s_schooltime b on b.id = i.schooltime_id) " +
                "left join s_user c on c.id = i.teacher_id";
        ResultSet rs = DB.executeQuery(sql);
        if (fill(rs, courseBeans) != null)
            return "getCourse_success";
        return "error";
    }

    public List<CourseBean> fill(ResultSet rs, List<CourseBean> list) {
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
                list.add(new CourseBean(id, name, classroom_id, classroom_name, schooltime_id, schooltime_desc, teacher_id, teacher_name, create_time, write_time));
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


    public List<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<User> teachers) {
        this.teachers = teachers;
    }


    public List<CourseBean> getCourseBeans() {
        return courseBeans;
    }

    public void setCourseBeans(List<CourseBean> courseBeans) {
        this.courseBeans = courseBeans;
    }

}
