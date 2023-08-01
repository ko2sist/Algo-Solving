import java.util.*;
import java.io.*;

// BJ #17219
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, String> m = new HashMap<>();
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String site = st.nextToken();
        	String pw = st.nextToken();
        	m.put(site, pw);
        }
        
        for(int i=0; i<M; i++) {
        	String tmp = br.readLine();
        	sb.append(m.get(tmp)).append("\n");
        }
       
        // 최종 결과 출력
        System.out.println(sb);
    }
}