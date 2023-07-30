import java.io.*;
import java.util.*;

// BJ #1966
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // T: testcase 개수
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	// N,M 입력
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	int[] arr = new int[9];
        	Queue<Integer> q = new LinkedList<>();
        	
        	// 문서들을 queue에 저장, 빈도수는 배열로 관리
        	// m에 M번째 문서의 우선순위 저장
        	// M번째 문서는 구별을 위해 0으로 queue에 저장
        	int m = 0;
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[tmp-1]++;
        		if(j == M) {
        			q.add(0);
        			m = tmp;
        		}else {
        			q.add(tmp);
        		}
        	}
        	// 현재까지 출력된 문서의 개수를 저장하는 cnt
        	int cnt = 0;
        	int priority = 9;
        	
        	// 출력순서 계산
        	// tmp: queue에서 poll된 문서의 우선순위 저장
        	while(true) {
        		int tmp = 0;
        		if(arr[priority-1] == 0) {
        			priority--;
        			continue;
        		}else if(priority>m){
        			tmp = q.poll();
        			if(tmp==priority) {
        				cnt++;
        				arr[priority-1]--;
        			}else {
        				q.add(tmp);
        			}
        		}else {
        			tmp = q.poll();
        			if(tmp == 0) {
        				cnt++;
        				sb.append(cnt).append("\n");
        				break;
        			}else if(tmp == m){
        				cnt++;
        				arr[priority-1]--;
        			}else {
        				q.add(tmp);
        			}
        		}
        		
        		
        		
        	}
        	
        	
        }
        System.out.println(sb);
    }
}