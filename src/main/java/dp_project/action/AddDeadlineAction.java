package dp_project.action;

import dp_project.context.TaskListContext;

public class AddDeadlineAction extends TaskListAction {
    public AddDeadlineAction(String taskId, String deadLine) throws IllegalArgumentException {
        super(taskId, deadLine);

        this.args = new String[]{"task-id","task-deadline"};

    }

    @Override
    public void execute(TaskListContext ac) throws Exception {
        long id = ac.getScanner().nextLong();
        String date = ac.getScanner().next().strip();
        ac.getStorage().addDeadline(id, date);
    }

}