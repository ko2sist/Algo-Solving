import java.util.*;
import java.io.*;

// BJ #1244 - 스위치 켜고 끄기
// Idea: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 스위치 개수 
		// onoff : 스위치의 상태를 저장하는 배열
		int N = Integer.parseInt(br.readLine());
		boolean[] onoff = new boolean[N];
		
		// 스위치 초기 상태 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == 1) {
				onoff[i] = true;
			}else {
				onoff[i] = false;
			}
			
		}
		
		// M: 학생 수
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// 현재 학생이 남학생인 경우
			if(gender == 1) {
				for(int j=0; j<N; j++) {
					if((j+1) % num == 0) {
						onoff[j] = !onoff[j];
					}
				}

			// 현재 학생이 여학생인 경우
			}else {
				int cnt = 1;
				onoff[num-1] = !onoff[num-1];
				while(true) {
					// index가 범위를 벗어나면 반복문 종료
					if(num-1-cnt < 0 || num-1+cnt >= N) {
						break;
					}
					
					boolean front = onoff[num-1-cnt];
					boolean back = onoff[num-1+cnt];
					
					// 대칭이 이루어 지지 않으면 반복문 종료
					if(front != back) {
						break;
					}else {
						onoff[num-1-cnt] = !front;
						onoff[num-1+cnt] = !back;
						cnt++;
					}
				}
			}
		}
		
		// 결과 저장
		for(int i=0; i<N/20+1; i++) {
			for(int j=0; j<20; j++) {
				if(i == N/20 && j == N%20) {
					break;
				}else {
					if(onoff[i*20 + j]) {
						sb.append(1).append(" ");
					}else {
						sb.append(0).append(" ");
					}
				}
			}
			sb.append("\n");
		}
		
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
