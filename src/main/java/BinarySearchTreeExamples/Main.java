package BinarySearchTreeExamples;

/**
 * A binary search tree is a tree data structure where each node is greater than it's left
 *  child, but less than it's right child.
 *
 * Benefit: easy to locate a node when they are in this order
 * Time: best case O(log(n)), worst case O(n)
 *
 * Space: O(n)
 */
public class Main {
    public static void main(String[] args) {
        //Creating a new binary search tree using the class in the package that we construct.
        BinarySearchTree tree = new BinarySearchTree();

        //Inserting new nodes not in order to the new binary search tree.
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));

        System.out.println("Displaying the tree in order: ");
        tree.display();

        //Spacer lines for readability
        System.out.println();
        System.out.println();

        System.out.println("Is the number 0 in the tree? " + tree.search(0));
        System.out.println("Is the number 1 in the tree? " + tree.search(1));
        System.out.println("Is the number 9 in the tree? " + tree.search(9));

        //Spacer lines for readability
        System.out.println();
        System.out.println();

        //Removing values from the tree
        tree.remove(1);
        tree.display();
        System.out.println();

        tree.remove(9);
        tree.display();
        System.out.println();

        tree.remove(0);
    }

}
