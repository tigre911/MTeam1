import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431_시리얼번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//기타의 개수

		String[][] serials = new String[N][3];//시리얼 번호
		
		for(int i=0; i<N; i++) {
			serials[i][0] = br.readLine();	  //시리얼번호
			serials[i][1] = Integer.toString(serials[i][0].length());	//시리얼번호의 길이
			int sum=0;	//숫자의 합
			//숫자 추출하기
			for(int j=0; j<Integer.parseInt(serials[i][1]); j++) {	
				int num = serials[i][0].charAt(j) -'0';
			    if (0 <= num && num <= 9) {
			    	sum += num;
			    }
			}
			serials[i][2] = Integer.toString(sum);	//숫자의 합
		}
		

		//이차원배열 정렬(다중배열 정렬)
		Arrays.sort(serials, new Comparator<String[]>() { 
			@Override 
			public int compare(String[] s1, String[] s2) { 
				if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
					if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
						//(2)길이, 숫자의합 같을 때 char 오름차순
						int i=0;
						while(s1[0].charAt(i)==s2[0].charAt(i)) {
							i++;
						}
				        return Integer.compare(s1[0].charAt(i), s2[0].charAt(i));
				     }
			         //(2)길이 같을 때, 숫자의합 오름차순
			         return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
			     }
			     //(1)길이 오름차순
			     return Integer.compare(Integer.parseInt(s1[1]), Integer.parseInt(s2[1]));
			}
		});	
		for(int i=0; i<N; i++) {
			System.out.println(serials[i][0]);
		}
	}
}
