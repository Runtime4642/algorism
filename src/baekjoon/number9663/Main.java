package baekjoon.number9663;

import java.util.Scanner;

public class Main {
	
	static int answer = 0;
	
	
	public static void main(String[] args) {
		
//		int [][] array = {{1,0,0},{0,0,0},{0,0,0}};
//		System.out.println(isEnable(1, 1, array));
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [][] array = new int[n][n];

		
			for(int j=0;j<n;j++) {
				array[0][j] = 1;
				dfs(1,0,j,array);
				array[0][j] = 0;
			}
		
		
		System.out.println(answer);
	}
	

	public static void dfs(int cnt,int x ,int y,int [][] array) {
		
		if(cnt == array.length) {
			answer++;
			return;
		}
		
		
		for (int j=0;j<array.length;j++) {
			
			int i = x+1;
			
			if(i >= array.length)
				return;
			
			if(isEnable(i,j,array)) {
				array[i][j] = 1;
				dfs(cnt+1,i,j,array);
				array[i][j] = 0;
			}
		}

	}
	
	public static boolean isEnable(int x,int y,int [][] array) {
		
		int n = array.length;
		for(int i=0;i<n;i++) {
			
			//가로에 퀸 존재
			if(array[x][i] == 1)
				return false;
			
			//세로에 퀸 존재
			if(array[i][y] == 1)
				return false;
			
			//오른쪽 아래 대각선
			if(x+i < n && y+i < n && array[x+i][y+i] == 1)
				return false;
			
			//오른쪽 위 대각선
			if(x-i >= 0 && y+i < n && array[x-i][y+i] == 1)
				return false;
			
			//왼쪽 위 대각선
			if(x-i >= 0 && y-i >= 0 && array[x-i][y-i] == 1)
				return false;
			
			//왼쪽 아래
			if(x+i < n && y-i >= 0 && array[x+i][y-i] == 1)
				return false;
		}
		
		
		return true;
	}
	

}
