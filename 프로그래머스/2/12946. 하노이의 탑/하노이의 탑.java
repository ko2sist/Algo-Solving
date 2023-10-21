import java.util.*;

class Solution {
    
    ArrayList<int[]> seq;
    
    public void hanoi(int n, int start, int mid, int end){
        if(n==1){
            seq.add(new int[] {start, end});
            return;
        }
        
        hanoi(n-1, start, end, mid);
        seq.add(new int[] {start, end});
        hanoi(n-1, mid, start, end);
    }
    
    public int[][] solution(int n) {
        seq = new ArrayList<>();
        
        hanoi(n,1,2,3);
        
        int[][] answer = new int[seq.size()][2];
        for(int i=0; i<seq.size(); i++){
            answer[i] = seq.get(i);
        }
        
        return answer;
    }
}