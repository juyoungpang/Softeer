
import java.util.*;
import java.io.*;


public class 언어별시간_메모리 {
    static int N;
    static boolean[][] map, visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int answer = 0;
    static int size;
    static Queue<Integer> pq = new PriorityQueue<Integer>();

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new boolean[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            String temp = sc.next();
            for(int j=0;j<N;j++) {
                map[i][j] = temp.charAt(j)=='1'?true:false;
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] && !visited[i][j]) {
                    size = 0;
                    dfs(i,j);
                    answer++;
                    pq.add(size);
                }
            }
        }

        System.out.println(answer);
        while(!pq.isEmpty()) {
        	System.out.println(pq.poll());
        }
    }

    public static void dfs(int r, int c) {
        size++;
        visited[r][c] = true;
        for(int i=0;i<4;i++) {
            int newR = dr[i]+r;
            int newC = dc[i]+c;

            if(newR<0 || newR>=N || newC<0 || newC>=N || !map[newR][newC] || visited[newR][newC]) continue;

            dfs(newR, newC);
        }
    }
}