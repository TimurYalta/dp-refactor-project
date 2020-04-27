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
        System.out.println("HAHA HERE BP&A");
        for(Project p: projects){

            System.out.println("HAHA HERE afasf");
            if(p.getName().equals(projName)){

                System.out.println("HAHA HERE Bas");
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
}
