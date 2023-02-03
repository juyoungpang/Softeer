
import java.util.*;
import java.io.*;


public class 비밀메뉴
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        tok = new StringTokenizer(br.readLine());
        StringBuilder secret = new StringBuilder();
        while(tok.hasMoreTokens()) {
            secret.append(tok.nextToken());
        }

        tok = new StringTokenizer(br.readLine());
        StringBuilder pressed = new StringBuilder();
        while(tok.hasMoreTokens()) {
            pressed.append(tok.nextToken());
        }

        System.out.println(pressed.toString().contains(secret.toString())?"secret":"normal");
    }
}