import java.util.ArrayList;

public class User {
    private static int idHolder = 1;
    private int id;
    private String un;
    private String fn;
    private String ln;
    private ArrayList<Task> tasks;

    public User(String un, String fn, String ln ) {
        this.id = idHolder++;
        this.un = un;
        this.fn = fn;
        this.ln = ln;
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public String getUn() {
        return un;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", un='" + un + '\'' +
                ", fn='" + fn + '\'' +
                ", ln='" + ln + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
