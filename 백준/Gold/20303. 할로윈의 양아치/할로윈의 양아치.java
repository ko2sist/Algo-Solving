import java.util.*;
import java.io.*;

// BJ #20303 - 할로윈의 양아치
// Strategy: 분리집합 + 0-1 knapsack

public class Main {
	static int N,M,K;
	static int[] parent, rank, candy;
	
	public static void makeSet() {
		parent = new int[N+1];
		rank = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
			rank[i] = 1;
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
		
		if(rank[x] > rank[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		parent[x] = y;
		
		if(rank[x] == rank[y]) rank[y]++;
	}
	
	public static class Pair{
		int num;
		int candy;
		
		public Pair(int num, int candy) {
			this.num = num;
			this.candy = candy;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 기본 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 사탕 개수 입력
        st = new StringTokenizer(br.readLine());
        candy = new int[N+1];
        for(int i=1; i<=N; i++) {
        	candy[i] = Integer.parseInt(st.nextToken());
        }
        
        // 분리집합을 사용하기 위한 makeSet 실행
        makeSet();
        
        // 친구 관계 입력
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(find(a) != find(b)) {
        		union(a,b);
        	}
        }
        
        // 아이들 간의 그룹 확인
        int[] sum_candy = new int[N+1];
        int[] sum_child = new int[N+1];
        for(int i=1; i<=N; i++) {
        	int tmp = find(i);
        	sum_child[tmp]++;
        	sum_candy[tmp] += candy[i];
        }
        
        // 그룹 정보(인원 수, 사탕 수)를 list에 저장
        List<Pair> list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
        	if(sum_child[i] != 0) {
        		list.add(new Pair(sum_child[i], sum_candy[i]));
        	}
        }
        
        // 배낭 문제 해결 (배낭 크기를 K로 생각)
        int size = list.size();
        int[][] dp = new int[size+1][K+1];
        for(int i=1; i<=size; i++) {
        	for(int j=1; j<=K; j++) {
        		Pair tmp = list.get(i-1);
        		if(tmp.num < j) {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-tmp.num]+tmp.candy);
        		}else {
        			dp[i][j] = dp[i-1][j];
        		}
        	}
        }
        System.out.println(dp[size][K]);
    }
}