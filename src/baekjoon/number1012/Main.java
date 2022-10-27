package baekjoon.number1012;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static boolean visited [][];

	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-->0) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int z = sc.nextInt(); //배추개수
			int [][] array = new int[x][y];
			visited = new boolean[x][y];
			
			for(int i=0;i<z;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				array[b][a] = 1; 
			}

			soluction(x,y,array);
		}
		
		
	}

	public static void soluction(int x,int y, int[][] array) {

		int cnt = 0;
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++) {
				if(dfs(i,j,array)) {
					
					
//					for(int z=0;z <array.length;z++) {
//						System.out.println(Arrays.toString(visited[z]));
//					}
					
					cnt++;
//					System.out.println("=======================");
				}	
			}
		
		System.out.println(cnt);
	}

	public static boolean dfs(int x, int y, int[][] array) {
		
		//이미 방문한곳은 return;
		if(visited[x][y])
			return false;
		
		//배추가 없으면 return;
		if(array[x][y] == 0)
			return false;
		
		
		visited[x][y] = true;
		
		//위,아래,왼,오른쪽에 있으면 진행
		if(x-1 >= 0 && array[x-1][y] == 1) {
			dfs(x-1,y,array);
		} 
		if(x+1 < array.length && array[x+1][y] == 1) {
			dfs(x+1,y,array);
		} 
		if(y-1 >= 0 && array[x][y-1] == 1) {
			dfs(x,y-1,array);
		} 
		if(y+1 < array[0].length && array[x][y+1] == 1) {
			dfs(x,y+1,array);
		}
		
		return true;
		
	}

}
