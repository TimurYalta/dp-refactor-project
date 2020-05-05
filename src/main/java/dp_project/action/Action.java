package dp_project.action;

public interface Action<E> {
    String actionMessage();
    String actionCode();
    String[] getArgs();
    void execute(E ac) throws Exception;
}
