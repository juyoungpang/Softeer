import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인증평가_아몰라 {
	public static int H, K, R;
	public static int answer;
	public static Queue<Integer>[][] works;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		H = Integer.parseInt(tok.nextToken());
		K = Integer.parseInt(tok.nextToken());
		R = Integer.parseInt(tok.nextToken());

		works = new Queue[getNumNodes()][2];

		int node = 0;
		for (int i = 0; i <= H; i++) {
			for (int j = 0; j < Math.pow(2, i); j++) {
				works[node][0] = new LinkedList<>();
				works[node][1] = new LinkedList<>();

				if (i == H) { // 말단이면
					tok = new StringTokenizer(br.readLine());
					for (int k = 0; k < K; k++) {
						works[node][0].add(Integer.parseInt(tok.nextToken()));
					}
				}
				node++;
			}
		}

		int day = 2;
		while (day <= R) {
			for (int i = 0; i * 2 + 1 < works.length; i++) {
				if (i * 2 + 1 >= works.length)
					continue;

				if (i == 0) { // 부장님이면
					if (!works[i][day % 2].isEmpty()) {
						answer += works[i][day % 2].poll();
					}
				}

				int nextNode = i * 2 + (day % 2 != 0 ? 1 : 2);
				if ((nextNode) * 2 + 1 >= works.length) { // 말단 바로 위
					if (!works[nextNode][0].isEmpty())
						works[i][day % 2].add(works[nextNode][0].poll());
				} else {
					if (!works[nextNode][day % 2].isEmpty())
						works[i][day % 2].add(works[nextNode][day % 2].poll());
				}

			}
			day++;
		}

		if (!works[0][R % 2].isEmpty()) {
			answer += works[0][R % 2].poll();
		}

		System.out.println(answer);

	}

	public static int getNumNodes() {
		int ret = 0;
		for (int i = 0; i <= H; i++) {
			ret += (int) Math.pow(2, i);
		}
		return ret;
	}
}