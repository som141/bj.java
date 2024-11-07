package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] array;
    static Queue<Graph> queue;
    static int N;

    public static void main(String[] args) throws IOException {
        array = new int[10][10];
        queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            String s = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(s);
            for (int j = 1; j <= 9; j++) {
                int input = Integer.parseInt(tokenizer.nextToken());
                if (input == 0) {
                    queue.add(new Graph(i, j));
                }
                array[i][j] = input;
            }
        }
        N = queue.size();
        sudoku(0);  // 시작은 0번 빈 칸
    }

    static boolean sudoku(int n) {
        if (n == N) {
            printSudoku();
            return true;
        }

        Graph graph = (Graph) queue.toArray()[n];
        int i = graph.i;
        int j = graph.j;

        for (int num = 1; num <= 9; num++) {
            if (isValid(i, j, num)) {
                array[i][j] = num;

                if (sudoku(n + 1)) {
                    return true;
                }

                array[i][j] = 0;  // 백트래킹
            }
        }
        return false;  // 가능하지 않으면 돌아감
    }

    static boolean isValid(int row, int col, int num) {
        for (int x = 1; x <= 9; x++) {
            if (array[row][x] == num || array[x][col] == num) {
                return false;
            }
        }

        int startRow = (row - 1) / 3 * 3 + 1;
        int startCol = (col - 1) / 3 * 3 + 1;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (array[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printSudoku() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Graph {
        int i, j;

        public Graph(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "i = " + i + ", j = " + j;
        }
    }
}
