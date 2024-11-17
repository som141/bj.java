package sorting;

public class QuickSelct {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        int k = 3;

        System.out.println(k + "rd smallest element is: " + quickSelect(arr, k));
    }
    public static int quickSelect(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        // k번째 작은 값은 0-based index로 변환
        k = k - 1;

        while (left <= right) {
            // 피벗 선택 (마지막 요소 사용)
            int pivot = arr[right];
            int partitionIndex = left;

            // 분할 작업
            for (int i = left; i < right; i++) {
                if (arr[i] < pivot) {
                    swap(arr, i, partitionIndex);
                    partitionIndex++;
                }
            }

            // 피벗을 제 위치로 이동
            swap(arr, partitionIndex, right);

            // k번째 값과 피벗 위치 비교
            if (partitionIndex == k) {
                return arr[partitionIndex]; // k번째 원소 찾음
            } else if (partitionIndex < k) {
                left = partitionIndex + 1; // 오른쪽으로 이동
            } else {
                right = partitionIndex - 1; // 왼쪽으로 이동
            }
        }

        return -1; // k가 유효하지 않은 경우 (예외 처리)
    }
    static void swap(int []arr ,int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
