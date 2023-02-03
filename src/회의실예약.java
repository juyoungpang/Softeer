
import java.util.*;
import java.io.*;

public class 회의실예약 {
	static int N, M;
	static Room[] rooms;
	static List<String> names;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		rooms = new Room[N];
		names = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String name = sc.next();
			rooms[i] = new Room(name);
			names.add(name);
		}

		for (int i = 0; i < M; i++) {
			rooms[names.indexOf(sc.next())].check(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(rooms);

		for (int n=0;n<N;n++) {
			Room room = rooms[n];
			List<String> times = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				if (room.timeAvailable[i]) {
					StringBuilder sb = new StringBuilder();
					sb.append(String.format("%02d", i + 9));
					while (i < 9 && room.timeAvailable[i]) {
						i++;
					}
					sb.append("-").append(String.format("%02d", i + 9));
					times.add(sb.toString());
				}
			}

			System.out.println("Room " + room.name + ":");
			if (times.size() == 0) {
				System.out.println("Not available");
			} else
				System.out.println(times.size() + " available:");
			for (String str : times) {
				System.out.println(str);
			}
			if(n!=N-1) System.out.println("-----");
		}
	}
}

class Room implements Comparable<Room> {
	String name;
	boolean[] timeAvailable = new boolean[9];

	public Room(String name) {
		this.name = name;
		Arrays.fill(timeAvailable, true);
	}

	public void check(int start, int end) {
		for (int i = start; i < end; i++) {
			timeAvailable[i - 9] = false;
		}
	}

	@Override
	public final int compareTo(Room o) {
		return this.name.compareTo(o.name);
	}
}