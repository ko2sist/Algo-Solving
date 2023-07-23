import java.io.*;
import java.util.*;

// BJ #2798
public class Main {
    public static int modified_blackjack(int[] cards, int m){
        int len = cards.length;
        int max = 0;
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    int tmp = cards[i]+cards[j]+cards[k];
                    if((tmp >= max) && (tmp <= m)){
                        max = tmp;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(modified_blackjack(cards,M));

    }
}