import java.util.*;
import java.io.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] numX = new int[10];
        int[] numY = new int[10];
        
        for(int i=0; i<X.length(); i++){
            numX[X.charAt(i)-'0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
            numY[Y.charAt(i)-'0']++;
        }
        
        for(int i=9; i>=0; i--){
            while(numX[i]>=1 && numY[i]>=1){
                numX[i]--;
                numY[i]--;
                sb.append(i);
            }
        }
        
        String res = sb.toString();
        if(res.equals("")){
            return "-1";
        }else if(res.charAt(0) == '0'){
            return "0";
        }else{
            return res;
        }
        
    }
}