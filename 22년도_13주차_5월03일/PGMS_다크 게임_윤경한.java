package baek.may_3;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int cnt = -1;
        char[] arr = dartResult.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='0' && arr[i]<='9'){
                cnt++;
                score[cnt] = (int)arr[i]-48;
                if(arr[i+1]=='0'){
                    score[cnt] = 10;
                    i++;
                }
            }else if(arr[i]=='D'){
                score[cnt] *= score[cnt];
            }else if(arr[i]=='T'){
                score[cnt] *= score[cnt]*score[cnt];
            }else if(arr[i]=='*'){
                score[cnt] *= 2;
                if(cnt>0) score[cnt-1] *= 2;
            }else if(arr[i]=='#'){
                score[cnt] = -score[cnt];
            }
        }

        return score[0]+score[1]+score[2];
    }
}
