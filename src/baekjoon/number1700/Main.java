package baekjoon.number1700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	//	2 7
	//	2 3 2 3 1 2 7
	//	2
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		Integer size = Integer.parseInt(a.split(" ")[0]);
		List<String> list = new ArrayList<>();
		
		String s [] = b.split(" ");
		int cnt =0;
		
		for(int i=0;i < s.length; i++ ) {
			
			if(list.contains(s[i])) {
				continue;
			}
			
			if(list.size() < size) {
				list.add(s[i]);
				continue;
			}
			
			String removeString = search(list,s,i);
//			System.out.println("뽑음:"+removeString);
			// -1 일 경우에는 모든 값들이 뒤에 없음 그냥 아무값이나 빼면됨
			if(removeString == null) {
				list.remove(0);
			}else {
				list.remove(removeString);
			}
				
			list.add(s[i]);
			cnt++;
			
		}
		
		System.out.println(cnt);
		
		
	}
	
	
	//리스트 안에 있는 각각의 값중 최소 값 return;
	public static String search(List<String> list,String [] array,int idx) {
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			map.put(s, searchIdx(array,idx,s));
		}
		
		Integer maxValue = Integer.MIN_VALUE;
		String maxString = "";
		String result = "";
		
		for(String key: map.keySet()) {
			Integer value = map.get(key);
			
			//찾을수 없는 친구가 잇으면 걔를 뽑으면됨.
			if(value.equals(-1)) {
				return key;
			}
			
			
			if(value > maxValue) {
				maxValue = value;
				maxString = key;
				result = key;
			}
		}
		
		if(!maxString.equals(""))
			return result;
		
		
		return null;
	}
	
	
	//해당 value가 array 몇번쨰 idx에 있는지
	public static int searchIdx(String [] array,int idx,String value) {
		for(int i=idx;i<array.length;i++) {
			if(array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

}
