import java.util.*;
import java.io.*;

// BJ #11659
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	Map<String, List<String>> m = new HashMap<>();
        	for(int j=0; j<N; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		String element = st.nextToken();
        		String part = st.nextToken();
        		if(m.containsKey(part)) {
        			List<String> tmp = m.get(part);
        			tmp.add(element);
        			m.put(part, tmp);
        		}else {
        			List<String> tmp = new ArrayList<>();
        			tmp.add(element);
        			m.put(part, tmp);
        		}
        	}
        	int[] arr = new int[m.size()];
        	int idx = 0;
        	for(String key : m.keySet()) {
        		arr[idx] = m.get(key).size();
        		idx++;
        	}
        	
        	int res = 1;
        	for(int j=0; j<m.size(); j++) {
        		res *= arr[j]+1;
        	}
        	sb.append(res-1).append("\n");
        }
        System.out.println(sb);
        
	}
}