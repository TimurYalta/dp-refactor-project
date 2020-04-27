package dp_project.domain;

import java.util.ArrayList;

public class Project {
    private ArrayList<Task> storage;
    private String name;

    public Project(String name) {
        this.name = name;
        this.storage = new ArrayList<>();
    }

    public ArrayList<Task> getTasks(){
        return storage;
    }
    public void addTask(Task task) {
        storage.add(task);
    }

    public void checkTask(long id) {
        for (Task t : storage) {
            if (t.getId() == id) {
                t.checkDone();
            }
        }
    }

    public void unCheckTask(long id) {
        for (Task t : storage) {
            if (t.getId() == id) {
                t.uncheckDone();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
