package BinarySearchTreeExamples;

public class BinarySearchTree {
    Node root;

    public void insert (Node node) {
        root = insertHelper(root, node);
    }
    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        //If our root is equal to null, then we assign the node to the root
        if (root == null) {
            root = node;
            return root;
        }
        //If the data is less than the root data, then we insert it into the left subtree
        else if (data < root.data) {
            /**
             * If we pass in the left child of the original tree, when the recursion
             *  runs, then that left child will be the new root node in the new instance
             *  of the method (in the subtree). This will continue until we find a null
             *  value, then we will assign the node to that null value.
             */
            root.left = insertHelper(root.left, node);
        }
        //If the data is greater than the root data, then we insert it into the right subtree
        else {
            root.right = insertHelper(root.right, node);
        }
        //At the end, we return the current root node.
        return root;
    }


    public void display() {
        displayHelper(root);
    }
    private void displayHelper(Node root) {
        /**
         * As long as the root node is not null, this if-statement will use
         *  recursion to display the very left leaf first (which should be the
         *  smallest value), then it will display the root of that subtree, then
         *  it will display the right leaf of that subtree.
         *
         *  It will keep doing that with recursion until the entire tree is displayed.
         *  This is called "In-Order Traversal" and it will print out in non-decreasing
         *  order (ascending order).
         *
         *  If we want the tree to print in reverse order, all we have to do is switch
         *  the order of the displayHelper() recursion methods.
         */
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }


    public boolean search(int data) {
        return searchHelper(root, data);
    }
    private boolean searchHelper(Node root, int data) {
        //If root is null, that means the tree is empty so its false
        if(root == null) {
            return false;
        }
        // If the root data == the data. That is a match to
        //  what we are looking for
        else if(root.data == data) {
            return true;
        }
        //If the root's data is greater than the data we are looking
        // for, then we need to go left. We do that recursively.
        else if (root.data > data) {
            return searchHelper(root.left, data);
        }
        //If the root's data is less than the data we are looking
        // for, then we need to go right. We do that recursively.
        else {
            return searchHelper(root.right, data);
        }
    }


    public void remove (int data) {
        //If the value is in the tree, we remove it
        if(search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println("The value " + data + " was not found in the tree");
        }
    }

    /**
     * Removing a node off of a tree can be tricky, there are 3 cases we must know
     *  1. The node is a leaf (no children)
     *      In this case, it is very easy, and we make the parent point to null
     *  2. The node has one child
     *      In this case, if there is only one child, then we basically just skip
     *      over the node we want to delete and make the parent point directly
     *      to the child, skipping the "middleman"
     *  3. The node has two children
     *      In this case, if there are 2 children to the node we want to delete,
     *      then we must find a number to take the place of the node we want to
     *      delete, once found we override the node's data with something else.
     *
     * @param root initially it is the root of the entire tree, but with recursion
     *             This "root" turns into the root of subtrees until it is the root
     *             node we want to delete
     * @param data This is the data we want to remove
     * @return the root node
     */
    private Node removeHelper(Node root, int data) {
        if(root == null) {
            return root;
        }

        else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        }

        else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else { //If the node is found
            if(root.left == null && root.right == null) {
                root = null;
            }
            //root has a right child. find a successor to replace this node
            else if(root.right != null) {
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            //find a predecessor to replace this node
            else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    //Trying to find the least value below the right child of this root node
    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    //Trying to find the greatest value below the left child of this root node
    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
