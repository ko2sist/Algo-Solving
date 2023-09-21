import java.util.*;
import java.io.*;

// BJ #17387 - 선분 교차
// Strategy: 수학, CCW


public class Main {
	public static class Point implements Comparable<Point>{
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(this.x == o.x) {
				if(this.y > o.y) return 1;
				else if(this.y == o.y) return 0;
				else return -1;
			}else {
				if(this.x > o.x) return 1;
				else return -1;
			}
		}
	}
	
	public static int CCW(Point p1, Point p2, Point p3) {
		long S = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y)
				-(p2.x*p1.y + p3.x*p2.y + p1.x*p3.y);
		
		if(S > 0) return 1;
		else if(S < 0) return -1;
		else return 0;
	}
	
	public static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
		int check1 = CCW(p1, p2, p3) * CCW(p1, p2, p4);
		int check2 = CCW(p3, p4, p1) * CCW(p3, p4, p2);
		
		// 두 직선이 일직선 상에 존재
		if(check1 == 0 && check2 == 0) {
			if(p1.compareTo(p2) == 1) {
				long tx = p1.x;
				long ty = p1.y;
				p1 = p2;
				p2 = new Point(tx,ty);
			}
			
			if(p3.compareTo(p4) == 1) {
				long tx = p3.x;
				long ty = p3.y;
				p3 = p4;
				p4 = new Point(tx,ty);
			}
			
			return p2.compareTo(p3) >= 0 && p4.compareTo(p1) >= 0;
		}
		
		return check1 <= 0 && check2 <= 0;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 좌표 저장
		Point[] points = new Point[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=2; i++) {
			points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=3; i<=4; i++) {
			points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		
		// 최종 결과 출력
		if(isIntersect(points[1], points[2], points[3], points[4])) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}