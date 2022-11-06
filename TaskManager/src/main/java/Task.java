

public class Task {

    private String tt;
    private String td;

    public Task(String tt, String td) {
        this.tt = tt;
        this.td = td;
    }

    @Override
    public String toString() {
        return "Task{" +
                "tt='" + tt + '\'' +
                ", td='" + td + '\'' +
                '}';
    }
}
