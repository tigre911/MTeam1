import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_9237 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String[] arr= s.split(" ");
		int[] day = new int[N];
		
		for(int i=0; i<N; i++) {
			day[i]=Integer.parseInt(arr[i]);
		}

		//insertion sort(descending)
		for(int i=1; i<N; i++) {
			int temp = day[i];
			int j;//3
			for(j=i; j>0 && day[j-1]<temp; j--) {
				day[j] = day[j-1];
			}
			day[j]=temp;
		}	
		
		//(day[i](기간) + (i+1)(일차) + 1(다음날))의 max구하기
		int max=0;
		for(int i=0; i<N; i++){
		if(max < day[i]+i+2) {
			max=day[i]+i+2;
		}
		}
		//System.out.println(Arrays.toString(day));
		String S = Integer.toString(max);
		bw.write(S);
		bw.flush();
		bw.close();
	}
}
