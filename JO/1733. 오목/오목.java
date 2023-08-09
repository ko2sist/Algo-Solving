import java.io.*;
import java.util.*;

// JO #1733 - 오목
// Strategy: 
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // table: 바둑판 정보를 저장할 배열
        int[][] table = new int[19][19];
        
        // 바둑판 정보 입력
        for(int i=0; i<19; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<19; j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		table[i][j] = tmp;
        	}
        }
        
        // res: 결과 (검은색이 이기면 1, 흰색이 이기면 2, 승부 미결정 시 0)
        // row: 승부 결정시 5개의 연속된 바둑알 중 가장 왼쪽 or 가장 위쪽에 있는 바둑알의 가로줄 번호
        // col: 세로줄 번호
        int res = 0;
        int row = 0;
        int col = 0;
        
        // 가로, 세로 체크
        loop: for(int i=0; i<19; i++) {
        	int cnt1 = 0;
        	int cnt2 = 0;
        	int color1 = 0;
        	int color2 = 0;
        	for(int j=0; j<19; j++) {
        		// 가로
        		if(table[i][j] != 0) {
        			if(color1 == 0) {
        				color1 = table[i][j];
        			}else {
        				if(color1 != table[i][j]) {
        					if(cnt1 == 5) {
        						res = color1;
                				row = i;
                				col = j-5;
                				break loop;
        					}
        					cnt1 = 0;
        					color1 = table[i][j];
        				}
        			}
        			cnt1++;
        		}else {
        			if(cnt1 == 5) {
        				res = color1;
        				row = i;
        				col = j-5;
        				break loop;
        			}
        			cnt1 = 0;
        		}
        		
        		// 세로
        		if(table[j][i] != 0) {
        			if(color2 == 0) {
        				color2 = table[j][i];
        			}else {
        				if(color2 != table[j][i]) {
        					if(cnt2 == 5) {
        						res = color2;
                				row = j-5;
                				col = i;
                				break loop;
        					}
        					cnt2 = 0;
        					color2 = table[j][i];
        				}
        			}
        			cnt2++;
        		}else {
        			if(cnt2 == 5) {
        				res = color2;
        				row = j-5;
        				col = i;
        				break loop;
        			}
        			cnt2 = 0;
        		}
        		
        	}
        	if(cnt1 == 5) {
        		res = color1;
        		row = i;
        		col = 14;
        		break loop;
        	}else if(cnt2 == 5) {
        		res = color2;
        		row = 14;
        		col = i;
        		break loop;
        	}
        }
        
        // 대각선 체크 (왼쪽 끝에서 시작)
        loop2: for(int i=0; i<19; i++) {
        	int cnt1 = 0;
        	int cnt2 = 0;
        	int color1 = 0;
        	int color2 = 0;
        	for(int k=0; k<19; k++) {
        		// 오른쪽 아래
        		if((i+k<19 && k<19) && table[i+k][k] != 0) {
        			if(color1 == 0) {
        				color1 = table[i+k][k];
        			}else {
        				if(color1 != table[i+k][k]) {
        					if(cnt1 == 5) {
        						res = color1;
        						row = i+k-5;
        						col = k-5;
        						break loop2;
        					}
        					cnt1 = 0;
        					color1 = table[i+k][k];
        				}
        			}
        			cnt1++;
        		}else {
        			if(cnt1 == 5) {
        				res = color1;
						row = i+k-5;
						col = k-5;
        				break loop2;
        			}
        			cnt1 = 0;
        		}
        		
        		// 오른쪽 위
        		if((i-k>=0 && k<19) && table[i-k][k] != 0) {
        			if(color2 == 0) {
        				color2 = table[i-k][k];
        			}else {
        				if(color2 != table[i-k][k]) {
        					if(cnt2 == 5) {
        						res = color2;
                				row = i-k+5;
                				col = k-5;
                				break loop2;
        					}
        					cnt2 = 0;
        					color2 = table[i-k][k];
        				}
        			}
        			cnt2++;
        		}else {
        			if(cnt2 == 5) {
        				res = color2;
        				row = i-k+5;
        				col = k-5;
        				break loop2;
        			}
        			cnt2 = 0;
        		}
        	}
        	if(cnt1 == 5) {
        		res = color1;
				row = 14;
				col = 14-i;
        		break loop2;
        	}else if(cnt2 == 5) {
        		res = color2;
				row = 4;
				col = i-4;
        		break loop2;
        	}
        }
        
        // 대각선 체크 (위쪽 끝에서 시작)
        loop3: for(int j=1; j<19; j++) {
        	int cnt1 = 0;
        	int cnt2 = 0;
        	int color1 = 0;
        	int color2 = 0;
        	// 오른쪽 아래
        	
        	// 오른쪽 위
        }
        
        
        // 최종 결과 출력
        if(res != 0) {
        	System.out.println(res);
        	System.out.printf("%d %d", row+1, col+1);
        }else {
        	System.out.println(res);
        } 
    }
}
