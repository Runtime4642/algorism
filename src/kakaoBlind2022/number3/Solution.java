//package kakaoBlind2022.number3;
//class Solution {
//	
//	static int MAX_VALUE= Integer.MIN_VALUE;
//	
//	public static void main(String[] args) {
//		
//		//[0,2,2,0,1,0,0,0,0,0,0]
//		int [] info = {2,1,1,1,0,0,0,0,0,0,0};
//		solution(5,info);
//	}
//	
//	public static int[] solution(int n, int[] info) {
//		
//		dfs(info,n,0,0);
//		
//		return null;
//	}
//	
//	
//	public static void dfs(int n, int[] info,int index, int score) {
//		
//		
//		//스코어 체크 추가
//		if(n == 0) {
////			MAX_VALUE = Math.max(MAX_VALUE, score);
//			return;
//		}
//		
//		
//		for(int i=index+1;i<info.length;i++) {
//			
//			int cnt = info[i];
//			
//			if(cnt > n)
//				continue;
//			
//			n -= cnt;
//			dfs(n,info,n,0,0);
//			n += cnt;
//		}
//
//		
//		return;
//	}
//	
//}