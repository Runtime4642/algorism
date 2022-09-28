package baekjoon.number2446;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static String [] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new String[n];
		printStart(n,0);
		System.out.println();
		for(int i=1;i<dp.length;i++) {
			System.out.println(dp[i]);
		}
	}
	
	
	public static void printStart(int n,int cnt) {
		
		for(int i=0;i<cnt;i++) {
			System.out.print(" ");
			
			if(n > 0)
			dp[n-1] = dp[n-1] == null ? " " : dp[n-1] + " "; 
		}	
		
		for(int i=0;i<2*n-1;i++) {
			System.out.print("*");
			if(n > 0)
			dp[n-1] =  dp[n-1] == null ? "*" : dp[n-1] + "*"; 
		}	
		

		if(n > 1) {
			System.out.println();
			printStart(n-1,cnt+1);
		}
			
	}

}
