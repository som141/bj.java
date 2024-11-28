package goldRandomDepense;

import java.util.Optional;

public class saChon {
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(5);
        node.right=node1;
        node1.left=node2;
        node.left=node3;
        node1.right=node4;
        node.preorder(node);
    }

    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void preorder(Node node){
            if(node==null) {
                return ;
            }
                System.out.println(node.data);
                preorder(node.left);
                preorder(node.right);

        }
    }
}
