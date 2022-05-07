package week10;

public class PGMS_키패드누르기 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String ans = solution(numbers, hand);
		System.out.println(ans);
	}
	private static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		int left=10, right=12;
		int Ldis, Rdis;
		for(int n : numbers) {
			Ldis = 0; Rdis = 0;
			if(n == 1 || n == 4 || n == 7) {
				answer.append("L");
				left = n;
			
			}else if(n == 3 || n == 6 || n == 9) {
				answer.append("R");
				right = n;
			
			}else {
				if(n==0) n += 11;
				Ldis = (Math.abs(n-left))/3 + (Math.abs(n-left))%3;
				Rdis = (Math.abs(n-right))/3 + (Math.abs(n-right))%3;
				if(Ldis == Rdis) {
					if(hand.equals("right")) {
						answer.append("R");
						right = n;
					}else {
						answer.append("L");
						left = n;
					}
				}else if(Ldis > Rdis) {
					answer.append("R");
					right = n;
				}else {
					answer.append("L");
					left = n;
				}
			}
		}
		
		
		
		return answer.toString();
	}
}
