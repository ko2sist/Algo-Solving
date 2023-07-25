import java.io.*;
import java.util.*;

// BJ #10814
public class Main {
    // Member: 회원 정보를 담은 class
	public static class Member implements Comparable<Member>{
    	int age;
    	String name;
    	int uid;
    	
    	public Member(int age, String name, int uid) {
    		this.age = age;
    		this.name = name;
    		this.uid = uid;   // age가 같을 때를 위한 입력순 uid
    	}
    	
    	// 회원 나이로만 비교, 나이 같으면 입력순
		@Override
		public int compareTo(Member o) {
			if(this.age == o.age) {
				return this.uid - o.uid;
			}else {
				return this.age - o.age;
			}
		}
    }
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        	
        // N: 회원 수
        int N = Integer.parseInt(br.readLine());
        
        // pq: 회원 정보를 저장하기 위한 priority queue
        PriorityQueue<Member> pq = new PriorityQueue<>();
        
        // N명의 회원 정보 저장
        for (int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int age = Integer.parseInt(st.nextToken());
        	String name = st.nextToken();
        	
        	pq.add(new Member(age,name,i));
        }
        
        // 회원 정보 출력
        while(!pq.isEmpty()) {
        	Member m = pq.poll();
        	sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.print(sb);
    }
}