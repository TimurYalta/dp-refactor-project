package dp_project.action;

import dp_project.context.TaskListContext;
import dp_project.domain.Project;
import dp_project.domain.Task;
import dp_project.domain.TaskListStorageInterface;

import java.io.PrintStream;
import java.util.ArrayList;

public class ShowAction extends TaskListAction {

    public ShowAction(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(TaskListContext ac) throws Exception {
        TaskListStorageInterface storage = ac.getStorage();
        ArrayList<Project> store = storage.getProjects();
        PrintStream stream = ac.getPrintStream();
        if(store.isEmpty()){
            stream.println("No projects or tasks added...");
            return;
        }
        for(Project p: store){
            stream.println("Project: "+p.getName());
            if(p.getTasks().isEmpty()){
                stream.println("    <empty>");
            }
            for(Task t: p.getTasks()){
                String mark;
                if(t.isDone()){
                    mark = "X";
                }
                else{
                    mark = " ";
                }
                String deadline="";
                if(t.getDeadline() != null){
                    deadline = " - "+t.getDeadline();
                }
                stream.println("    ["+mark+"]  "+t.getId()+" :"+t.getDescription()+deadline);
            }
        }
    }
}
