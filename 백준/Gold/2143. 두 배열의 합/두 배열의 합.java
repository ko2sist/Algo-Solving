import java.util.*;
import java.io.*;

// BJ #2143 - 두 배열의 합
// Strategy: 

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long T = Long.parseLong(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        long[] SA = new long[N+1];
        long sumA = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            sumA += Integer.parseInt(st.nextToken());
            SA[i] = sumA;
        }
        
                
                
        int M = Integer.parseInt(br.readLine());
        long[] SB = new long[M+1];
        long sumB = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) {
            sumB += Integer.parseInt(st.nextToken());
            SB[i] = sumB;
        }
        
        long[] subA = new long[N*(N+1)/2];
        int idx = 0;
        for(int i=0; i<=N-1; i++) {
            for(int j=i+1; j<=N; j++) {
                subA[idx++] = SA[j]-SA[i];
            }
        }
        
        long[] subB = new long[M*(M+1)/2];
        idx = 0;
        for(int i=0; i<=M-1; i++) {
            for(int j=i+1; j<=M; j++) {
                subB[idx++] = SB[j]-SB[i];
            }
        }
        
        
        Arrays.sort(subA);
        Arrays.sort(subB);
        
        
        int left = 0;
        int right = M*(M+1)/2 - 1;
        long cnt = 0;
        
        while(left < N*(N+1)/2 && right>=0) {
            long ssA = subA[left];
            long ssB = subB[right];
            long sum = ssA + ssB;
            
            if(sum == T) {
                long cntA = 0;
                long cntB = 0;
                while(left < N*(N+1)/2 && subA[left] == ssA) {
                	left++;
                    cntA++;
                    
                }
                
                while(right >= 0 && subB[right] == ssB) {
                	right--;
                    cntB++;
                }
                
                cnt += cntA*cntB;
            }else if(sum < T) {
                left++;
            }else {
                right--;
            }
        }

        System.out.println(cnt);
    }
}