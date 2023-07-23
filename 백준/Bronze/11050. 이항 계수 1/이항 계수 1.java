import java.io.*;
import java.util.*;

// BJ #11050
public class Main {
    public static int nCr(int n, int r){
        if((r==0) || (r==n)){
            return 1;
        }
        int num = 1;
        int denum = 1;

        for(int i=n; i>n-r; i--){
            num *= i;
        }
        for(int i=1; i<r+1; i++){
            denum *= i;
        }

        return num/denum;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(nCr(N,K));
    }
}