package 이진탐색;

import java.util.*;

class Solution {
     class Trie {
          Map<Integer, Integer> lenMap = new HashMap<>();

          Trie[] child = new Trie[26]; //Trie형 배열

          void insert(String str) {

               Trie node = this;
               int len = str.length(); //str의 길이를 len
               lenMap.put(len, lenMap.getOrDefault(len, 0) + 1); //key = len(길이), value = len에 대한 value가 있다면 value + 1, 없으면 0 + 1

               for (char ch : str.toCharArray()) { //str을 char 배열로 만들어서 한 글자씩 for문 입장
                    int idx = ch - 'a'; //해당 글자를 a(97)로 빼준다.
                    if (node.child[idx] == null) //child[idx]가 null이라면
                         node.child[idx] = new Trie(); //해당 index에 새로운 Trie 객체 생성

                    node = node.child[idx]; //해당 True 객체를 node 변수에 저장
                    node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1); //key = len(길이), value = len에 대한 value가 있다면 value + 1, 없으면 0 + 1
               }
          }

          int find(String str, int i) {
               if (str.charAt(i) == '?')
                    return lenMap.getOrDefault(str.length(), 0);

               int idx = str.charAt(i) - 'a';
               return child[idx] == null ? 0 : child[idx].find(str, i + 1);
          }
     }

     public int[] solution(String[] words, String[] queries) {
          Trie front = new Trie();
          Trie back = new Trie();

          for (String word : words) {
               front.insert(word);
               back.insert(reverse(word));
          }

          return Arrays.stream(queries).mapToInt(
                  query -> query.charAt(0) == '?' ?
                          back.find(reverse(query), 0) :
                          front.find(query, 0)).toArray();
     }

     String reverse(String s) {
          return new StringBuilder(s).reverse().toString();
     }
}