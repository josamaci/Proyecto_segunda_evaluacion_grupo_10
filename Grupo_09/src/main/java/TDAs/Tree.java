package TDAs;

import java.util.LinkedList;

public class Tree<T> {
    NodeTree<T> root;

    public Tree(NodeTree<T> root) {
        this.root = root;
    }
    
    public Tree() {
        this.root = null;
    }

    public NodeTree<T> getRoot() {
        return root;
    }

    public void setRoot(NodeTree<T> root) {
        this.root = root;
    }
    
    public LinkedList<Tree<T>> getChildren(){
        return root.getChildren();
    }
    
    public boolean isEmpty(){
        return this==null || this.root==null;
    }
    
    public boolean isLeaf() {
        return this.root.getChildren()==null;
    }
    
    public Tree<T> getChild(int index){
        return this.root.getChildren().get(index);
    }
    
}
