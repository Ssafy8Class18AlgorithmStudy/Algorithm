package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_10816 {
	/**
	 * 숫자 카드 2 해쉬맵 -> 시간초과로 실패!
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 ***/
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		// HashMap생성 ->리스트와 달리 저장 공간을 약 2배씩 늘림
		// 따라서 초기에 저장 데이터를 알 고 있다면 주게 좋음
		HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>();
		int k, v = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			k = Integer.parseInt(st.nextToken());
			if (!arr.containsKey(k)) {// 새로운 키(값 )이면 추가
				arr.put(k, 1);
			} else {// 기존에 있던 값이면 value를 증가
				v = arr.get(k) + 1;
				arr.put(k, v);// 가장 최신 값으로 갱신됨

			}

		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			k = Integer.parseInt(st.nextToken());
			if (!arr.containsKey(k)) {// 새로운 키(값 )이면 추가
				System.out.print(0 + " ");
			} else {// 기존에 있던 값이면 value를 증가
				System.out.print(arr.get(k) + " ");
			}

		}

	}

}
