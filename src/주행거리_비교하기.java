import java.util.Scanner;

public class 주행거리_비교하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(A>B?"A":(A<B?"B":"same"));
	}
}