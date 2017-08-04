package course;

import database.DB;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseAction {
    private String name;
    private String classroom_id;
    private String schooltime_id;
    private String create_time;
    private String write_time;

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
        return "success";
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
}
