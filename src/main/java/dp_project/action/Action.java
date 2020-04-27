package dp_project.action;

public interface Action<E> {
    public String actionMessage();
    public String actionCode();
    public String[] getArgs();
    public void execute(E ac) throws Exception;
}
