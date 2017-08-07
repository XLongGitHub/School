package domain;

import javax.persistence.*;

@Entity
@Table(name = "s_schooltime")
public class Schooltime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int date;
    private int time;
    private int week_start;
    private int week_end;
    private String desc;
    private String create_time;
    private String write_time;

    public Schooltime() {}

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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
