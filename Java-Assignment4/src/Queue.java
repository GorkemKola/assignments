import java.util.ArrayList;

public class Queue<Thing> {
    ArrayList<Thing> queue = new ArrayList<>();

    public ArrayList<Thing> enqueue(Thing thing) {
        queue.add(thing);
        return queue;
    }

    public Thing dequeue() {
        Thing thing = queue.get(0);
        queue.remove(0);
        return thing;
    }

    public ArrayList<Thing> queue() {
        return queue;
    }
}
