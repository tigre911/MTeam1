
public class PGMS_키패드누르기 {
	public StringBuilder solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		int left =10;
		int right =12;
		for(int num: numbers) {
			if(num==0)num=11;
			
			switch(num%3) {
			case 0 -> {
				answer.append("R");
				right = num;
			}
			case 1 -> {
				answer.append("L");
				left = num;
			}
			case 2 -> {  //mid
				int minusL = Math.abs(num-left); //절댓값
				int minusR = Math.abs(num-right);
				
				int distanceL = (minusL%3) + (minusL/3);
				int distanceR = (minusR%3) + (minusR/3);
				
				if(distanceL < distanceR) {
					answer.append("L");
					left = num;
				} else if(distanceL > distanceR) {
					answer.append("R");
					right = num;
				} else {
					if(hand.equals("right")) {
						answer.append("R");
						right = num;
					} else {
						answer.append("L");
						left = num;
					}
				}
			}
			}
		}
		return answer;
	}
}
