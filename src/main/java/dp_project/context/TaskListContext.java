package dp_project.context;

import dp_project.action.*;
import dp_project.actionList.TaskListActionList;
import dp_project.domain.Task;
import dp_project.domain.TaskListStorageInterface;

import java.io.PrintStream;
import java.util.Scanner;

public class TaskListContext {

    static TaskListContext instance = new TaskListContext();
    private long counter= 0;
    private Scanner scanner;
    private PrintStream printStream;
    private TaskListStorageInterface storage;
    private TaskListActionList actionList;

    public TaskListStorageInterface getStorage() {
        return storage;
    }


    public Scanner getScanner() {
        return scanner;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }


    public void initContextStorage(TaskListStorageInterface stor) {
        instance.storage = stor;
    }

    public static TaskListContext getInstance() {
        if(instance ==null){
            instance = new TaskListContext();
        }
        return instance;
    }

    public static Action<TaskListContext> getMenu() {
        TaskListActionList mainMenu = new TaskListActionList("Show available actions", "help", "Main");
        mainMenu.addAction(mainMenu);
        ShowAction show = new ShowAction("Show projects and tasks", "show");
        mainMenu.addAction(show);

        AddProjectAction addProj = new AddProjectAction("Add project", "addP");
        mainMenu.addAction(addProj);

        DeleteProjectAction delProj = new DeleteProjectAction("Delete project", "deleteP");
        mainMenu.addAction(delProj);

        AddTaskAction addTask = new AddTaskAction("Add task", "addT");
        mainMenu.addAction(addTask);

        DeleteTaskAction deleteTask = new DeleteTaskAction("Delete task", "delete");
        mainMenu.addAction(deleteTask);

        CheckTaskAction checkTask = new CheckTaskAction("Check task by id", "check");
        mainMenu.addAction(checkTask);

        UncheckTaskAction uncheckTask = new UncheckTaskAction("UnCheck task by id", "uncheck");
        mainMenu.addAction(uncheckTask);

        return mainMenu;
    }

    public Task generateTask(String description){
        return new Task(++counter,description, false);
    }

    private TaskListContext() {
        this.printStream = new PrintStream(System.out);
        this.scanner = new Scanner(System.in);
    }

}
