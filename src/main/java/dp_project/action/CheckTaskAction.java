package dp_project.action;

import dp_project.context.TaskListContext;

public class CheckTaskAction extends TaskListAction {
    public CheckTaskAction(String message, String code) {
        super(message, code);

        this.args = new String[]{"task-id"};
    }

    @Override
    public void execute(TaskListContext ac) throws Exception {
        long id = ac.getScanner().nextLong();
        ac.getStorage().checkTask(id);
    }
}
