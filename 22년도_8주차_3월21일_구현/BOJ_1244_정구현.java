package Algorithm.BaekjoonOnlineJudge.BOJ_1244;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1244_정구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // 스위치의 개수
        int s_num =Integer.parseInt(br.readLine());

        //각 스위치의 상태(스위치의 개수만큼 선언)
        int switches[] = new int[s_num];
        st = new StringTokenizer(br.readLine());

        //배열 초기화
        for (int i = 0; i < s_num; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        //학생수 선언
        int p_num = Integer.parseInt(br.readLine());

        while(p_num>0){

            st = new StringTokenizer(br.readLine());
            //학생의 성별과 스위치 위치
            int gender = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            //남자일 경우
            if(gender==1){
                for(int i = location-1; i<s_num; i+=location){
                    //0이면 1로, 1이면 0으로 변경
                    switches[i] = switches[i] == 0? 1: 0;
                }
            }
            //여자일경우
            else{
                location = location -1;
                switches[location] = (switches[location]+1) % 2;
                for(int i=1;i<switches.length;i++) {
                    if((location-i) >=0 && (location+i)<switches.length) {
                        if(switches[location -i] == switches[location+i]) {
                            switches[location-i] = (switches[location-i]+1) % 2;
                            switches[location+i] = (switches[location+i]+1) % 2;
                        }
                        else
                            break;
                    }
                }
            }
            p_num--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<switches.length;i++) {
            sb.append(switches[i]+" ");
            if((i+1) %20 == 0) {
                sb.setLength(sb.length()-1);
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }

            if(i == switches.length-1 && (i+1)%20 != 0) {
                sb.setLength(sb.length()-1);
                System.out.print(sb.toString());
            }
        }



    }
}
