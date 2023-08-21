import java.io.*;
import java.util.*;

// BJ #9663 - N-Queen
// Strategy: 백트래킹
public class Main {
	static int N, res;
	
	public static void nQueen(int[] arr, int row) {
		if(row == N) {		// 모든 행이 채워 졌을 경우 결과 값 1 증가
			res++;
			return;
		}
		
		loop: for(int i=0; i<N; i++) {		// arr에서 idx는 행, arr[idx]는 열을 나타낸다고 생각 가능
			arr[row] = i;
			for(int j=0; j<row; j++) {		// 각 행을 순회
				if(arr[row] == arr[j]) continue loop;	// 동일한 열에 있는 quenn이 존재할 경우 continue
				if(Math.abs(row-j) == Math.abs(i-arr[j])) continue loop;	// 대각선에 queen이 존재할 경우(열의 차 == 행의 차)
			}
			nQueen(arr, row+1);				// 현재 위치에 queen이 들어갈 수 있을 경우 재귀 실행(다음 행에 대해)
		}
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //
        N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        res = 0;
        
        nQueen(arr,  0);
        System.out.println(res);
    }
}