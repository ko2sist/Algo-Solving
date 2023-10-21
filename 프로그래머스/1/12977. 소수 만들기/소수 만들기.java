import java.util.*;
import java.io.*;

class Solution {
    static boolean[] checked = new boolean[3001];
    static boolean[] prime = new boolean[3001];
    
    public boolean isPrime(int n){
        if(checked[n]) return prime[n];
        
        if(n==2) return true;
        
        for(int i=2; i<n; i++){
            if(n%i == 0) {
                checked[n] = true;
                return false;
            }
        }
        
        checked[n] = true;
        prime[n] = true;
        return true;
    }
    
    public int solution(int[] nums) {
        int len = nums.length;
        int cnt =  0;
        
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(isPrime(sum)) cnt++;
                }
            }
        }
        
       return cnt;
    }
}