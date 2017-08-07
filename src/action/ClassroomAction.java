package action;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import dao.ClassroomDaoImpl;
import database.DB;
import domain.Classroom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClassroomAction {
    private int id;
    private String name;
    private int empty;
    private String create_time;
    private String write_time;
    private List<Classroom> classrooms;
    private ClassroomDaoImpl classroomDao = new ClassroomDaoImpl();

    /**
     * 添加教室信息
     *
     * @return
     */
    public String add() {
        if (name == null) {
            return "addClassroom";
        } else {
            Classroom classroom = new Classroom();
            classroom.setName(name);
            classroom.setCreate_time(Util.getCurrentTime());
            classroomDao.save(classroom);
            return "addClassroom_success";
        }
    }

    /**
     * 修改教室信息
     *
     * @return
     */
    public String modify() {
        classrooms = new LinkedList<>();
        Map request = (Map) ActionContext.getContext().get("request");
        int id = (int) request.get("id");
        if (name == null) {
            classrooms.add(classroomDao.get(Classroom.class, id));
            return "modifyClassroom";
        }
        Classroom classroom = classroomDao.get(Classroom.class, id);
        classroom.setName(name);
        classroom.setWrite_time(Util.getCurrentTime());
        classroomDao.update(classroom);
        return "modifyClassroom_success";
    }

    /**
     * 删除教室信息
     *
     * @return
     */
    public String delete() {
        Map request = (Map) ActionContext.getContext().get("request");
        int id = (int) request.get("id");
        classroomDao.delete(Classroom.class, id);
        return "success";
    }

    /**
     * 得到教室信息
     *
     * @return
     */
    public String get() {
        classrooms = new LinkedList<>();
        classrooms = classroomDao.findAll(Classroom.class);
        if (classrooms != null)
            return "showClassroom";
        return "error";
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


    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }


    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }
}
