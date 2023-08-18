import java.util.*;
import java.io.*;

// SWEA #16744 - 마이쭈시뮬레이션
// Strategy: Queue
class Solution {
	public static class Pair{	// num: 사람 번호, candy: 받을 마이쭈 개수
		int num;
		int candy;
		
		public Pair(int num, int candy) {
			this.num = num;
			this.candy = candy;
		}
		
		public void addCandy() {
			this.candy++;
		}
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	
        	// 마이쭈 개수
        	int N = Integer.parseInt(br.readLine());
        	
        	Queue<Pair> q = new LinkedList<>();
        	q.add(new Pair(1,1));	// 초기엔 1번만 줄을 서있음
        	
        	
        	int cnt = 1;
        	int res = 0;
        	while(true) {
        		Pair tmp = q.poll();
        		N -= tmp.candy;		// 줄 맨 앞에 있는 사람이 마이쭈 수령
        		
        		if(N <= 0) {		// 마이쭈가 다 떨어지면 반복문 종료
        			res = tmp.num;	// 마지막으로 마이쭈 받은 사람 번호 저장
        			break;
        		}
        		
        		tmp.addCandy();		// 현재 받은 사람은 다음에 마이쭈 1개 더 받음
        		q.add(tmp);			// 다시 줄서기
        		
        		q.add(new Pair(cnt+1,1));	// 새로운 사람 줄서기
        		cnt++;						// 사람수 ++
        	}
        	
        	// 결과 저장
        	sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}