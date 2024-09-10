package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class    sortTree {
    static int tree[];
    static public void preorder(int[]arr,int i){
        System.out.println(arr[i]);
        if(2*i+1<arr.length) {
            preorder(arr, 2 * i + 1);
            preorder(arr, 2 * i + 2);
        }
    }
    static public void inorder(int[]arr,int i){
        if(2*i+1<arr.length) {
            inorder(arr, 2 * i + 1);
        }
        System.out.println(arr[i]);
        if(2*i+1<arr.length) {
            inorder(arr, 2 * i + 2);
        }
    }
    static public void postorder(int[]arr,int i){
        if(2*i+1<arr.length) {
            postorder(arr, 2 * i + 1);
        }
        if(2*i+1<arr.length) {
            postorder(arr, 2 * i + 2);
        }
        System.out.println(arr[i]);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        tree = new int[num];
        for(int i=0;i<num;i++){
            tree[i]= Integer.parseInt(bufferedReader.readLine());
        }
        preorder(tree,0);
        inorder(tree,0);
        postorder(tree,0);

    }
}
