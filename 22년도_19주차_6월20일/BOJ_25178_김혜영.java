import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//두라무리 휴지
public class BOJ_25178 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //단어의 길이
		List<String> al = new ArrayList<>();
		
		al.add("a");
		al.add("e");
		al.add("i");
		al.add("o");
		al.add("u");
		
		char[] arr1 = new char[N];
		char[] arr2 = new char[N];		
		
		String A = br.readLine();
		String B = br.readLine();
		
		int x=0;
		int y=0;

		for(int i=0; i<N; i++) {
			if(!al.contains(A.substring(i, i+1))) {
				arr1[x++]=A.charAt(i);
			}			
			if(!al.contains(B.substring(i, i+1))) {
				arr2[y++]=B.charAt(i);
			}
		}
		
        
		String answer = "YES";
		
		String noVowel1 = new String(arr1);
        String noVowel2 = new String(arr2);

        System.out.println(noVowel1);
        System.out.println(noVowel2);
        
        if((A.charAt(0) != B.charAt(0)) || (A.charAt(N-1) != B.charAt(N-1))){	
        	answer = "NO";
        }else {
        	char[] char1 = A.toCharArray();
            Arrays.sort(char1);
            String sortedStr1 = new String(char1);

            char[] char2 = B.toCharArray();
            Arrays.sort(char2);
            String sortedStr2 = new String(char2);
            
            	//모든 글자 같아야 함				//모음을 제거한 문자열은 같아야함
            if(!sortedStr1.equals(sortedStr2) || !noVowel1.equals(noVowel2)){          
 	           answer = "NO";
 	         //첫글자와 마지막글자 같아야함
 	        }
        }
		System.out.println(answer);	
	}
}
