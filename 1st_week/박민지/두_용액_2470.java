import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());

		int arr[] = new int[num];
		int a = 0, b = 0, add = Integer.MAX_VALUE;
		// 스트링 토큰 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 공백을 기준으로 나눔
		}

		Arrays.sort(arr);// 원소 정렬 후
		int right = num - 1;// 마지막오른쪽 우너소
		int left = 0;// 맨 왼쪽 원소

		while (right > left) {
			// System.out.println(arr[left] + " " + arr[right]);

			if (add > Math.abs(arr[right] + arr[left])) {
				add = Math.abs(arr[right] + arr[left]);
				a = arr[right];
				b = arr[left];
			}

			if (arr[right] + arr[left] < 0) {
				left++;
			} else if (arr[right] - arr[left] > 0) {
				right--;
			} else {// 0과 같을 때
				a = arr[right];
				b = arr[left];
				break;
			}

		}
		bw.write(b + " " + a);
		bw.flush();
		bw.close();
	}
}