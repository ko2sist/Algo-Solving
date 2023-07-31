import java.util.*;
import java.io.*;

// BJ #1764
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        
        for(int i=0; i<N; i++) {
        	s1.add(br.readLine());
        }
        for(int i=0; i<M; i++) {
        	s2.add(br.readLine());
        }
        s1.retainAll(s2);
        Set<String> ts = new TreeSet<>();
        ts.addAll(s1);
        
        sb.append(ts.size()).append("\n");
        for(String s : ts) {
        	sb.append(s).append("\n");
        }
        // 최종 결과 출력

        System.out.println(sb);
    }
}