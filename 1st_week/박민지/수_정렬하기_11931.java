import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class 수_정렬하기_11931 {

	public static void main(String[] args) throws IOException {
		// 선언
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		Integer arr[] = new Integer[num];

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Integer i : arr) {
			bw.write(i + "\n");

		}
		bw.flush();
	}

}
