package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_12757 {
//메모리 초과뜸...
	// 해시와 트리(자동정렬) 중에서 어떤걸 선택해야하는가,,
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int tmp;
		int a, b;
		TreeMap<Integer, Integer> arr = new TreeMap<Integer, Integer>();// TreeMap생성

		int key, value;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			key = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());

			arr.put(key, value);
		}

		int type, Skey;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			Skey = Integer.parseInt(st.nextToken());

			switch (type) {
			case 1: // 값 추가
				tmp = Integer.parseInt(st.nextToken());
				arr.put(Skey, tmp);
				break;

			case 2: // key값을 통한 value값 변경
				tmp = Integer.parseInt(st.nextToken());

				for (int z = 1; z <= K; z++) {
					a = Skey + z;
					b = Skey - z;
					if (arr.containsKey(a)) {
						arr.put(a, tmp);
						break;
					}
					if (arr.containsKey(b)) {
						arr.put(b, tmp);
						break;
					}
				}
				break;
			case 3:// 출력

				int res1 = 0, res2 = 0;
				for (int j = 0; j < N; j++) {
					int gap1 = 0, gap2 = 0;// 갭을 기록해 놨다가 같은게 있다면 -1을 출력
					for (int z = 1; z <= K; z++) {
						a = Skey + z;
						b = Skey - z;
						if (arr.containsKey(a)) {
							res1 = a;

							// System.out.println("res1=" + res1 + " " + Skey + " " + z);
							gap1 = z;
						}
						if (arr.containsKey(b)) {
							res2 = b;

							gap2 = z;
							System.out.println("res2=" + res2 + " " + Skey + " " + z);
						}
					} // for2
					if (gap1 == 0 && gap2 == 0) {
						System.out.println(-1);
						break;
					}
					if (gap1 == gap2) {
						System.out.println("?");
						break;
					}
					if (arr.containsKey(res1) && res1 - res2 < 0) {
						System.out.println(arr.get(res1));
						break;
					}
					if (arr.containsKey(res2)) {
						System.out.println(arr.get(res2));
						break;
					}

				} // for1
			} // switch
		}

	}

}