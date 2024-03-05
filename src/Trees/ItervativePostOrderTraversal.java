package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ItervativePostOrderTraversal {
    private static class Node{
        int value;
        ItervativePostOrderTraversal.Node left;
        ItervativePostOrderTraversal.Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public static List<Integer> postOrder(Node node){
        Stack<Node> st = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        List<Integer> ar = new ArrayList<>();

        if(node == null) return ar;
        st.push(node);
        while(!st.isEmpty()) {
            node= st.pop();
            st2.push(node);
            if (node.left != null) {
                st.push(node.left);
            }
            if (node.right != null) {
                st.push(node.right);
            }
        }
        while(!st2.isEmpty()){
            ar.add(st2.pop().value);
        }
        return ar;

    }
    public static void postOrderUsingSingleStack(Node node){
        Stack<Node> st = new Stack<>();
        boolean check = true;
        while(true){
            while(node !=null && check){
                node = st.push(node);
                node = node.left;
            }
            if(st.isEmpty()) return;
            if(node != st.peek().right){
                node = st.peek().right;
                check=true;
                continue;
            }
            node = st.pop();
            System.out.print(node.value);
            check = false;
        }
    }

    public static void main(String args[]){
        int[] values = {1,2,3,4,5,6,7,8};
        //int[] values = {1,2,3,4,5,6,7};
        ItervativePostOrderTraversal bin = new ItervativePostOrderTraversal();
        Node rootNode = new Node(8);
        rootNode.left=new Node(6);
        rootNode.right=new Node(10);;
        rootNode.left.left=new Node(5);
        rootNode.left.right=new Node(7);
        rootNode.left.left.left=new Node(1);
        rootNode.right.left=new Node(9);
        rootNode.right.right=new Node(12);
        /*for(int i=0;i<values.length;i++){
            if(rootNode !=null)
            rootNode = bin.insert(rootNode,values[i]);
        }*/
        List<Integer> ls = postOrder(rootNode);
        ls.forEach(System.out::print);
        System.out.println("single stack");
        postOrderUsingSingleStack(rootNode);
    }
}
