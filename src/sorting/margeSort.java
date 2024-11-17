package sorting;

import java.util.Arrays;

public class margeSort {
    public static void main(String[] args) {
        int [] i={1,4,64,3,7,9,4,3};
        mergesort(i);
        for(int i1:i){
            System.out.println(i1);
        }
    }
    static void mergesort(int[] arr){
        if(arr.length<2){
            return;
        }
        int mid = arr.length/2;
        int []left = Arrays.copyOfRange(arr, 0, mid);
        int []right = Arrays.copyOfRange(arr, mid, arr.length);

        mergesort(left);
        mergesort(right);

        merge(arr,left,right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0,k =0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
        while(j<right.length){
            arr[k++] = right[j++];
        }
    }
}
