import java.io.*;
import java.util.*;

// BJ #11723
public class Main {
    public static class MySet{
    	private List<Integer> list = new ArrayList<>();
    	
    	public void add(int x) {
    		if(!list.contains(x)) {
    			list.add(x);
    		}
    	}
    	
    	public void remove(int x) {
    		for(int i=0; i<list.size(); i++) {
    			if(list.get(i) == x) {
    				list.remove(i);
    			}
    		}
    	}
    	
    	public int check(int x) {
    		if(list.contains(x)) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    	
    	public void toggle(int x) {
    		for(int i=0; i<list.size(); i++) {
    			if(list.get(i) == x) {
    				list.remove(i);
    				return;
    			}
    		}
    		list.add(x);
    	}
    	
    	public void all() {
    		this.empty();
    		for(int i=1; i<21; i++) {
    			list.add(i);
    		}
    	}
    	
    	public void empty() {
    		list = new ArrayList<>();
    	}
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        MySet s = new MySet();
        for(int i=0; i<M; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String cmd = st.nextToken();
        	if("add".equals(cmd)) {
        		s.add(Integer.parseInt(st.nextToken()));
        	}else if("remove".equals(cmd)) {
        		s.remove(Integer.parseInt(st.nextToken()));
        	}else if("check".equals(cmd)) {
        		sb.append(s.check(Integer.parseInt(st.nextToken()))).append("\n");
        	}else if("toggle".equals(cmd)) {
        		s.toggle(Integer.parseInt(st.nextToken()));
        	}else if("all".equals(cmd)) {
        		s.all();
        	}else if("empty".equals(cmd)) {
        		s.empty();
        	}
        }
        
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}