class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int len = board.length;
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        
        for(int i=0; i<4; i++){
            int nr = h + dr[i];
            int nc = w + dc[i];
            
            if(nr < 0 || nc < 0 || nr >= len || nc >= len) continue;
            
            if(board[nr][nc].equals(board[h][w])) answer++;
        }
        
        
        
        return answer;
    }
}