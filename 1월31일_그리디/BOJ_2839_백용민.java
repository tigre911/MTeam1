package yes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_백용민 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int count = 0;

		while(true) {
			if(num%5 == 0) {
				count += num/5;
				break;
			} else {
				num -= 3;
				count++;
				if(num%5==0) {
					count += num/5;
					break;
				}
				if(num < 0) {
					System.out.println(-1);
					System.exit(0);
				}

			}
		}
		System.out.println(count);
	}
}
