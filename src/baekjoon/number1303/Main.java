package baekjoon.number1303;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean visited[][];
	static int contW = 0;
	static int resultW = 0;
	static int contB = 0;
	static int resultB = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		String str = sc.nextLine();

		visited = new boolean[y][x];
		String[][] map = new String[y][x];
		for (int i = 0; i < y; i++) {
			String input = sc.nextLine();
			for (int l = 0; l < input.length(); l++) {
				map[i][l] =Character.toString(input.charAt(l));
			}
		}
		
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				dfs(i,j,map);
				
				if(map[i][j].equals("W")) {
					contW = contW * contW;
					resultW += contW ;
					contW = 0;
					
				}
				else {
					contB = contB * contB;
					resultB += contB ;
					contB = 0;
				}
			}
		}
		
		System.out.println(resultW +" "+resultB);
		

	}
	
	public static void dfs(int x,int y ,String [][]map) {
		
		if(visited[x][y])
			return;
		
		visited[x][y] = true;
		if(map[x][y].equals("W"))
			contW++;
		else
			contB++;
		
		if(x+1 < map.length && map[x+1][y].equals(map[x][y]) && visited[x+1][y] == false) {
			dfs(x+1,y,map);
		}
		
		if(x-1 > -1 && map[x-1][y].equals(map[x][y]) && visited[x-1][y] == false) {
			dfs(x-1,y,map);
		}
		
		if(y+1 < map[0].length && map[x][y+1].equals(map[x][y]) && visited[x][y+1] == false) {
			dfs(x,y+1,map);
		}
		
		if(y-1 > -1 && map[x][y-1].equals(map[x][y]) && visited[x][y-1] == false) {
			dfs(x,y-1,map);
		}
		
	}

}
