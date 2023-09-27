import java.util.*;
import java.io.*;

// BJ #10775 - 공항
// Strategy: 분리집합

public class Main {
	static int G, P;
	static int[] g;
	
	static int[] parent;
	
	public static void makeSet() {
		parent = new int[G+1];
		
		for(int i=1; i<=G; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return;
		
		parent[x] = y;
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        boolean[] visited =  new boolean[G+1];
        
        makeSet();
        
        int cnt = 0;
        for(int i=1; i<=P; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	int p = find(tmp);
        	if(!visited[p]) {
        		if(p == 0) {
        			break;
        		}
        		visited[p] = true;
        		cnt++;
        		union(p, p-1);
        	}else {
        		break;
        	}
        }
        
        System.out.println(cnt);
        
        
    }
}