import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14487 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String arr[] = s.split(" ");
		int money[] = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			mon[i] = Integer.parseInt(arr[i]);
		}
		
		// 가장 큰 값(max) 구하기
		int max=0;
		for(int i=0; i<money.length; i++) {
			if(money[i] > max) {
				max=money[i];
			}
		}
		
		//비용의 총합 구하기
		int sum = 0;
		for(int i=0; i<money.length; i++) {
			sum += money[i];
		}
		
		// 총합에서 가장 큰 값 빼기
		System.out.println(sum-max);
	}
}
