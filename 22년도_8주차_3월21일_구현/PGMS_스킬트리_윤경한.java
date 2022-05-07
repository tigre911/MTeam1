package baek.march_21_impl;

public class PGMS_skill_tree {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] order = new int[26];
        int cnt = 1;
        int sLength = skill.length();

        for(int i=0; i<sLength; i++){
            order[skill.charAt(i)-'A'] = cnt++;
        }

        for(String eachTree:skill_trees){
            int tLength = eachTree.length();
            int tIdx = 0;
            int idxTmp = 0;
            boolean isFit = true;
            while(tIdx<tLength){
                if(order[eachTree.charAt(tIdx)-'A']==idxTmp+1){//선행트리에 맞게 스킬이 들어 있을 때
                    idxTmp++;
                    tIdx++;
                }else if(order[eachTree.charAt(tIdx)-'A']==0){//선행트리에 없는 스킬일 때
                    tIdx++;
                    continue;
                }else{
                    isFit = false;
                    break;
                }
            }
            if(isFit){
                answer++;
            }
        }

        return answer;
    }
}
