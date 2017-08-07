package action;

import PersonUtil.Util;
import com.opensymphony.xwork2.ActionContext;
import dao.SchooltimeDaoImpl;
import database.DB;
import domain.Schooltime;

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


    private String description;
    private List<Schooltime> schooltimes;
    private SchooltimeDaoImpl schooltimeDao = new SchooltimeDaoImpl();

    /**
     * 添加课程安排时间
     *
     * @return
     */
    public String add() {
        if (time == 0) {
            return "addSchooltime";
        }
        Schooltime schooltime = new Schooltime();
        schooltime.setDate(date);
        schooltime.setTime(time);
        schooltime.setWeek_start(week_start);
        schooltime.setWeek_end(week_end);
        schooltime.setDescription(description);
        schooltime.setCreate_time(Util.getCurrentTime());
        schooltimeDao.save(schooltime);
        return "success";
    }

    /**
     * 修改课程时间
     *
     * @return
     */
    public String modify() {
        schooltimes = new LinkedList<>();
        if (time == 0) {
            Map request = (Map) ActionContext.getContext().get("request");
            int id = (int) request.get("id");
            schooltimes.add(schooltimeDao.get(Schooltime.class, id));
                return "modifySchooltime";
        } else {
//            String sql = "update s_schooltime set date = " + date + ", time = " + time + ", week_start = " + week_start + ", " +
//                    "week_end = " + week_end + ", " +
//                    "description = '" + description +
//                    "' ,write_time = '" + Util.getCurrentTime() + "' where id = " + id;
//            if (DB.executeUpdate(sql)) {






            Schooltime schooltime = schooltimeDao.get(Schooltime.class, id);
            schooltime.setDate(date);
            schooltime.setTime(time);
            schooltime.setWeek_start(week_start);
            schooltime.setWeek_end(week_end);
            schooltime.setDescription(description);
            schooltime.setWrite_time(Util.getCurrentTime());
            schooltimeDao.update(schooltime);
                return "success";
//            } else {
//                return "error";
//            }
        }
//        return "error";
    }

    public String delete() {
        Map request = (Map) ActionContext.getContext().get("request");
        int id = (int) request.get("id");
        schooltimeDao.delete(Schooltime.class, id);
        return "success";
    }

    public String get() {
        schooltimes = new LinkedList<>();
        schooltimes = schooltimeDao.findAll(Schooltime.class);
        if (schooltimes != null)
            return "showSchooltime";
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
                String description = rs.getString("description");
                String s_create_time = rs.getString("create_time");
                String s_write_time = rs.getString("write_time");

                list.add(new Schooltime(s_id, date, s_time, week_start, week_end, description, s_create_time, s_write_time));
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
