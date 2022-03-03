package baek.feb_28_binary_search;

import java.util.Arrays;

public class PGMS_lyricsSearch {
    static class Trie{ //정방향과 역방향 
        int count = 0;
        Trie[] childNode;

        Trie(){ //루트 노드용
            childNode = new Trie[26];
        }

        void addNode(char[] words){ //words를 저장시 사용(?는 고려하지 않음)
            Trie current = this;
            char newKey;
            count++; //문자열 전체가 '?'인 경우를 위해 
            for(int i=0; i<words.length; i++){
                newKey = words[i];

                if(current.childNode[newKey-97]==null){
                    current.childNode[newKey-97] = new Trie();
                }

                current = current.childNode[newKey-97];
                current.count++;
            }
        }

        int searchNode(String query, boolean needReverse){ //'?'의 접두,접미,전체 여부 판별은 solution에서 구현
            Trie current = this;
            char findKey;
            int result = 0;

            if(needReverse){ //'?'가 접두사인 경우
                for(int i=query.length()-1; i>=0; i--){
                    findKey = query.charAt(i);
                    if(findKey=='?'){ //찾는 문자가 '?'라면 바로 전까지의 문자는 모두 일치한다는 뜻이므로
                        break;
                    }
                    current = current.childNode[findKey-97];
                    if(current==null){ //찾는 문자와 일치하는 노드가 비었다는 것은 일치하는 문자가 없다는 의미

                        return 0;
                    }
                    //찾는 문자가 '?'도 아니고 일치하는 노드도 비어있지 않다면 
                    //해당 지점까지 문자열이 일치한다는 뜻이므로 result를 갱신
                    result = current.count;
                }
            }else{ //'?'가 접미사인 경우
                for(int i=0; i<query.length(); i++){
                    findKey = query.charAt(i);
                    if(findKey=='?'){
                        break;
                    }
                    current = current.childNode[findKey-97];
                    if(current==null){
                        return 0;
                    }
                    result = current.count;
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(solution(words, queries)));
    }
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie[][] wordTrie = new Trie[10001][2]; //가사 단어의 길이별로, 그리고
                                                //각 길이별로 원래 순서와 역순, 두 개의 Trie를 생성
                                                //ex) wordTrie[11][0]에는 길이가 11인 단어의 원래 순서 Trie가,
                                                //    wordTrie[11][1]에는 같은 단어의 역순 Trie가 들어감
        for(int i=1; i<10001; i++){
            wordTrie[i][0] = new Trie();
            wordTrie[i][1] = new Trie();
        }
        int wLength = 0;
        char[] reversed;
        for(String word:words){
            wLength = word.length();          
            wordTrie[wLength][0].addNode(word.toCharArray());
            reversed = new char[wLength];
            for(int i=0; i<wLength; i++){
                reversed[i] = word.charAt(wLength-1-i);
            }
            wordTrie[wLength][1].addNode(reversed);
        }

        int qLength = 0;
        for(int i=0; i<queries.length; i++){
            qLength = queries[i].length();
            if(queries[i].charAt(0)=='?' && queries[i].charAt(qLength-1)=='?'){
                answer[i] = wordTrie[qLength][0].count;
            }else if(queries[i].charAt(0)=='?'){
                answer[i] = wordTrie[qLength][1].searchNode(queries[i], true);
            }else if(queries[i].charAt(qLength-1)=='?'){
                answer[i] = wordTrie[qLength][0].searchNode(queries[i], false);
            }
        }

        return answer;
    }
}

/*
    선형 탐색 = 적은 메모리 사용량, 비효율적
    trie를 이용한 탐색 = 메모리 사용량 높음, 효율적

    trie를 두 개 준비 : 하나는 words를 순서대로 삽입(?가 접미사인 경우 사용), 다른 하나는 역순으로 삽입(?가 접두사인 경우 사용)
    word의 길이별로 trie를 생성.
    결과적으로 trie의 갯수 = 모든 word의 길이 가짓수 * 2(정방향,역방향)

    trie에 필요한 요소 = {
        문자 하나를 저장할 변수(char) : 단어의 처음부터 한 글자씩 트리구조로 나누기 때문,
        해당 문자까지의 문자열을 가지는 단어 수(int) : 예를 들어 "abcx","abvx","abwr"이 들어간다면 b노드의 해당 변수는 3이 됨
        다음 노드들이 들어갈 배열(Trie) : 알파벳은 소문자만 사용되므로 길이가 26인 고정 문자열 사용
    }

*/