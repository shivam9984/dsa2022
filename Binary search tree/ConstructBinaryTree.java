import java.util.Scanner;

public class ConstructBinaryTree {
    private  int value ;
    private ConstructBinaryTree left;
    private ConstructBinaryTree right;



    public ConstructBinaryTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setLeft(ConstructBinaryTree left) {
        this.left = left;
    }

    public void setRight(ConstructBinaryTree right) {
        this.right = right;
    }

    public void  setValue(int value) {
        this.value=value;

    }

    public int getValue() {
        return value;
    }

    public ConstructBinaryTree getLeft() {
        return left;
    }

    public ConstructBinaryTree getRight() {
        return right;
    }
}



