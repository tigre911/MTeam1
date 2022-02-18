import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10825 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[][] score = new String[N][5];

		//입력
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			score[i][0] = st.nextToken(); //이름	
			score[i][1] = st.nextToken(); //국어 
			score[i][2] = st.nextToken(); //영어
			score[i][3] = st.nextToken(); //수학
			
			
		}
		
		//이차원배열 정렬(다중배열 정렬)
		Arrays.sort(score, new Comparator<String[]>() { 
			@Override 
			public int compare(String[] s1, String[] s2) { 
				if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
                    if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
                        if (Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {
                            //국영수 점수가 같다면 사전 오름차순
                            return s1[0].compareTo(s2[0]);
                        }
                        //국어점수 같고 영어점수 같을 때, 수학 점수는 내림차순
                        return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));
                    }
                    //국어 점수 같을 때, 영어 점수는 오름차순
                    return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
                }
                //국어점수는 내림차순
                return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
			}
		});

		//이름 출력
		for(int i=0; i<N; i++) {
			bw.write(score[i][0]+"\n");
		}
		bw.flush();
		bw.close();
	}
}

