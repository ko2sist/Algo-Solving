import java.io.*;
import java.util.*;

// BJ #15654 - N과 M(5)
// Strategy: 백트래킹
public class Main {
	static int[] nums;
	static int N, M;
	static StringBuilder sb;
	
    public static void NM5(boolean visited[], int[] selected, int len) {
        if(len == M) {
        	for(int i=0; i<selected.length; i++) {
        		sb.append(selected[i]).append(" ");
        	}
        	sb.append("\n");
        	return;
        }
        for(int i=0; i<N; i++) {
        	if(!visited[i]) {
        		selected[len] = nums[i];
        		visited[i] = true;
        		NM5(visited, selected, len+1);
        		visited[i] = false;
        	}
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[N];
        int[] selected = new int[M];
        NM5(visited, selected, 0);
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}