package week10;

public class PGMS_12909 {
	boolean solution(String s) {
		boolean answer = true;
		int sum = 0;

		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '(') {
				sum++;
			} else {
				sum--;
			}
			if (sum < 0) {
				answer = false;
				break;
			}
		}
		if (sum != 0) {
			answer = false;
		}
		return answer;
	}
}
