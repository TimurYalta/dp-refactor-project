package dp_project.actionList;

import dp_project.action.Action;

public interface ActionList<E> extends Action<E> {
    public String listTitle();
    public int size();
    public boolean addAction(Action<E> ac, int index);

    public boolean removeAction(int index);

    public boolean removeAction(Action<E> ac);

    public String listOfActions();
}
