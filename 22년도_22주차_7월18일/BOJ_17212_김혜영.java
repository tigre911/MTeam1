import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//달나라 토끼를 위한 구매대금 지불 도우미
public class BOJ_17212_김혜영 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//1, 2, 5, 7원
		//동전 개수 최소
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int money = Integer.parseInt(br.readLine());
		int answer = 0; //동전의 개수
		
		answer += money/7;
		money = money%7;
		
		if(answer>0 && money==3) { //예외 빼주기
			answer--;
			money = 10;
		}
		
		answer += money/5;
		money = money%5;
		
		answer += money/2;
		money = money%2;
		
		answer += money;

		System.out.println(answer);
	}
}
