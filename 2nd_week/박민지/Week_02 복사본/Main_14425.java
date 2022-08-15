package Week_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_14425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> arr = new HashMap<String, Integer>();
		String k;
		for (int i = 0; i < N; i++) {
			k = br.readLine();
			arr.put(k, 1);
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			k = br.readLine();
			if (!arr.containsKey(k)) {
				continue;
			} else {
				cnt += 1;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}

}
