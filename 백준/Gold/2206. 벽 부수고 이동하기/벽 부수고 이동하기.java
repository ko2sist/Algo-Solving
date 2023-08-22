import java.util.*;
import java.io.*;

// BJ #2206 - 벽 부수고 이동하기
// Strategy: BFS
public class Main {
	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static class Point {
		int row;
		int column;
		int wall;

		public Point(int row, int column, int wall) {
			this.row = row;
			this.column = column;
			this.wall = wall;
		}
	}

	public static int BFS(int[][] map) {
		boolean[][] visited = new boolean[N + 1][M + 1];
		boolean[][] visited_wall = new boolean[N + 1][M + 1];
		int[][] dist = new int[N + 1][M + 1];

		Queue<Point> q = new LinkedList<>();

		q.add(new Point(1, 1, 0));
		visited[1][1] = true;
		dist[1][1] = 1;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int r = tmp.row;
			int c = tmp.column;

			if (r == N && c == M)
				return dist[N][M];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr <= 0 || nc <= 0 || nr > N || nc > M)
					continue;
				if (tmp.wall == 1 && map[nr][nc] == 1)
					continue;

				if (tmp.wall == 0 && map[nr][nc] == 0 && !visited[nr][nc]) {
					q.add(new Point(nr, nc, 0));
					dist[nr][nc] = dist[r][c] + 1;
					visited[nr][nc] = true;
				} else if (!visited_wall[nr][nc]) {
					q.add(new Point(nr, nc, 1));
					dist[nr][nc] = dist[r][c] + 1;
					visited_wall[nr][nc] = true;
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (s.charAt(j - 1) == '0') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		System.out.println(BFS(map));

	}
}