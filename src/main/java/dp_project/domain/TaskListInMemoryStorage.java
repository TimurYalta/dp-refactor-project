package dp_project.domain;

import java.util.ArrayList;

public class TaskListInMemoryStorage implements TaskListStorageInterface {
    private ArrayList<Project> projects;

    public TaskListInMemoryStorage(){
        this.projects = new ArrayList<>();
    }


    @Override
    public void addProject(Project p) {
        projects.add(p);
    }

    @Override
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @Override
    public void addTask(String projName, Task task) {
        for(Project p: projects){

            if(p.getName().equals(projName)){
                p.addTask(task);
            }
        }
    }

    @Override
    public void checkTask(long id) {
        for(Project p:projects){
            p.checkTask(id);
        }
    }

    @Override
    public void uncheckTask(long id) {
        for(Project p:projects){
            p.unCheckTask(id);
        }
    }

    @Override
    public void deleteTask(long id) {
        for(Project p:projects){
            p.deleteTask(id);
        }
    }

    @Override
    public void deleteProject(String name) {
        projects.removeIf(p -> p.getName().equals(name));
    }

    @Override
    public void addDeadline(long id, String deadline) {
        for(Project p:projects){
            p.setTaskDeadline(id, deadline);
        }
    }
}
