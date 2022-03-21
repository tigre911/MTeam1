package Algorithm.PGMS.스킬트리;

public class PGMS_스킬트리_정구현 {
    public static void main(String[] args) {
        Solution s = new Solution();

    }


}

class Solution{
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skillTree : skill_trees){
            String tempSkill = skillTree;

            for(int i = 0; i < skillTree.length(); i++){
                String s = skillTree.substring(i,i+1);
                if(!skill.contains(s)){
                    tempSkill= tempSkill.replace(s, ""); //필수 스킬이 아닐경우 공백처리

                }
            }
            //temp문자열이 앞에서부터 처음 발견되는 인덱스를 반환
            if(skill.indexOf(tempSkill)==0)
                answer++;
        }


        return answer;

    }
}