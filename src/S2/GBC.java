package S2;
import java.util.*;
import java.io.*;


public class GBC
{
    static int[] limit = new int[100];
    static int max = 0;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int idx = 0;
        for(int i=0;i<N;i++) {
            int duration = sc.nextInt();
            int speed = sc.nextInt();

            for(int j=0;j<duration;j++) {
                limit[idx++] = speed;
            }
        }

        idx=0;
        for(int i=0; i<M; i++) {
            int duration = sc.nextInt();
            int speed = sc.nextInt();

            for(int j=0;j<duration;j++) {
                max = Math.max(max, speed-limit[idx++]);
            }
        }
        
        System.out.println(max);
    }
}