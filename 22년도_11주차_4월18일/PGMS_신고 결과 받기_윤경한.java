package baek.apr_18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> reported = new HashMap<String, Set<String>>();
        for(String each:report){
            String[] s = each.split(" ");
            String ss = s[0];
            String dd = s[1];
            
            if(!reported.containsKey(dd)){
                Set<String> set = new HashSet<>();
                set.add(ss);
                reported.put(dd, set);
                
            }else{
                if(!reported.get(dd).contains(ss)){
                    reported.get(dd).add(ss);
                }else{
                    continue;
                }
            }
        }
        for(String each:id_list){
            if(reported.containsKey(each) && reported.get(each).size()>=k){
                for(String reporter:reported.get(each)){
                    for(int i=0; i<id_list.length; i++){
                        if(id_list[i].equals(reporter)){
                            answer[i]++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
