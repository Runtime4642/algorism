package baekjoon.number11724;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	/*
	6 5
	1 2
	2 5
	5 1
	3 4
	4 6
	
	2
	*/
	
	static boolean[] visited;
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		Node [] array = new Node[n+1];
		visited = new boolean[n+1];
		
		
		for(int i=0;i<n;i++) {
			array[i+1] =new Node(i+1);
		}
		
		
		for(int i=0;i<l;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			array[a].add(b);
			array[b].add(a);
		}

		int result = 0;
		for(int i=1;i<array.length;i++) {
			result += dfs(i,array);
		}
		
		System.out.println(result);
	}
	
	public static int dfs(int num,Node [] array) {
		
		//이미 방문
		if(visited[num])
			return 0;
		
		visited[num] = true;
		
		List<Integer> list = array[num].getList();
		for(Integer nextNum : list) {
			dfs(nextNum,array);
		}
				
		return 1;
	}

}

class Node{
	
	int num;
	List<Integer> list = new ArrayList<>();
	
	public Node(int num) {
		this.num= num;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<Integer> getList() {
		return list;
	}
	public void add(int value) {
		this.list.add(value);
	}
}
