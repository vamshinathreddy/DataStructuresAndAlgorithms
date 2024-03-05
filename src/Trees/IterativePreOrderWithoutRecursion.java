package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderWithoutRecursion {
        public IterativePreOrderWithoutRecursion() {
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
        public static List<Integer> preOrder(Node node){
            Stack<Node> stk = new Stack<Node>();
            List<Integer> ls = new ArrayList<Integer>();
            stk.add(node);
            while(!stk.isEmpty()){
                Node element = stk.pop();
                ls.add(element.value);
                if(element.right !=null) stk.add(element.right);
                if(element.left !=null) stk.add(element.left);
            }
            return ls;
        }

        public static void main(String args[]){
            int[] values = {5,1,3,4,2,7,6,8};
            //int[] values = {1,2,3,4,5,6,7};
            IterativePreOrderWithoutRecursion bin = new IterativePreOrderWithoutRecursion();
            Node rootNode = null;
            for(int i=0;i<values.length;i++){
                if(rootNode !=null)
                    System.out.println(rootNode.value);
                rootNode = bin.insert(rootNode,values[i]);
            }
            List<Integer> ls = preOrder(rootNode);
            ls.forEach(System.out::print);
            //System.out.println("final o/p"+ls.stream().toArray().toString());
        }

}
