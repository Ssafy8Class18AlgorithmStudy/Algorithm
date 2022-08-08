import java.util.Arrays;
import java.util.Scanner;

public class 애너그램_6996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {

			String a = sc.next();
			String b = sc.next();

			char ac[] = a.toCharArray();
			Arrays.sort(ac);
			String ar = new String(ac);

			char bc[] = b.toCharArray();
			Arrays.sort(bc);
			String br = new String(bc);

			if (ar.equals(br)) {
				System.out.println(a + " & " + b + " are anagrams.");
			} else {
				System.out.println(a + " & " + b + " are NOT anagrams.");
			}
		}
	}
}