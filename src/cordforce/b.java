package cordforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] array = new int[n][m];
            for (int j = 0; j < n; j++) {
                String s1 = br.readLine();
                StringTokenizer st1 = new StringTokenizer(s1);
                for (int k = 0; k < m; k++) {
                    array[j][k] = Integer.parseInt(st1.nextToken());
                }
            }
            int index=-1;
            Integer[] indices = new Integer[n];
            for (int i1 = 0; i1 < n; i1++) {
                indices[i1] = i1;
            }
            for (int j = 0; j < m; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    set.add(array[k][j]);
                }
                if(n== set.size()){
                    index=j;
                }
            }
            if(index==-1){
                System.out.println(-1);
                continue;
            }
            final int in=index;
            Arrays.sort(indices, Comparator.comparingInt(i2 -> array[i2][in]));

            if (solve(array, indices,m)) {
                for (int j1 = 0; j1 < n; j1++) {
                    System.out.print(indices[j1] + 1 + " ");
                }
                if(i!=c-1){
                System.out.println();}

            } else {
                System.out.println(-1);
            }
        }

        }

    private static boolean solve(int[][] array, Integer[] indices,int m) {
            for(int j=0;j<m;j++) {
                int min=Integer.MIN_VALUE;
                for(int i :indices) {
                    if (array[i][j] <= min) {
                        return false;
                    }
                    min = array[i][j];
                }
            }

        return true;
    }
}
