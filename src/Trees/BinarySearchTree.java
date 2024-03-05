package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public BinarySearchTree(){
    }
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public Node insert(Node node, int value){
        if(node == null){
            node  = new Node(value);
            return node;
        }
        if(value < node.value){
           node.left = insert(node.left,value);
        }
        if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }

    //Pre-order
    public static void preorder(Node node){
        if(node == null) return;
        System.out.print(""+node.value);
        preorder(node.left);
        preorder(node.right);
    }
    //In-Order
    public static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(""+node.value);
        inorder(node.right);
    }
    //post-order
    public static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(""+node.value);
    }
    //level-order
    public static void levelOrder(Node node){
        Queue<Node> nos = new LinkedList<>();
        if(node == null) return;
        nos.add(node);  
        while(!nos.isEmpty()){
            Node element = nos.poll();
            System.out.print(+element.value);
            if(element.left !=null) nos.add(element.left);
            if(element.right !=null ) nos.add(element.right);
            System.out.println("-------");
        }
    }


    public static void main(String args[]){
        //int[] values = {5,1,3,4,2,6,7,8,9};
        int[] values = {1,2,3,4,5,6};
        BinarySearchTree bin = new BinarySearchTree();
        Node rootNode = null;
        for(int i=0;i<values.length;i++){
            if(rootNode !=null)
                System.out.println(rootNode.value);
            rootNode = bin.insert(rootNode,values[i]);
        }
        preorder(rootNode);
        System.out.println("\n");
        inorder(rootNode);
        System.out.println("\n");
        postOrder(rootNode);
        levelOrder(rootNode);
    }
}
