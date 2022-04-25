import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
		//중복제거
		ArrayList<String> arr = new ArrayList<>();
		for(String i : report) {
			arr.add(i);
		}
		HashSet<String> arr2 = new HashSet<>(arr);
		Iterator<String> iter = arr2.iterator();
		
		//중복 제거된 데이터 입력
		String[][] report_reported = new String[arr2.size()][2];
		int j=0;
		while(iter.hasNext()) {//값이 있으면 true 없으면 false
			String[] arr3 = ((String) iter.next()).split(" ");
			report_reported[j][0] = arr3[0];	//신고한 사람
			report_reported[j][1] = arr3[1];	//신고받은 사람		
			j++;
		}
		
		//신고횟수
		Map<String, Integer> repo_Num = new LinkedHashMap<>(id_list.length);
		//메일횟수
		Map<String, Integer> email_Num = new LinkedHashMap<>(id_list.length);
		for(String id : id_list) {
			repo_Num.put(id, 0);	//(아이디, 횟수)
			email_Num.put(id, 0);
		}
		
		for(int i=0; i<arr2.size(); i++) {
			int num = repo_Num.get(report_reported[i][1]) + 1;	//해당 이름의 신고 횟수+1
			repo_Num.replace(report_reported[i][1], num);	//hashmap 값 교체
		}
		
		//메일 보내기
		for(String id : id_list) {
			if(repo_Num.get(id)>=k) {	//해당 아이디의 신고횟수가 k이상일 때
				for(int i=0; i<arr2.size(); i++) {
					if(report_reported[i][1].equals(id)) {
						int email = email_Num.get(report_reported[i][0]);	//신고자가 받는 이메일 수
						email_Num.replace(report_reported[i][0], email+1);	//+1
					}
				}
			}
		}
		int[] answer = new int[id_list.length];
		for(int i=0; i<id_list.length; i++) {
			answer[i]=email_Num.get(id_list[i]);
		}
		return answer;
	}
}
