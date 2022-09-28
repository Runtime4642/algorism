package kakaoBlind2022.number1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		
		String [] s = {"muzi", "frodo", "apeach", "neo"};
		String [] b = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		solution(s,b, 2);
		
	}
	
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Set<String>> map = new HashMap<>();
        
        for(String s : report) {
        	String name1 = s.split(" ")[0];
        	String name2 = s.split(" ")[1];
        	Set<String> set = map.getOrDefault(name2, new HashSet<String>());
        	set.add(name1);
        	map.put(name2, set);
        }
        
        for(String key:map.keySet()) {
        	Set<String> set = map.get(key);
        	
        	if(set.size() < k)
        		continue;
        	
        	for(String name : set) {
        		answer[searchIdx(id_list,name)] += 1;
        	}
        }
        
        
        
        return answer;
    }
    
    public static int searchIdx(String[] id_list,String value) {
    	int idx = -1;
    	for(int i=0;i<id_list.length;i++)
    		if(id_list[i].equals(value))
    			idx = i;
    	
    	return idx;
    }
	
	
}
