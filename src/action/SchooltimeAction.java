package action;

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
    private int date;
    private int time;
    private int week_start;
    private int week_end;
    private String create_time;
    private String write_time;
    private String desc;
    private List<Schooltime> schooltimes;
    class Schooltime {
        private int id;
        private int date;
        private int time;
        private int week_start;
        private int week_end;
        private String desc;
        private String create_time;
        private String write_time;

        public Schooltime(int id, int time, String create_time, String write_time) {
            this.id = id;
            this.time = time;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public Schooltime(int id, int date, int time, int week_start, int week_end, String create_time, String write_time) {
            this.id = id;
            this.date = date;
            this.time = time;
            this.week_start = week_start;
            this.week_end = week_end;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public Schooltime(int id, int date, int time, int week_start, int week_end, String desc, String create_time, String write_time) {
            this.id = id;
            this.date = date;
            this.time = time;
            this.week_start = week_start;
            this.week_end = week_end;
            this.desc = desc;
            this.create_time = create_time;
            this.write_time = write_time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
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

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getWeek_start() {
            return week_start;
        }

        public void setWeek_start(int week_start) {
            this.week_start = week_start;
        }

        public int getWeek_end() {
            return week_end;
        }

        public void setWeek_end(int week_end) {
            this.week_end = week_end;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    /**
     * 添加课程安排时间
     * @return
     */
    public String add() {
        if (time == 0) {
            return "addSchooltime";
        }
        String sql = "insert into s_schooltime (date, time, week_start, week_end, `desc`, create_time) values ("+date +","+ time + ","+week_start+ ","+week_end+ ",'" + desc+ "', '" + Util.getCurrentTime() + "' )";
        if (DB.executeUpdate(sql)) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 修改课程时间
     * @return
     */
    public String modify() {
        schooltimes = new LinkedList<>();
        if (time == 0) {
            Map request = (Map) ActionContext.getContext().get("request");
            int id = (int) request.get("id");
            String sql = "select * from s_schooltime where id = " + id;
            ResultSet rs = DB.executeQuery(sql);
            if (fill(rs, schooltimes) != null)
                return "modifySchooltime";
        } else {
            String sql = "update s_schooltime set date = " + date + ", time = " + time + ", week_start = "+ week_start+", " +
                    "week_end = " + week_end + ", " +
                    "`desc` = '" + desc +
                    "' ,write_time = '" + Util.getCurrentTime() + "' where id = " + id;
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
        if ( fill(rs, schooltimes) != null) {
            return "showSchooltime";
        }
        return "error";
    }

    public List<Schooltime> fill(ResultSet rs, List<Schooltime> list) {
        try {
            while (rs.next()) {
                int s_id = rs.getInt("id");
                int date = rs.getInt("date");
                int s_time = rs.getInt("time");
                int week_start = rs.getInt("week_start");
                int week_end = rs.getInt("week_end");
                String desc = rs.getString("desc");
                String s_create_time = rs.getString("create_time");
                String s_write_time = rs.getString("write_time");

                list.add(new Schooltime(s_id, date, s_time, week_start, week_end, desc, s_create_time, s_write_time));
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getWeek_start() {
        return week_start;
    }

    public void setWeek_start(int week_start) {
        this.week_start = week_start;
    }

    public int getWeek_end() {
        return week_end;
    }

    public void setWeek_end(int week_end) {
        this.week_end = week_end;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
