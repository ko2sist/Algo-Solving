import java.util.*;
import java.io.*;

// BJ #5373 - 큐빙
// Strategy: 
public class Main {
	static StringBuilder sb;
		
	public static class Cube{
		char[][] up;
		char[][] down;
		char[][] front;
		char[][] back;
		char[][] left;
		char[][] right;
		
		public Cube() {
			this.up = new char[][] {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
			this.down = new char[][] {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
			this.front = new char[][] {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
			this.back = new char[][] {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
			this.left = new char[][] {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
			this.right = new char[][] {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
		}
		
		// rot90(c): c를 시계 방향으로 90도 돌린 결과 반환
		public char[][] rot90(char[][] c) {
			char[][] tmp = new char[3][3];
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					tmp[j][2-i] = c[i][j];
				}
			}
			return tmp;
		}
		
		// rot270(c): c를 반시계 방향으로 90도 돌린 결과 반환
		public char[][] rot270(char[][] c) {
			char[][] tmp = new char[3][3];
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					tmp[2-j][i] = c[i][j];
				}
			}
			return tmp;
		}
		
		
		public void rotate_U(char d) {
			if(d == '+') {
				up = this.rot90(up);
				char[] tmp = back[0].clone();
				back[0] = left[0].clone();
				left[0] = front[0].clone();
				front[0] = right[0].clone();
				right[0] = tmp;
				
			}else {
				up = this.rot270(up);
				char[] tmp = back[0].clone();
				back[0] = right[0].clone();
				right[0] = front[0].clone();
				front[0] = left[0].clone();
				left[0] = tmp;
			}
		}
		
		public void rotate_D(char d) {
			if(d == '+') {
				down = this.rot90(down);
				char[] tmp = front[2].clone();
				front[2] = left[2].clone();
				left[2] = back[2].clone();
				back[2] = right[2].clone();
				right[2] = tmp;
				
			}else {
				down = this.rot270(down);
				char[] tmp = front[2].clone();
				front[2] = right[2].clone();
				right[2] = back[2].clone();
				back[2] = left[2].clone();
				left[2] = tmp;
			}
		}
		public void rotate_F(char d) {
			if(d == '+') {
				front = this.rot90(front);
				char[] tmp = up[2].clone();
				for(int i=0; i<3; i++) {
					up[2][i] = left[2-i][2];
				}
				for(int i=0; i<3; i++) {
					left[i][2] = down[2][2-i];
				}
				for(int i=0; i<3; i++) {
					down[2][i] = right[i][0];
				}
				for(int i=0; i<3; i++) {
					right[i][0] = tmp[i];
				}
				
			}else {
				front = this.rot270(front);
				char[] tmp = up[2].clone();
				for(int i=0; i<3; i++) {
					up[2][i] = right[i][0];
				}
				for(int i=0; i<3; i++) {
					right[i][0] = down[2][i];
				}
				for(int i=0; i<3; i++) {
					down[2][i] = left[2-i][2];
				}
				for(int i=0; i<3; i++) {
					left[i][2] = tmp[2-i];
				}
			}
		}
		
		public void rotate_B(char d) {
			if(d == '+') {
				back = this.rot90(back);
				char[] tmp = new char[3];
				for(int i=0; i<3; i++) {
					tmp[i] = up[0][2-i];
				}
				for(int i=0; i<3; i++) {
					up[0][i] = right[i][2];
				}
				for(int i=0; i<3; i++) {
					right[i][2] = down[0][i];
				}
				for(int i=0; i<3; i++) {
					down[0][i] = left[2-i][0];
				}
				for(int i=0; i<3; i++) {
					left[i][0] = tmp[i];
				}
				
			}else {
				back = this.rot270(back);
				char[] tmp = new char[3];
				for(int i=0; i<3; i++) {
					tmp[i] = up[0][i];
				}
				for(int i=0; i<3; i++) {
					up[0][i] = left[2-i][0];
				}
				for(int i=0; i<3; i++) {
					left[i][0] = down[0][2-i];
				}
				for(int i=0; i<3; i++) {
					down[0][i] = right[i][2];
				}
				for(int i=0; i<3; i++) {
					right[i][2] = tmp[i];
				}
			}
		}
		
		public void rotate_L(char d) {
			if(d == '+') {
				left = this.rot90(left);
				char[] tmp = new char[3];
				for(int i=0; i<3; i++) {
					tmp[i] = up[i][0];
				}
				for(int i=0; i<3; i++) {
					up[i][0] = back[2-i][2];
				}
				for(int i=0; i<3; i++) {
					back[i][2] = down[i][2];
				}
				for(int i=0; i<3; i++) {
					down[i][2] = front[2-i][0];
				}
				for(int i=0; i<3; i++) {
					front[i][0] = tmp[i];
				}
				
			}else {
				left = this.rot270(left);
				char[] tmp = new char[3];
				for(int i=0; i<3; i++) {
					tmp[i] = up[2-i][0];
				}
				for(int i=0; i<3; i++) {
					up[i][0] = front[i][0];
				}
				for(int i=0; i<3; i++) {
					front[i][0] = down[2-i][2];
				}
				for(int i=0; i<3; i++) {
					down[i][2] = back[i][2];
				}
				for(int i=0; i<3; i++) {
					back[i][2] = tmp[i];
				}
				
			}
		}
		
		public void rotate_R(char d) {
			if(d == '+') {
				right = this.rot90(right);
				char[] tmp = new char[3];
				for(int i=0; i<3; i++) {
					tmp[i] = up[2-i][2];
				}
				for(int i=0; i<3; i++) {
					up[i][2] = front[i][2];
				}
				for(int i=0; i<3; i++) {
					front[i][2] = down[2-i][0];
				}
				for(int i=0; i<3; i++) {
					down[i][0] = back[i][0];
				}
				for(int i=0; i<3; i++) {
					back[i][0] = tmp[i];
				}
			}else {
				right = this.rot270(right);
				char[] tmp = new char[3];
				for(int i=0; i<3; i++) {
					tmp[i] = up[i][2];
				}
				for(int i=0; i<3; i++) {
					up[i][2] = back[2-i][0];
				}
				for(int i=0; i<3; i++) {
					back[i][0]= down[i][0];
				}
				for(int i=0; i<3; i++) {
					down[i][0] = front[2-i][2];
				}
				for(int i=0; i<3; i++) {
					front[i][2] = tmp[i];
				}
			}
		}
		
		public void appendSB() {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					sb.append(up[i][j]);
				}
				sb.append("\n");
			}
		}
	}
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        // T: 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
        	// n: 큐브를 돌릴 횟수
        	int n = Integer.parseInt(br.readLine());

        	// 새로운 큐브 생성
        	Cube cube = new Cube();
        	
        	// 큐브 회전 실행
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0; i<n; i++) {
        		String cmd = st.nextToken();
        		char c = cmd.charAt(0);
        		char d = cmd.charAt(1);
        		
        		if(c == 'U') {
    				cube.rotate_U(d);
        		}else if(c == 'D') {
        			cube.rotate_D(d);
        		}else if(c == 'F') {
        			cube.rotate_F(d);
        		}else if(c == 'B') {
        			cube.rotate_B(d);
        		}else if(c == 'L') {
        			cube.rotate_L(d);
        		}else if(c == 'R') {
        			cube.rotate_R(d);
        		}
    			
        	}
        	
        	// 현재 테스트케이스 결과 저장
        	cube.appendSB();
        }
       
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}