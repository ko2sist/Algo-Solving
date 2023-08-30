import java.util.*;
import java.io.*;

// BJ #14891 - 톱니바퀴
// Strategy: 
public class Main {
	public static class Gear{
		int[][] poles;
		int[][] info;
		
		public Gear(int[][] poles) {
			this.poles = poles;
			this.info = new int[4][3];
			for(int i=0; i<4; i++) {
				info[i][0] = 0;
				info[i][1] = 6;
				info[i][2] = 2;
			}
		}
		
		
		public void rotateOne(int num, int dir) {
			for(int i=0; i<3; i++) {
				if(dir == 1) {
					info[num-1][i] = (info[num-1][i]+7) % 8;
				}else {
					info[num-1][i] = (info[num-1][i]+1) % 8;
				}
			}
		}
		
		public void rotateAll(int num, int dir) {
		
			int g1_right = poles[0][info[0][2]];
			int g2_left = poles[1][info[1][1]];
			int g2_right = poles[1][info[1][2]];
			int g3_left = poles[2][info[2][1]];
			int g3_right = poles[2][info[2][2]];
			int g4_left = poles[3][info[3][1]];
			
			if(num == 1) {
				this.rotateOne(1, dir);
				if(g1_right != g2_left) {
					this.rotateOne(2, -dir);
					if(g2_right != g3_left) {
						this.rotateOne(3, dir);
						if(g3_right != g4_left) {
							this.rotateOne(4, -dir);
						}
					}
				}
			}else if(num == 2) {
				this.rotateOne(2, dir);
				if(g2_left != g1_right) {
					this.rotateOne(1, -dir);
				}
				
				if(g2_right != g3_left) {
					this.rotateOne(3, -dir);
					if(g3_right != g4_left) {
						this.rotateOne(4, dir);
					}
				}
			}else if(num == 3) {
				this.rotateOne(3, dir);
				if(g3_left != g2_right) {
					this.rotateOne(2, -dir);
					if(g2_left != g1_right) {
						this.rotateOne(1, dir);
					}
				}
				
				if(g3_right != g4_left) {
					this.rotateOne(4, -dir);
				}
			}else {
				this.rotateOne(4, dir);
				if(g4_left != g3_right) {
					this.rotateOne(3, -dir);
					if(g3_left != g2_right) {
						this.rotateOne(2, dir);
						if(g2_left != g1_right) {
							this.rotateOne(1, -dir);
						}
					}
				}
			}
		}
		
		public int getScore() {
			int res = 0;
			int tmp = 1;
			for(int i=0; i<4; i++) {
				res += poles[i][info[i][0]]*tmp;
				tmp *= 2;
			}
			return res;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] poles = new int[4][8];
		
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				poles[i][j] = s.charAt(j)-'0';
			}
		}
		
		Gear gear = new Gear(poles);
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			gear.rotateAll(num, dir);
		}
		
		System.out.println(gear.getScore());
	}
}
