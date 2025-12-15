import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Queues are a FIFO (First in, First out) data structure
 * A queue is a collection designed for holding elements prior to processing.
 * Queues are a linear data structure.
 *
 * The documentation recommends these methods used for Queues:
 *      add = enqueue, offer()
 *      remove = dequeue, poll()
 *      element = peek()
 *
 * Where are queues useful?
 *      1. Keyboard buffer
 *      2. Printer queue
 *      3. Used in LinkedList, PriorityQueues, Breadth-first search
 */

public class QueuesExamples {

    /**
     * This code is an example from Bro Code on YouTube, link below.
     * https://youtu.be/nqXaPZi99JI?si=H2Og3MRobyQqH7we
     *
     */
    public static void broCodeExample() {
        /**
         * The Queue class is actually an interface, it is meant to be used
         * like a template for another class.
         *
         * To use the Queue technology, we need another class that implements Queue.
         */
        //Queue<String> queue = new Queue<String>();
        Queue<String> queue = new LinkedList<String>();

        //These offer methods add the element to the end of the queue
        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Herold");

        System.out.println("Printing the whole queue gets us: " + queue);

        //Spacer line for readability
        System.out.println();

        //peek method just looks at what is up first in the queue
        System.out.println("Peak gets us: " + queue.peek());

        //Spacer line for readability
        System.out.println();

        //the poll method removes the first element in the queue
        queue.poll();
        System.out.println("After polling, we get: " + queue);
        queue.poll();
        queue.poll();
        System.out.println("After polling 2 more times, we get: " + queue);

        //Spacer line for readability
        System.out.println();

        //These three methods below are from the collections class in Java that queue can use
        System.out.println("Is the queue empty? " + queue.isEmpty());
        System.out.println("How big is the queue? " + queue.size());
        System.out.println("Does the queue contain \"Herold\"? " + queue.contains("Harold"));
    }

    public static void chatGPTExample() {

        //Creating an empty Queue using ArrayDeque
        Queue<Integer> queue = new ArrayDeque<>();

        //Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println(queue); //[10, 20, 30]

        //Spacer line for readability
        System.out.println();

        //Removes element at index 0 from the queue
        queue.remove();
        System.out.println("Queue after one remove method: " +queue); // [20, 30]

        //Spacer line for readability
        System.out.println();

        //Peek method just looks at what is up first in the queue
        System.out.println("Peeking at the first element:" + queue.peek());

        //Spacer lines for readability
        System.out.println();
        System.out.println();

        /**
         * This example below is a queue simulation that is very
         * common on final exams
         */
        Queue<String> line = new ArrayDeque<>();

        //Adding elements to the queue
        line.add("John");
        line.add("Jane");
        line.add("Bob");
        System.out.println(line);

        //Print line that shows what happens during a remove method
        System.out.println("Element served with remove: " + line.remove());

        //adding one more element to queue
        line.add("Billy");

        //Spacer line for readability
        System.out.println();

        while (!line.isEmpty()) {
            System.out.println("Element served with poll: " + line.poll());
        }

        System.out.println(line); // [John, Jane, Bob]
    }

    public static void main(String[] args) {
        broCodeExample();

        //Spacer lines for readability
        System.out.println();
        System.out.println();

        chatGPTExample();
    }
}
