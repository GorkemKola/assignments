import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<Thing> extends ArrayList<Thing> implements Iterable<Thing> {
    List<Thing> stack = new ArrayList<Thing>();

    /**
     * a function to add an object to stack
     *
     * @param thing a object will be added to stack
     */
    public void push(Thing thing) {
        stack.add(thing);
    }

    /**
     * a function to take the object of top of a stack
     *
     * @return the object of top of a stack
     */
    public Thing pop() {
        try {
            Thing thing = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return thing;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * this function is to iterate stack class
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        return stack.iterator();
    }
}
