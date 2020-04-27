package dp_project.action;

import dp_project.context.TaskListContext;
import dp_project.domain.Project;

public class AddProjectAction extends TaskListAction {

    public AddProjectAction(String message, String code) {
        super(message, code);
        this.args = new String[]{"project-name"};
    }

    @Override
    public void execute(TaskListContext ac) throws Exception {
        String name = ac.getScanner().nextLine().strip();
        TaskListContext.getInstance().getStorage().addProject(new Project(name));

    }
}
