
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 금고털이 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(tok.nextToken());
		int N = Integer.parseInt(tok.nextToken());
		
		Stone[] stones = new Stone[N];
		for(int i=0;i<N;i++) {
			tok = new StringTokenizer(br.readLine());
			stones[i] = new Stone(Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()));
		}
		
		Arrays.sort(stones);
		
		int value = 0;
		int weight = 0;
		
		for(int i=0;i<N;i++) {
			int left = W-weight;

			if(stones[i].M>left) {
				value+= stones[i].P*left;
				break;
			}
			
			value+=stones[i].P*stones[i].M;
			weight+=stones[i].M;
		}
		
		System.out.println(value);
	}
}

class Stone implements Comparable<Stone>{
	int M; // 무게
	int P; // 가치
	
	public Stone(int M, int P) {
		this.M = M;
		this.P = P;
	}

	@Override
	public int compareTo(Stone o) {
		return o.P-this.P;
	}
	
	
}