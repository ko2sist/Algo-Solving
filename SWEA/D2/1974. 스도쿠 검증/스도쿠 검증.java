import java.util.*;
import java.io.*;

// SWEA #1974 - 스도쿠 검증
// Strategy:  
class Solution {
    public static int check(int[][] sudoku_array){
        int val = 1;
        Set<Integer> check_row = new HashSet<>();	// 가로 체크를 위한 Set
        Set<Integer> check_col = new HashSet<>();	// 세로 체크를 위한 Set
        Set<Integer> check_box = new HashSet<>();	// 박스 체크를 위한 Set

        loop1: for (int i = 0; i<9; i++){
            // 스도쿠 set에 저장
            for (int j = 0; j<9; j++){
                check_row.add(sudoku_array[i][j]);
                check_col.add(sudoku_array[j][i]);
                check_box.add(sudoku_array[(i/3)*3+j/3][(i%3)*3+j%3]);
            }

            // 유효성 검증
            if (check_row.size() != 9){
                val = 0;
                break loop1;
            } else if (check_col.size() != 9){
                val = 0;
                break loop1;
            } else if (check_box.size() != 9){
                val = 0;
                break loop1;
            } else{
                check_row.clear();
                check_col.clear();
                check_box.clear();
            }
        }
        return val;
    }



    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		// T: 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<T+1; t++){
        	// sudoku: 스도쿠를 저장할 2차원 배열
            int[][] sudoku = new int[9][9];
            
            // 스도쿠 입력 받기
            for(int i=0; i<9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++) {
                	sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 현재 테스트 케이스 결과 저장
            sb.append("#"+t).append(" ").append(check(sudoku)).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}
