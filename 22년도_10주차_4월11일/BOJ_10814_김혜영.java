import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());	//멤버 수
		 
		 //이차원배열 생성
		 String[][] member = new String[N][3];
		 for(int i=0; i<N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 member[i][0]=Integer.toString(i); //가입순서
			 member[i][1]=st.nextToken();	   //나이
			 member[i][2]=st.nextToken();	   //이름
		 }
		 
		//이차원배열 정렬(다중배열 정렬)
		Arrays.sort(member, new Comparator<String[]>() { 
			@Override 
			public int compare(String[] s1, String[] s2) { 
				if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
	                //(2)나이 같을 때, 가입순서 오름차순
	                return Integer.compare(Integer.parseInt(s1[0]), Integer.parseInt(s2[0]));
	            }
	            //(1)나이 오름차순
	            return Integer.compare(Integer.parseInt(s1[1]), Integer.parseInt(s2[1]));
			}
		});
		
		//출력
		for(int i=0; i<N; i++) {
			System.out.println(member[i][1]+" "+member[i][2]);
		}
	}
}
