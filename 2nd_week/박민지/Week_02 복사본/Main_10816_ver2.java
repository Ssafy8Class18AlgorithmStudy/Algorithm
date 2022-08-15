package Week_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10816_ver2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int tmp;
		int[] N_card = new int[20000001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			tmp = Integer.parseInt(st.nextToken());
			N_card[tmp + 10000000] += 1;
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			tmp = Integer.parseInt(st.nextToken());
			bw.write(N_card[tmp + 10000000] + " ");

		}
		bw.flush();
		bw.close();
	}

}
