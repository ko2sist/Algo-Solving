import java.io.*;
import java.util.*;

// BJ #1072 - 게임
// Strategy: 수식
// X: 게임 횟수, Y: 이긴 게임 수, Z: 형택이의 승률(소수점 버림), N: 앞으로 더 할 게임 수
// (Y+N)/(X+N)*100 >= Z+1
// => 100Y+100N >= (Z+1)(X+N) = XZ + ZN + X + N = N(Z+1) + (XZ+X)
// => (99-Z)N >= XZ + X -100Y
// => N >= (XZ+X-100Y)/(99-Z), 계산결과가 소수로 나올수도 있어서 Math.ceil 사용
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		
		int Z = (int)((Y*100)/X);
		
		if(Z < 99) {
			System.out.println((int)Math.ceil(((Z+1)*X-100*Y)/(double)(99-Z)));
		}else {
			System.out.println(-1);
		}
		
	}
}