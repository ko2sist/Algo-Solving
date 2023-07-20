import java.io.*;
import java.util.*;

// BJ #1018
public class Main {
    public static int check(char[][] chess, int row, int col) {
        int r = (row+col)%2;  // remainder
        int rc = 0;       // Case1: Remaining color of the first square
        int cc = 0;      // Case2: Change color of the first square

        for (int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((row+i+col+j)%2 == r) {
                    if(chess[row+i][col+j] != chess[row][col]) {
                        rc += 1;
                    } else{
                        cc +=1;
                    }
                } else {
                    if(chess[row+i][col+j] == chess[row][col]) {
                        rc += 1;
                    }else{
                        cc +=1;
                    }
                }
            }
        }
        return Math.min(rc,cc);
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min_change = N*M;

        char[][] chess = new char[N][M];
        for (int i=0; i<N; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if((i+8<=N) && (j+8<=M)) {
                    int tmp = check(chess,i,j);
                    if(tmp<=min_change) {
                        min_change = tmp;
                    }
                }
            }
        }

        System.out.println(min_change);


    }
}