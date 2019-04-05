public class BST<T> {

    private BSTNode root;

    /**
     * The constructor
     */
    public BST() {

    }

    /**
     * Inserts the value at the right place by calling the recursive part
     *
     * @param value the value to add to the tree
     */
    public void insert(Comparable value) {
        //Sets the root to the first value inserted
        if (root == null) {
            root = new BSTNode<T>(value);
        } else {
            root = insert(value, root);
        }
    }

    /**
     * The recursive part to insert
     *
     * @param value the value to add to the array
     * @param node  the current node in the tree
     * @return the added node
     */
    public BSTNode insert(Comparable value, BSTNode node) {
        if (node == null) {
            return new BSTNode<T>(value);
        }
        if (node.getData().compareTo(value) < 0) {
            node.setRight(insert(value, node.getRight()));
        } else {
            node.setLeft(insert(value, node.getLeft()));
        }
        return node;
    }

    /**
     * finds a value in the tree by calling the recursive part
     *
     * @param value the value to find
     * @return true if found, false if not found
     */
    public boolean find(Comparable value) {
        return find(value, root);
    }

    /**
     * The recursive part of find, calls itself until it find it
     *
     * @param value the value to find
     * @param node  the current node in the tree
     * @return true if found, false if not found
     */
    public boolean find(Comparable value, BSTNode node) {
        //returns false if reaches the end of the tree without finding the value
        if (node == null) {
            return false;
        } else if (node.getData() == value) {
            return true;
        } else if (node.getData().compareTo(value) > 0) {
            return find(value, node.getLeft());
        } else {
            return find(value, node.getRight());
        }
    }

    /**
     * Prints the whole tree by calling the recursive part
     */
    public void print() {
        print(root);
    }

    /**
     * Calls itself to print everything to the left, then current on the way up,
     * then everything on the right so its all in order
     *
     * @param node the current node of the tree
     */
    public void print(BSTNode<T> node) {
        if (node != null) {
            print(node.getLeft());
            System.out.println(node.getData());
            print(node.getRight());
        }
    }

    /**
     * deletes the value by calling the recursive part
     *
     * @param value teh value to delete
     */
    public void delete(Comparable value) {
        if (root.getData().compareTo(value) == 0) {
            root.setData("");
        } else {
            delete(root, value);
        }
    }

    /**
     * Split into three parts, if the value has no children, if it has
     * one child, or if it has two children
     *
     * @param node  the current node
     * @param value teh value to delete
     * @return the node that was deleted
     */
    public BSTNode delete(BSTNode node, Comparable value) {
        if (node == null) {
            return null;
        }
        if (node.getData().compareTo(value) == 0) {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                if (node.getRight().getLeft() == null) {
                    node.setData(node.getRight().getData());
                    node.setRight(node.getRight().getRight());
                    return node;
                } else {
                    node.setData(removeSmallest(node.getRight()));
                    return node;
                }
            }
        } else if (node.getData().compareTo(value) > 0) {
            node.setLeft(delete(node.getLeft(), value));
            return node;
        } else {
            node.setRight(delete(node.getRight(), value));
            return node;
        }
    }

    /**
     * sets the node from delete to the next largest node and deletes
     * that value, called for the 2 children scenario
     *
     * @param node the right node of the one to delete
     * @return the data from the successor
     */
    public Comparable removeSmallest(BSTNode node) {
        if (node.getLeft().getLeft() == null) {
            Comparable smallest = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return smallest;
        } else {
            return removeSmallest(node.getLeft());
        }
    }
}
