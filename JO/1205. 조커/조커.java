import java.io.*;
import java.util.*;

// JO #1204 - 조커
// Strategy: 카드들에서 중복과 조커를 제거하고 오름차순 정렬한다. 각 카드 사이에 스트레이트를 만들기 위해 필요한
// 			조커의 수를 구할 수 있다(diff). 카드를 하나씩 세가며(cnt) 그 사이에 필요한 조커의 수를 더해간다(cnt_joker).
//			이 과정에서 필요한 조커의 수가 가지고 있는 조커의 수 보다 커지면, 지금까지 센 카드의 수 + 가지고 있는 조커의 수가 
//			현재 만들 수 있는 스트레이트의 길이가 된다. 이 과정을 각 카드를 시작점으로 하여 반복하고 최대 값을 구한다.
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // N: 카드의 개수
        int N = Integer.parseInt(br.readLine());
        
        // joker: 조커의 개수
        int joker = 0;
        
        // set: 카드 정보를 저장할 set (중복 카드 제거를 위해 set 사용)
        Set<Integer> set = new HashSet<>();
        
        // 카드 정보 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(tmp == 0) {
        		joker++;
        	}else {
        		set.add(tmp);
        	}
        }
        
        // nums: 카드 정보가 저장된 list, 정렬
        List<Integer> nums = new ArrayList<>(set);
        Collections.sort(nums);
        int N2 = nums.size();  // N2: 중복과 조커를 제외한 카드의 개수
        
        // diff: 정렬된 카드 사이를 스트레이트로 연결하기 위한 장수 저장
        List<Integer> diff = new ArrayList<>();
        for(int i=0; i<N2-1; i++) {
        	diff.add(nums.get(i+1)-nums.get(i)-1);
        }
        
        // max: 입력된 카드들을 가지고 만들 수 있는 스트레이트의 최대 길이
        int max = 0;
        
        // 최대 스트레이트 길이 계산
        for(int i=0; i<N2-1; i++) {
        	int cnt = 1;
        	int cnt_joker = 0;
        	for(int j=i; j<N2-1; j++) {
            	cnt_joker += diff.get(j);
            	if(cnt_joker > joker) {
            		break;
            	}else {
            		cnt++;
            	}
            }
        	cnt += joker;
        	
        	// max 갱신
        	if(cnt >= max) {
        		max = cnt;
        	}
        }
        // nums가 비어있을 때 반복문이 돌아가지 않기 때문에 예외처리
        if(N2 == 0) {
        	max = joker;
        }
        
        // 최종 결과 출력
        System.out.println(max);
    }
}
