package segmentTree;

import java.io.*;
import java.util.*;

public class Main1 {
    private long[] tree; // 세그먼트 트리 배열
    private int size;    // 트리의 크기

    public Main1(int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        this.size = (int) Math.pow(2, h + 1);
        this.tree = new long[size];
    }

    // 초기 배열을 기반으로 세그먼트 트리 생성
    public long init(long[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
    }

    // 구간 합을 구하는 메서드
    public long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) { // 구간 밖에 있는 경우
            return 0;
        }
        if (left <= start && end <= right) { // 구간 안에 완전히 포함된 경우
            return tree[node];
        }
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }

    // 특정 인덱스의 값을 업데이트하는 메서드
    public void update(int node, int start, int end, int index, long newValue) {
        if (index < start || index > end) { // 구간 밖에 있는 경우
            return;
        }
        if (start == end) { // 리프 노드에 도달한 경우
            tree[node] = newValue;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, newValue);
        update(node * 2 + 1, mid + 1, end, index, newValue);
        tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 부모 노드를 업데이트
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 변경 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간 합 구하기 횟수

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 생성 및 초기화
        Main1 segTree = new Main1(n);
        segTree.init(arr, 1, 0, n - 1);

        // M+K개의 쿼리 처리
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 업데이트 연산
                segTree.update(1, 0, n - 1, b - 1, c);
                arr[b - 1] = c; // 실제 배열도 업데이트
            } else if (a == 2) { // 구간 합 쿼리
                long result = segTree.query(1, 0, n - 1, b - 1, (int) c - 1);

            }
        }

        for(long sd:segTree.tree){
            System.out.println();
        }
    }
}
