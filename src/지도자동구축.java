
import java.util.*;
import java.io.*;


public class 지도자동구축
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = 1;
        for(int i=0;i<N;i++) {
            num*=2;
        }   

        System.out.println((int)Math.pow(num+1,2));
    }
}