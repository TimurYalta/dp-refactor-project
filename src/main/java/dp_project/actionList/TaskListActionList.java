package dp_project.actionList;

import dp_project.action.Action;
import dp_project.action.TaskListAction;
import dp_project.context.TaskListContext;

import java.io.PrintStream;
import java.util.ArrayList;

public class TaskListActionList extends GenericActionList<TaskListContext> {
    public TaskListActionList(String message, String code, String title){
        super(message, code, title);
    }

    public String getArgsString(Action<TaskListContext> act){
        if(act.getArgs().length==0){
            return "";
        }
        else{
            StringBuilder res= new StringBuilder();
            for(String s: act.getArgs()){
                res.append(" <").append(s).append(">");
            }
            return res.toString();
        }
    }


    @Override
    public String[] getArgs() {
        return new String[0];
    }

    private void error(String command, PrintStream st) {
        st.printf("I don't know what the command \"%s\" is.", command);
        st.println();
    }

    @Override
    public void execute(TaskListContext ac) throws Exception {
        while (true){
            PrintStream stream = ac.getPrintStream();
            stream.println("-----------------------------");
            stream.println(this.title);
            String argsPacked;
            actionList.forEach((action) -> System.out.println("["+action.actionCode()+getArgsString(action)+"]" + " - " + action.actionMessage()));
            stream.flush();
            stream.println("-----------------------------");
            boolean foundCommand = false;
            String choice = ac.getScanner().next();
            for (Action<TaskListContext> action : actionList) {
                if (action.actionCode().equals(choice)){
                    action.execute(ac);
                    foundCommand = true;
                    break;
                }
            }
            if(!foundCommand){
                error(choice, stream);
            }

        }
    }
}
