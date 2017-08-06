package schedule;

import java.util.List;

public class ScheduleAction {
    private int id;
    private int user_id;
    private int course_id;
    private String create_time;
    private String write_time;
    private List<Schedule> schedules;

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

    public ScheduleAction(int id, int user_id, int course_id, String create_time, String write_time) {
        this.id = id;
        this.user_id = user_id;
        this.course_id = course_id;
        this.create_time = create_time;
        this.write_time = write_time;
    }

    public String add() {

        return "error";
    }

    public String modify() {
        return "error";
    }

    public String get() {
        return "error";
    }

    public String delete() {
        return "error";
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
