
import java.util.*;
import java.io.*;

public class 전광판 {
	static boolean[][][] digits = {
        {{false, true, false},
        {true, false, true},
        {false, false, false},
        {true, false, true},
        {false, true, false}}, // 0

        {{false, false, false},
        {false,false,true},
        {false, false, false},
        {false,false,true},
        {false, false, false}}, // 1

        {{false,true,false},
        {false, false, true},
        {false, true, false},
        {true, false, false},
        {false, true, false}}, // 2

        {{false, true, false},
        {false, false, true},
        {false, true, false},
        {false, false, true},
        {false, true, false}}, // 3

        {{false, false, false},
        {true, false, true},
        {false, true, false},
        {false, false, true},
        {false, false, false}}, // 4

        {{false, true, false},
        {true, false, false},
        {false, true, false},
        {false, false, true},
        {false, true, false}}, // 5

        {{false, true, false},
        {true, false, false},
        {false, true, false},
        {true, false, true},
        {false, true, false}}, // 6

        {{false, true, false},
        {true, false, true},
        {false, false, false},
        {false, false, true},
        {false, false, false}}, // 7

        {{false, true, false},
        {true, false, true},
        {false, true, false},
        {true, false, true},
        {false, true, false}}, // 8

        {{false, true, false},
        {true, false, true},
        {false, true, false},
        {false, false, true},
        {false, true, false}}, // 9

        {{false, false, false},
        {false, false, false},
        {false, false, false},
        {false, false, false},
        {false, false, false}} // 10 --> not on
	};
	
    static int[][] diff = new int[11][11];

    public static void prePro() {
        for(int i=0;i<11;i++) {
            for(int j=i+1;j<11;j++) {
                int d = 0;
                for(int k=0;k<5;k++) {
                    for(int l=0;l<3;l++) {
                        if(digits[i][k][l]!=digits[j][k][l]) d++;
                    }
                }
                diff[i][j] = diff[j][i] = d;
            }
        }
    }
	
	public static void main(String[] args) {
        prePro();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 0; tc<T; tc++) {
            int answer = 0;

            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            for(int i=100000;i>0;i/=10) {
                if(n1<i && n2<i) continue;

                int d1 = (n1<i)?10:(n1/i)%10;
                int d2 = (n2<i)?10:(n2/i)%10;

                answer+=diff[d1][d2];
            }

            System.out.println(answer);
        }
	}
}