public class BSTNode<T> {

    private BSTNode left;
    private BSTNode right;
    private Comparable<T> data;

    public BSTNode() {
        this.left = null;
        this.right = null;
        this.data = null;
    }

    public BSTNode(Comparable<T> data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public Comparable<T> getData() {
        return data;
    }

    public void setData(Comparable<T> data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}