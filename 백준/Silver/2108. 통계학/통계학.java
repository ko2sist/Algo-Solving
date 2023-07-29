import java.io.*;
import java.util.*;

// BJ #2108
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        	
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        
        // 정수 입력
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	arr[tmp+4000]++;
        }
        
        // 산술평균 계산을 위한 sum
        int sum = 0;
        // 중앙값 계산을 위한 cnt, med, med_check
        int cnt = 0;
        int med = 0;
        int med_check = 0;
        // 최빈값 계산을 위한 cnt2, mode, mode_pq
        int cnt2 = 1;
        int mode = 0;
        PriorityQueue<Integer> mode_pq = new PriorityQueue<Integer>();
        // 범위 계산을 위한 max, min;
        int max = -4000;
        int min = 4000;
        
        for(int i=-4000; i<4001; i++) {
        	// 산술평균 
        	sum += arr[i+4000]*i;
        	
        	// 중앙값 
        	cnt += arr[i+4000];
        	if(med_check == 0 && cnt>=(N+1)/2) {
        		med = i;
        		med_check = 1;
        	}
        	
        	// 최빈값을 위한 최대 빈도 찾기
        	if(arr[i+4000]>=cnt2) {
        		cnt2 = arr[i+4000];
        	}
        	
        	// 범위
        	if(i<=min && arr[i+4000]!=0) {
        		min = i;
        	}
        	if(i>=max && arr[i+4000]!=0) {
        		max = i;
        	}
        }
        
        // 최빈값 pq에 넣기
        for(int i=-4000; i<4001; i++) {
        	if(arr[i+4000]==cnt2) {
        		mode_pq.add(i);
        	}
        }
        
        // 최빈값 회수 중복 처리
        if(mode_pq.size()>=2) {
        	mode_pq.poll();
        }
        mode = mode_pq.poll();
        
        // 결과 출력
        sb.append(Math.round(sum/(double)N)).append("\n");
        sb.append(med).append("\n");
        sb.append(mode).append("\n");
        sb.append(max-min);
        System.out.print(sb);
    }
}