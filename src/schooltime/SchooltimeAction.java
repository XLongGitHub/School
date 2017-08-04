package schooltime;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SchooltimeAction {
    private int id;
    private String time;
    private String create_time;
    private String write_time;
    private List<Schooltime> schooltimes;

    class Schooltime {
        private int id;
        private String time;
        private String create_time;
        private String write_time;

        public Schooltime(int id, String time, String create_time, String write_time) {
            this.id = id;
            this.time = time;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
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

    public String add() {
        if (time == null) {
            return "addSchooltime";
        }
        String sql = "insert into s_schooltime (time, create_time) values ('" + time + "','" + Util.getCurrentTime() + "' )";
        if (DB.executeUpdate(sql)) {
            return "success";
        } else {
            return "error";
        }
    }

    public String modify() {
        schooltimes = new LinkedList<>();
        if (time == null) {
            Map request = (Map) ActionContext.getContext().get("request");
            int id = (int) request.get("id");
            String sql = "select * from s_schooltime where id = " + id;
            ResultSet rs = DB.executeQuery(sql);
            try {
                while (rs.next()) {
                    int s_id = rs.getInt("id");
                    String s_time = rs.getString("time");
                    String s_create_time = rs.getString("create_time");
                    String s_write_time = rs.getString("write_time");
                    schooltimes.add(new Schooltime(s_id, s_time, s_create_time, s_write_time));
                }
                return "modifySchooltime";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "update s_schooltime set time = '" + time + "', write_time = '" + Util.getCurrentTime() + "' where id = " + id;
            if (DB.executeUpdate(sql)) {
                return "success";
            } else {
                return "error";
            }
        }
        return "error";
    }

    public String delete() {
        Map request = (Map) ActionContext.getContext().get("request");
        int id = (int) request.get("id");
        String sql = "delete from s_schooltime where id = " + id;
        if (DB.executeUpdate(sql)) {
            return "success";
        } else {
            return "error";
        }
    }

    public String get() {
        schooltimes = new LinkedList<>();
        String sql = "select * from s_schooltime";
        ResultSet rs = DB.executeQuery(sql);
        try {
            while (rs.next()) {
                int s_id = rs.getInt("id");
                String s_time = rs.getString("time");
                String s_create_time = rs.getString("create_time");
                String s_write_time = rs.getString("write_time");

                schooltimes.add(new Schooltime(s_id, s_time, s_create_time, s_write_time));
            }
            return "showSchooltime";
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

}
