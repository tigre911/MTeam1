import java.util.LinkedList;
import java.util.Queue;

public class PGMS_스킬트리 {
	public static void main(String[] args) {
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution("CBD", skill_trees));
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] arr = new char[skill.length()];
        //스킬배열 입력
        for(int i=0; i<skill.length(); i++) {
	        arr[i] = skill.charAt(i);
	    }
        
        //스킬확인
        for(int i=0; i<skill_trees.length; i++) {
        	String s = skill_trees[i];
        	int cnt=0;
        	for(int j=0; j<s.length(); j++) {
        		if(skill.contains(String.valueOf(s.charAt(j)))) {// s 중에 스킬이 있고
        			if(s.charAt(j)==arr[cnt]) {					 //스킬첫번째라면
        				cnt++;							
        			}else {										 //첫번째가 아니라면 답 제외
        				break;
        			}	
        		}
        		if(j==s.length()-1) {	//for문을 제대로 돌았다면 정답
        			answer++;
        		}
        	}
        }
        return answer;
	}
}
