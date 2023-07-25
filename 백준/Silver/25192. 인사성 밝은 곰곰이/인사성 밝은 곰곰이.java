import java.io.*;
import java.util.*;

// BJ #25192
public class Main {
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        HashSet<String> ids = new HashSet<>();
        int res = 0;
        
        for(int i=0; i<N; i++){
        	String s = br.readLine();
        	if(s.equals("ENTER")) {
        		res += ids.size();
        		ids.clear();
        	}else {
        		ids.add(s);
        	}
        }
        res += ids.size();
        
        
        System.out.println(res);
    }
}