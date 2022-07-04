
public class TaskType {

    private int id;
    private String taskName;
    private int taskType;
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public TaskType() {
    }

    public TaskType(int id, String taskName, int taskType, String date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.taskName = taskName;
        this.taskType = taskType;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String type() {
        switch (getTaskType()) {
            case 1:
                return "Code";
            case 2:
                return "Design";
            case 3:
                return "Test";
            case 4:
                return "Mark";
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%-18s%-18s%-18s%-18s%-18s%-18s%-18s",
                id, taskName, type(), date(date), (to - from), assignee, reviewer);
    }

    String date(String date) {
        String date1 = "";
        date1 += date.substring(4, 7) + date.substring(0, 4);
        for (int i = 7; i <= 10; i++) {
            date1 += date.charAt(i);
        }
        return date1;
    }
}
