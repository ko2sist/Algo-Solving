import java.util.Scanner;

public class Main {
    // 층이랑 방 호수랑 사람수 주어짐
// 6층에 20호까지 있다 사람이 68번째라면 20개 3개 채우고 8번째
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
//        String a = "";
        for (int tc = 1; tc <= T; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int A = (N-1) % H + 1;
            int A2 = (N-1) / H + 1;
            
            if(A2>=10) {
            	System.out.printf("%d%02d\n",A,A2);
            }else {
            	System.out.printf("%d%02d\n",A,A2);
            }
        }
    }
}