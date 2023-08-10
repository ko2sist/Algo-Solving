import java.io.*;
import java.util.*;

// BJ #18870 - 좌표 압축
// Strategy: 자료구조 활용
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 좌표의 개수
        int N = Integer.parseInt(br.readLine());
        
        // X: 좌표들을 저장할 배열
        int[] X = new int[N];
        Set<Integer> set = new HashSet<>();
        
        // 좌표 입력 (set을 통해 중복 제거)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	X[i] = tmp;
        	set.add(tmp);
        }
        
        // 중복이 제거된 list를 만들고 정렬
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        // map: key->압축 전 좌표, value->압축 후 좌표 저장
        Map<Integer, Integer> map = new HashMap<>();
        
        // 압축 좌표 계산
        for(int i=0; i<list.size(); i++) {
        	map.put(list.get(i), i);
        }
        
        // 결과 저장
        for(int i=0; i<N; i++) {
        	sb.append(map.get(X[i])).append(" ");
        }
        
        // 최종 결과 출력
        System.out.println(sb);

    }
}