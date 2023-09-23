import java.util.*;
import java.io.*;

// BJ #1644 - 소수의 연속합
// Strategy: 에라토스테네스의 체, 투 포인터

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N: 계산하고자 하는 정수
		int N = Integer.parseInt(br.readLine());
		
		// 에라토스테네스의 체 실행
		boolean[] prime = new boolean[N+1];
		for(int i=2; (i*i)<=N; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=N; j += i) {
					prime[j] = true;
				}
			}
		}
		
		// N이하 소수들의 목록 저장
		List<Integer> primeList = new ArrayList<>();
		for(int i=2; i<=N; i++) {
			if(!prime[i]) primeList.add(i);
		}
		
		int cnt = 0;
		int end = 0;
		int sum = 0;
		int size = primeList.size();
		for(int start=0; start<size; start++) {
			while(sum < N && end < size) {
				sum += primeList.get(end);
				end++;
			}
			
			if(sum == N) {
				cnt++;
			}
			
			sum -= primeList.get(start);
		}
		
		System.out.println(cnt);
    }
}