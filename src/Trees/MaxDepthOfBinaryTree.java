package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int value){
            this.value = value;
        }
    }
    public static int getHeight(Node node){
        if(node == null) return -1;
        return node.height;
    }
    public static int maxDepthOfBinaryTree(Node node){
        Queue<Node> qs = new LinkedList<>();
        qs.add(node);
        int heightOfTree = 0;
        while(!qs.isEmpty()){
            node = qs.poll();
            if(node.left !=null){
                qs.add(node.left);
            }
            if(node.right !=null){
                qs.add(node.right);
            }
            heightOfTree = Math.max(getHeight(node.left),getHeight(node.right))+1;
        }
        return heightOfTree;
    }
    public static void main(String args[]){
        Node rootNode = new Node(1);
        rootNode.left=new Node(2);
        rootNode.right=new Node(3);;
        rootNode.right.left=new Node(4);
        rootNode.right.left.left=new Node(5);
        rootNode.right.right=new Node(6);
        int height = maxDepthOfBinaryTree(rootNode);
        System.out.println("Height of the tree"+height);

    }
}
