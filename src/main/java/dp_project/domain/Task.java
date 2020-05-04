package dp_project.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Task {
    private final long id;
    private final String description;
    private String deadline;
    private boolean done;

    public Task(long id, String description, boolean done, String deadline) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }
    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }
    public void checkDone(){
        this.done = true;
    }
    public void uncheckDone(){
        this.done = false;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    public void setDeadline(String date) {
        this.deadline = date;
    }
    public boolean isDeadlineToday() {
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        if (deadline == null) return false;
        try {
            date = dateFormat.parse(deadline);
            Date date1 = new Date();
            String date11 = dateFormat.format(date1);
            if (deadline.equals(date11)) {
                return true;
            }
        } catch (ParseException pEx) {
            throw new IllegalArgumentException(
                    String.format("%s is not a valid date", deadline),
                    pEx);
        }
        return false;
    }

}
