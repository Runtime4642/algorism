package bruteForce.number1;
class Solution {
	
	static int answer = 0;
	
	static boolean []visited;
	//80	[[80,20],[50,40],[30,10]]	3
	
	public static void main(String[] args) {
		
		 int [][] dungeons = new int[][]{{80,20},{50,40},{30,10}};
		 
		 System.out.println(solution(80,dungeons));
	}
	
	 public static int solution(int k, int[][] dungeons) {

		 visited = new boolean[dungeons.length];
		 
		 dfs(k,dungeons,0);
		 return answer;
	 }
	 
	 
	 public static void dfs(int k,int[][] dungeons, int cnt) {

		 answer = Math.max(answer,cnt);
		 //방문하지 않은곳 탐방
		 for(int i=0;i<dungeons.length;i++) {
			 
			 if(visited[i])
				 continue;
			 
			 if(k < dungeons[i][0])
				 continue;
			 
			 visited[i] = true;
			 dfs(k - dungeons[i][1] ,dungeons,cnt+1);
			 visited[i] = false;
		 }
		 
		 
		 
	 }
    
    
}