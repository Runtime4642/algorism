import java.util.Scanner;

public class Main {
	
	static long MIN_VALUE = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		
		dfs(n,m,0);
		
		if(MIN_VALUE == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(MIN_VALUE+1);
		}
		
	}
	
	public static void dfs(long a,long b,int cnt) {
		
		if(a == b) {
			MIN_VALUE = Math.min(cnt, MIN_VALUE);
		}
		
		long addOneValue = addLastIdxNumberOne(a);
		
		if(addOneValue <= b) {
			dfs(addOneValue,b,cnt+1);
		}
		
		if(a*2 <= b) {
			dfs(a*2,b,cnt+1);
		}
		
	}
	
	public static long addLastIdxNumberOne(long a) {
		String StringValue =Long.toString(a);
		return Long.parseLong(StringValue +"1");
	}
}