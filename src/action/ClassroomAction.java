package action;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClassroomAction {
    private int id;
    private String name;
    private String create_time;
    private String write_time;
    private List<Classroom> classrooms;
    class Classroom {
        private int id;
        private String name;
        private String create_time;
        private String write_time;

        public Classroom(int id, String name, String create_time, String write_time) {
            this.id = id;
            this.name = name;
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
     * 添加教室信息
     * @return
     */
    public String add() {
        if (name == null) {
            return "addClassroom";
        } else {
            String sql = "insert into s_classroom (name, create_time) values ('"+name+"', '"+ Util.getCurrentTime()+"')";
            if (DB.executeUpdate(sql)) {
                return "addClassroom_success";
            } else {
                return "addClassroom_error";
            }
        }
    }

    /**
     * 修改教室信息
     * @return
     */
    public String modify() {
        classrooms = new LinkedList<>();
        Map request = (Map) ActionContext.getContext().get("request");
        int id = (int) request.get("id");
        if (name == null) {
            String sql = "select * from s_classroom where id = " + id;
            ResultSet rs = DB.executeQuery(sql);
            try {
                while(rs.next()) {
                    int c_id = rs.getInt("id");
                    String c_name = rs.getString("name");
                    String c_crate_time = rs.getString("create_time");
                    String c_write_time = rs.getString("write_time");

                    classrooms.add(new Classroom(c_id, c_name, c_crate_time, c_write_time));
                }

                return "modifyClassroom";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String sql = "update s_classroom set name = '" + name + "', write_time = '" + Util.getCurrentTime() +"' where id = " + id;
        if (DB.executeUpdate(sql)) {
            return "modifyClassroom_success";
        } else {
            return "modifyClassroom_error";
        }
    }

    /**
     * 删除教室信息
     * @return
     */
    public String delete() {
        Map request = (Map) ActionContext.getContext().get("request");
        int id = (int) request.get("id");
        String sql = "delete from s_classroom where id = " + id;
        if (DB.executeUpdate(sql)) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 得到教室信息
     * @return
     */
    public String get() {
        classrooms = new LinkedList<>();
        String sql = "select * from s_classroom";
        ResultSet rs = DB.executeQuery(sql);
        try {
            while (rs.next()) {
                int c_id = rs.getInt("id");
                String c_name = rs.getString("name");
                String c_crate_time = rs.getString("create_time");
                String c_write_time = rs.getString("write_time");

                classrooms.add(new Classroom(c_id, c_name, c_crate_time, c_write_time));
            }
            return "showClassroom";
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


}
