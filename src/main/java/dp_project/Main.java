package dp_project;

import dp_project.context.TaskListContext;
import dp_project.domain.TaskListInMemoryStorage;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskListContext ctx = TaskListContext.getInstance();
        TaskListInMemoryStorage storage = new TaskListInMemoryStorage();
        ctx.initContextStorage(storage);
        TaskListContext.getMenu().execute(ctx);
    }
}
