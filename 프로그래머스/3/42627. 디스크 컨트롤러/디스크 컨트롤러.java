import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        
        int cnt = 0;
        int idx = 0;
        int end = 0;
        int sum = 0;
        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= end){
                pq.add(jobs[idx++]);
            }
            
            if(pq.isEmpty()){
                end = jobs[idx][0];
            }else{
                int[] tmp = pq.poll();
                sum += tmp[1]+end-tmp[0];
                end += tmp[1];
                cnt++;
            }
        }
        
        
        return sum / jobs.length;
    }
}