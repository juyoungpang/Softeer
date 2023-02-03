import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_wrong_recursion {
	static int H, K, R;

	static int answer = 0;

	static int[][] works; // (직원 번호-1, 업무 번호)
	static int[] order; // 처리할 업무 순서 -1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		H = Integer.parseInt(tok.nextToken());
		K = Integer.parseInt(tok.nextToken());
		R = Integer.parseInt(tok.nextToken());

		works = new int[(int) Math.pow(2, H)][K];
		order = new int[works.length]; // 시작은 모두 0번째 업무부터 처리

		for (int i = 0; i < works.length; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < works[0].length; j++) {
				works[i][j] = Integer.parseInt(tok.nextToken());
			}
		}

		goDown(0, 0, (int) (Math.pow(2, H)) - 1, 1);

		System.out.println(answer);

	}

	public static void goDown(int curHeight, int left, int right, int day) {
		if (day > R)
			return;

		if (left >= right) {
			answer += works[left][order[left]];
			order[left]++;
			return;
		}

		if (curHeight % 2 != 0) {
			// 왼쪽으로
			goDown(curHeight + 1, left, (left + right) / 2, day + 1);
			// 오른쪽을
			goDown(curHeight + 1, (left + right) / 2 + 1, right, day + 2);
		} else {
			// 오른쪽을
			goDown(curHeight + 1, (left + right) / 2 + 1, right, day + 1);
			// 왼쪽으로
			goDown(curHeight + 1, left, (left + right) / 2, day + 2);
		}
	}
}