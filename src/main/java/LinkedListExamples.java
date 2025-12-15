import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExamples {
    /**
     * The code in this method are examples from this youtube link:
     * https://youtu.be/YQQio9BGWgs?si=RcSkRrHJxsaZU0oH
     */
    public static void alexLeeVideoTutorial() {
        /**
         * The warnings are there because we are not
         * declaring the type of LinkedList.
         */
        LinkedList linky = new LinkedList();

        // Adds elements to the end of the LinkedList
        linky.add("Rob");
        linky.add("Bob");
        linky.add("Jill");

        //prints out the entire LinkedList inside of "[]"
        System.out.println(linky);

        // Spacer line for readability
        System.out.println();

        // removes the first element in the LinkedList
        linky.remove();

        System.out.println(linky);

        // Spacer line for readability
        System.out.println();

        // Removes all elements from the LinkedList
        linky.clear();

        System.out.println(linky);

        // Spacer line for readability
        System.out.println();
        System.out.println();
        //---------------------------------------------
        LinkedList<Integer> linky2 = new LinkedList<Integer>();

        linky2.add(6);
        linky2.add(78);
        linky2.add(1);

        System.out.println(linky2);
        System.out.println(linky2.getFirst());
        System.out.println(linky2.getLast());

        // Spacer line for readability
        System.out.println();

        System.out.println(linky2.get(1));

        // Spacer line for readability
        System.out.println();
        System.out.println();
        //---------------------------------------------
        LinkedList<Integer> linky3 = new LinkedList<Integer>();

        linky3.add(6);
        linky3.add(78);
        linky3.add(1);

        Iterator it = linky3.iterator();
        while(it.hasNext()) {
            if ((int) it.next() == 78) {
                System.out.println("We found '78'");
            }
        }
    }

    public static void chatGPTExample(){
        LinkedList<String> list = new LinkedList<>();

        // Step 1: add at the ends (works like a normal List)
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Initial list: " + list); //[A, B, C]

        // Step 2: addFirst / addLast
        list.addFirst("Start");
        list.addLast("End");
        System.out.println("After addFirst/addLast: " + list);
        // [Start, A, B, C, End]

        // Step 3: add at index
        list.add(2, "X");
        System.out.println("After add(2, \"x\"): " + list);
        // [Start, A, X, C, B, End]

        //Step 4: get / set
        String at3 = list.get(3);
        System.out.println("Element at index 3: " + at3);

        list.set(3, "Y");
        System.out.println("After set(3, \"Y\"): " + list);
        // [Start, A, X, Y, C, End]

        // Step 5: removeFirst / removeLast / remove(index)
        String first = list.removeFirst(); //removes Start
        String last = list.removeLast(); //removes End
        System.out.println("Removed first: " + first + ", last: " + last);
        System.out.println("After removeFirst/removeLast: " + list);
        // [A, X, Y, C]

        list.remove(1); //removes X
        System.out.println("After remove(1): " + list);
        // [A, Y, C]

        //Step 6: iterate with iterator and remove while iterating
        System.out.println("\nIterator loop (removing \"Y\"):");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String val = it.next();
            if (val.equals("Y")) {
                it.remove(); //valid way to remove while iterating
            }
            System.out.println("Visited: " + val);
        }

        System.out.println("Final list: " + list); // [A, C]


    }

    public static void main(String[] args) {
        alexLeeVideoTutorial();
        chatGPTExample();
    }

}
