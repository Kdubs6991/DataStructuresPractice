/**
 * ArrayList = a resizable array.
 *             Elements can be added and removed after compilation phase
 *             Only store reference to objects
 */

import java.util.ArrayList;

public class ArrayListExamples {

    public static void chatGPTExample() {
        ArrayList<String> food = new ArrayList<String>();
        // .add adds the element to the end of the ArrayList
        food.add("Pizza");
        food.add("hamburger");
        food.add("hotdog");

        // for loop to print off all the elements in the ArrayList
        for (int i = 0; i < food.size(); i++) {
            System.out.println(food.get(i));
        }

        // Spacer line for readability
        System.out.println();

        // .set replaces the element at the specified index
        food.set(0, "sushi");

        //For Each loop, does the same as the for loop above
        // but is more compact.
        for (String i : food) {
            System.out.println(i);
        }

        //Spacer line for readability
        System.out.println();

        // .remove removes the element at the specified index
        food.remove(2);

        for (String i : food) {
            System.out.println(i);
        }

        //Spacer line for readability
        System.out.println();

        // .clear removes all elements from the ArrayList
        food.clear();

        for (String i : food) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        chatGPTExample();
    }
}
