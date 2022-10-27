import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static boolean [] visited;
	public static boolean [] visited2;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		
		V [] array = new V[n+1];
		visited = new boolean[n+1];
		visited2 = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			array[i] = new V(i);
		}
		
		for(int i=0;i<m;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			array[num1].addNext(num2);
			array[num2].addNext(num1);
		}
		
		visited[start] = true;
		dfs(start,array);
		System.out.println();
		
		visited2[start] = true;
		bfs(start, array);
		
	}
	
	public static void bfs(int num,V [] array) {
		
		System.out.print(num+" ");
		V current = array[num];
		List<Integer> nextList =current.getNextList();
		Collections.sort(nextList);
		
		while(nextList.size() > 0) {
			
			Integer nextNum = nextList.get(0);
			nextList.remove(0);
			if(visited2[nextNum])
				continue;
			
			System.out.print(nextNum+" ");
			visited2[nextNum]=true;
			nextList.add(nextNum);
			List<Integer> connetList = array[nextNum].getNextList();
			Collections.sort(connetList);
			for(Integer connetNum : connetList) {
				nextList.add(connetNum);
			}
		}
		
	}
	
	public static void dfs(int num,V [] array) {
		
		V current = array[num];
		System.out.print(num+" ");
		List<Integer> nextList =current.getNextList();
		
		Collections.sort(nextList);
		
		for(Integer nextNum : nextList) {
			
			if(visited[nextNum])
				continue;
			
			visited[nextNum] = true;
			dfs(nextNum,array);
		}
	}
	
	

}

class V {
	Integer num;
	List<Integer> next;
	
	public V(int num) {
		this.num = Integer.valueOf(num);
		this.next = new ArrayList<Integer>();
	}
	
	public void addNext(Integer num) {
		this.next.add(num);
	}
	
	public List<Integer> getNextList() {
		return this.next;
	}
	
	public Integer getNum() {
		return num;
	}
	
}
