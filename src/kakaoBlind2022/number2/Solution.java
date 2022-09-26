package kakaoBlind2022.number2;
class Solution {
	
    public static int solution(int n, int k) {
        int answer = 0;
        
        
        String number = Integer.toString(n,k);
        
        String splitData [] = number.split("0",0);
        
        
        for(String s : splitData) {
        	
        	if(s.isEmpty())
        		continue;
        	
        	if(isPrime(Long.parseLong(s))) {
        		answer++;
        	}
        }
        
        
        return answer;
        
    }
    
    
    public static boolean isPrime(long n) {
    	
    	if(n == 1)
    		return false;
    	
    	for (long i = 2; i<=(long)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
    	}
    	return true;
    }
}