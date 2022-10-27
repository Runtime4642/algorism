package baekjoon.number1062;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static boolean visited [][];
	static int MAX_VALUE = Integer.MIN_VALUE;

	/*
	3 6
	antarctica
	antahellotica
	antacartica
	
	*/

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int r = sc.nextInt();
		
		sc.nextLine();
		
		String [] s= new String[k];
		for(int i=0;i<k;i++) {
			s[i] = sc.nextLine();
		}
		
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};

		
       Combination comb = new Combination(arr.length, r);
       comb.combination(arr, 0, 0, 0);
        
        ArrayList<String> result = comb.getResult();

//        System.out.println("모든 조합의 수: " + result.size());
        for (int i = 0; i < result.size(); i++) {
        	
        	int cnt =0;
        	for(String h : s) {
        		
        		String copy = h;
        		
                for (int j = 0; j < result.get(i).length(); j++) {
                	String c = Character.toString(result.get(i).charAt(j));
                	copy = copy.replaceAll(c,"");
                }
        		
                if(copy.length() == 0) {
                	cnt++;
                }
        	}
        	
        	MAX_VALUE =Math.max(MAX_VALUE, cnt);
        }
        
        System.out.println(MAX_VALUE);
		
	}

}

class Combination {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<String> result; // 모든 조합
	static String [] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public ArrayList<String> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<String>();
    }

    public void combination(int[] arr, int depth, int index, int target) {
        if (depth == r) {
        	
            String temp = new String();
            for (int i = 0; i < now.length; i++) {
                temp += arr[now[i]];
                
                temp += alphabet[arr[now[i]]];
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

