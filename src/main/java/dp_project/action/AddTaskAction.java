package dp_project.action;

import dp_project.context.TaskListContext;
import dp_project.domain.Task;

public class AddTaskAction extends TaskListAction{
    public AddTaskAction(String message, String code) {
        super(message, code);

        this.args = new String[]{"project-name","task-description"};
    }

    @Override
    public void execute(TaskListContext ac) throws Exception {
        String projName = ac.getScanner().next().strip();
        String desc =ac.getScanner().nextLine();
        Task t = ac.generateTask(desc);
        ac.getStorage().addTask(projName, t);
    }
}
