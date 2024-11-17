package sorting;

import java.util.Random;

public class Test {
    int kth(int[] a, int k) {
        int ans=quickSelect1(a,k);
        return ans;
    }

    private int quickSelect1(int[] a, int k) {
        k=k-1;
        int left=0,right=a.length-1;
        Random rand = new Random();
        while(left<=right) {
            int pivotIndex= left+rand.nextInt(right-left+1);
            int pivot=a[pivotIndex];
            swap(a,pivotIndex,right);
            int partition=left;  //맨 왼쪽부터 서치

            //분할
            for(int i=left;i<right;i++) {
                if(a[i]<pivot||(a[i]==pivot&&i<pivotIndex)) {
                    swap(a,i,partition);
                    partition++;
                }
            }
            swap(a,partition,right);

            //검증
            if(partition==k){
                return a[partition];
            }else if(partition<k){
                left=partition+1;
            }else {
                right=partition-1;
            }

        }
        return 0;
    }
    private void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
