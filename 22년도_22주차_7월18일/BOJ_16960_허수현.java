package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[m + 1];

        List<List<Integer>> switches = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            switches.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            while (c-- > 0) {
                int x = Integer.parseInt(st.nextToken());
                count[x]++;
                switches.get(i).add(x);
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            boolean check = true;

            for (int s : switches.get(i)) {
                if (count[s] == 1) {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer = 1;
                break;
            }
        }

        System.out.println(answer);
	}

}
