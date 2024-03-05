package Trees;

import javax.xml.soap.Node;
import java.util.Scanner;

public class BinaryTree {
    private Node rootNode;
    private static class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public BinaryTree(){

    }
    public void populate(Scanner scanner){
        System.out.println("Enter the root node ");
        int value = scanner.nextInt();
        rootNode= new Node(value);
        populate(rootNode,scanner);

    }
    private void populate(Node node, Scanner scanner){
        System.out.println("Do you want the enter the value to the left of Node"+node.data);
        boolean leftvalue = scanner.nextBoolean();
        if(leftvalue){
            System.out.println("left value of root"+node.left);
            int left = scanner.nextInt();
            node.left = new Node(left);
            populate(node.left,scanner);
        }
        System.out.println("Do you want the enter the value to the right of Node"+node.data);
        boolean rightvalue = scanner.nextBoolean();
        if(rightvalue ){
            System.out.println("right value of root"+node.right);
            int left = scanner.nextInt();
            node.right = new Node(left);
            populate(node.right,scanner);
        }
    }

    public void display(){
        System.out.println("Display the tree");
        display(rootNode,"");
    }
    public void display(Node node,String indent){
        if(node == null) return;
        System.out.println("Node values"+node.data);
        display(node.left,"\t");
        display(node.right,"\t");
    }

    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);
        tree.display();
    }
}
