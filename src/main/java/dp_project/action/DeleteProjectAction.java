package dp_project.action;

import dp_project.context.TaskListContext;

public class DeleteProjectAction extends TaskListAction{
    public DeleteProjectAction(String message, String code) {
        super(message, code);

        this.args = new String[]{"project-name"};
    }

    @Override
    public void execute(TaskListContext ac) throws Exception {
        String name = ac.getScanner().next();
        ac.getStorage().deleteProject(name);
    }
}
