public class PGMS_올바른괄호 {
	static boolean solution(String s) {
		boolean answer = false;
		int cnt1=0;
		int cnt2=0;
		
		if(countChar(s,'(')==countChar(s,')')) { 	//  조건: '(', ')'의 개수 동일
			answer = A(s,0);
			
			for(int i=0; i<s.length()-1; i++) {	
				if(s.charAt(i) == '(') {
					cnt1++;
				}else { 	   // ')'
					cnt2++;
				}
				if(cnt1==cnt2) {
					answer = A(s,i+1);
				}
				if(answer==false) {
					return answer;
				}
			}	
		}//else answer=false;
		return answer; 
	}
	public static int countChar(String str, char ch) {
	   int count = 0;
	   for (int i = 0; i < str.length(); i++) {
		   if (str.charAt(i) == ch) {
			   count++;
		   	}
	   }
	   return count;
	}
	//첫글자가 ')'인지 판별 -> false
	public static boolean A(String s, int i) {
		if(s.charAt(i)==')') {
			return false;
		}
		return true;
	}
}
