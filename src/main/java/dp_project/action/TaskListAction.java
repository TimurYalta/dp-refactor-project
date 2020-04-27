package dp_project.action;

import dp_project.action.Action;
import dp_project.context.TaskListContext;

import java.io.PrintStream;
import java.io.PrintWriter;

abstract public class TaskListAction implements Action<TaskListContext> {  //
    protected String message;
    protected String code;
    protected String[] args;

    public TaskListAction(String message, String code){
        this.message = message;
        this.code = code;
        args = new String[]{};
    }
    public TaskListAction(String message, String code, String[] args){
        this.message = message;
        this.code = code;
        this.args = args;
    }

    public String[] getArgs(){
        return args;
    }


    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public String actionMessage(){
        return message;
    }


}
