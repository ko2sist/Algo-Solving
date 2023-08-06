import java.util.*;
import java.io.*;

// BJ #1927
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	if(tmp == 0) {
        		if(minHeap.isEmpty()) {
        			sb.append(0).append("\n");
        		}else {
        			sb.append(minHeap.poll()).append("\n");
        		}
        	}else {
        		minHeap.add(tmp);
        	}
        }
        
        // 최종 결과 출력
        System.out.println(sb);    
	}
}