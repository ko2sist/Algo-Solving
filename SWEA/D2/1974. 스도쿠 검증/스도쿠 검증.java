import java.util.*;
import java.io.*;

// SWEA #1974 - 스도쿠 검증
// Strategy:  
class Solution {
    public static int sudoku(int[][] sudoku_array){
        int val = 1;
        Set<Integer> check_row = new HashSet<Integer>();
        Set<Integer> check_col = new HashSet<Integer>();
        Set<Integer> check_box = new HashSet<Integer>();

        loop1: for (int i = 0; i<9; i++){
            // Adding
            for (int j = 0; j<9; j++){
                check_row.add(sudoku_array[i][j]);
                check_col.add(sudoku_array[j][i]);
                check_box.add(sudoku_array[(i/3)*3+j/3][(i%3)*3+j%3]);
            }

            // Check Validation
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



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int t=1; t<T+1; t++){
            int[][] temp_sudoku = new int[9][9];
            // Get Sudoku
            for(int i=0; i<81; i++){
                temp_sudoku[i/9][i%9] = sc.nextInt();
            }
            System.out.println("#"+t+" "+sudoku(temp_sudoku));
        }
    }
}
