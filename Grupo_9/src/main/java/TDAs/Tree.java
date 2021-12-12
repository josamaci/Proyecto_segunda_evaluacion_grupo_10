package TDAs;
public class Tree<T> {
    NodeTree<T> root;

    public Tree(NodeTree<T> root) {
        this.root = root;
    }
    
    public Tree() {
        this.root = null;
    }
}
