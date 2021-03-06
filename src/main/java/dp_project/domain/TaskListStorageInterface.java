package dp_project.domain;

import java.util.ArrayList;

public interface TaskListStorageInterface {
    public void addProject(Project p);
    public ArrayList<Project> getProjects();
    public void addTask(String projName, Task task);
    public void checkTask(long id);
    public void uncheckTask(long id);
    public void deleteTask(long id);
    public void deleteProject(String name);
    public void addDeadline(long id, String deadline);
}
