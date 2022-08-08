import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표_정렬하기_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		// 이차원 배열을 선언 x,y를 한쌍으로 다루기 위함
		int arr[][] = new int[num][2];

		for (int i = 0; i < num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				//
				if (o1[0] == o2[0]) {// 자리변경
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}

			}
		});

		for (int i = 0; i < num; i++) {
			System.out.print(arr[i][0] + " " + arr[i][1]);
			System.out.println("");
		}
	}

}
