import java.util.*;
import java.io.*;

// BJ #2529 - 부등호
// Strategy : 백트래킹
public class Main {
    static int N;
    static String min, max;
    static char[] signs;

    public static void back(int len, int[] selected, boolean[] visited){
        if(len == N+1){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N+1; i++){
                sb.append(selected[i]);
            }
            long check = Long.parseLong(sb.toString());

            if(Long.parseLong(min) > check){
                min = sb.toString();
            }
            if(Long.parseLong(max) < check){
                max = sb.toString();
            }
            return;
        }

        for(int i=0; i<10; i++){
            if(!visited[i]){
                if(len == 0){
                    visited[i] = true;
                    selected[len] = i;
                    back(len+1, selected, visited);
                    visited[i] = false;
                }else if(signs[len-1] == '<'){
                    if(selected[len-1] < i){
                        visited[i] = true;
                        selected[len] = i;
                        back(len+1, selected, visited);
                        visited[i] = false;
                    }
                }else {
                    if(selected[len-1] > i){
                        visited[i] = true;
                        selected[len] = i;
                        back(len+1, selected, visited);
                        visited[i] = false;
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 부등호 개수 입력
        N = Integer.parseInt(br.readLine());

        // 부등호 입력
        signs = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            signs[i] = st.nextToken().charAt(0);
        }

        // 가능한 경우 찾기 + 최대 최소 갱신
        min = String.valueOf(Long.MAX_VALUE);
        max = String.valueOf(Long.MIN_VALUE);
        int[] selected = new int[N+1];
        boolean[] visited = new boolean[10];
        back(0,selected,visited);



        // 최종 결과 출력
        System.out.println(max);
        System.out.println(min);


    }
}