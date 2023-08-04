import java.util.*;
import java.io.*;

// BJ #2606
public class Main {
	public static void dfs(List<ArrayList<Integer>> graph, int n, boolean[] visited) {
		visited[n] = true;
		
		Iterator<Integer> iter = graph.get(n).iterator();
		while(iter.hasNext()) {
			int tmp = iter.next();
			if(!visited[tmp]) {
				dfs(graph, tmp, visited);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
       
        int nc = Integer.parseInt(br.readLine());
        int np = Integer.parseInt(br.readLine());
        
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=nc; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<np; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int c1 = Integer.parseInt(st.nextToken());
        	int c2 = Integer.parseInt(st.nextToken());
        	graph.get(c1).add(c2);
        	graph.get(c2).add(c1);
        }
        
        boolean[] visited = new boolean[nc+1];
        dfs(graph, 1, visited);
        int res = 0;
        for(int i=0; i<=nc; i++) {
        	if(visited[i]) {
        		res++;
        	}
        }
        if(res == 0) {
        	System.out.println(0); 
        }else {
        	System.out.println(res-1);
        }        
	}
}