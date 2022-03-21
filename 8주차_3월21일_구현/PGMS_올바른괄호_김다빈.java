package study010;

public class programmers_0101 {
	boolean solution(String s) {
		boolean answer = true;
		int cntOpen = 0; // 여른 괄호의 개수를 세는 변수

		// 예외처리 시작이 )이면 false
		if (s.charAt(0) == ')')
			return false;

		// 문자열 s길이 만큼 반복
		for (int i = 0; i < s.length(); i++) {
			
			// 만약 ( 값이 i에 있으면 cntOpen증가
			if (s.charAt(i) == '(')
				cntOpen++;
			else {	// )인 경우
				// cntOpen-- 를 하기 전에 열린 괄호 수(cntOpen)가 0보다 작거나 같으면 false를 리턴
				if (cntOpen <= 0)
					return false;
				cntOpen--;	// cntOpen감소
			}
		}
		// cntOpen 값이 0이되어야 다 닫히므로 아닌 경우 false
		if (cntOpen != 0)
			return false;

		// 결과 반환
		return answer;
	}
}
