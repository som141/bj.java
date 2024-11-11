package segmentTree;

public class ex1 {
    public static void main(String[] args) {
        int arr[]= {1,2,3,5,7,10,25};
        //값 처음 끝 조사할꺼임
        System.out.println(binarySearch(arr,5,0,arr.length-1));
    }
    static int binarySearch(int arr[],int cost,int start,int end) {
        if(start>end){
            return -1;
        }
        if(arr[(start+end)/2]<cost){
            return binarySearch(arr,cost,(start+end)/2+1,end);
        } else if (arr[(start+end)/2]>cost) {
            return binarySearch(arr,cost,start,(start+end)/2-1);
        } else {
            return arr[(start+end)/2];
        }
    }
}
