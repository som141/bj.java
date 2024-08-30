package tree;

import java.io.BufferedReader;

public class heap {
    public void heapify(int[] arr, int n, int i) {
        int largest = i;  // 루트를 가장 큰 값으로 초기화
        int left = 2 * i + 1;  // 왼쪽 자식 노드
        int right = 2 * i + 2; // 오른쪽 자식 노드

        // 왼쪽 자식 노드가 루트보다 크면
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 오른쪽 자식 노드가 가장 큰 노드보다 크면
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 가장 큰 노드가 루트가 아니라면, 교환 후 힙을 다시 정렬
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 재귀적으로 힙을 재정렬
            heapify(arr, n, largest);
        }
    }

    // 힙 정렬 메서드
    public void sort(int[] arr) {
        int n = arr.length;

        // 배열을 최대 힙으로 변환
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 힙에서 요소를 하나씩 추출하여 배열 끝으로 이동
        for (int i = n - 1; i > 0; i--) {
            // 현재 루트(최대값)를 끝으로 이동
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 루트를 제외한 나머지 부분을 최대 힙으로 변환
            heapify(arr, i, 0);
        }
    }

    // 배열 출력 메서드
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 메인 메서드
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        heap heapSort = new heap();
        heapSort.sort(arr);

        System.out.println("정렬된 배열:");
        printArray(arr);
    }
}
