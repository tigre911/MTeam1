package week13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PGMS_신고결과받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> mail = new HashMap<>();
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(int i=0 ; i<id_list.length ; i++) {
        	mail.put(id_list[i],i);
		}
        
        for(String a: report) {
        	String[] id=a.split(" ");
        	String fromId=id[0], toId=id[1];
        	if(!map.containsKey(toId)) map.put(toId, new ArrayList<>());
        	List<Integer> tmp = map.get(toId);
        	if(!tmp.contains(mail.get(fromId))) tmp.add(mail.get(fromId));
        }
        
        for(int i=0 ; i<id_list.length ; i++) {
        	String id = id_list[i];
        	if(map.containsKey(id) && map.get(id).size()>=k) {
	        	for(int idx : map.get(id)) {
	        		answer[idx]++;
	        	}
        	}
        }
        
        return answer;
    }
}
