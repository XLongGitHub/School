package domain;

import javax.persistence.*;

@Entity
@Table(name = "s_classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int empty;
    private String create_time;
    private String write_time;

    public Classroom() {}

    public Classroom(int id, String name, int empty, String create_time, String write_time) {
        this.id = id;
        this.name = name;
        this.empty = empty;
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

    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
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
