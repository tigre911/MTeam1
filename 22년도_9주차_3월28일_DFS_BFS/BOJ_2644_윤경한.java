package baek.march_28_dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2644 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n+1];
        String[] AB = reader.readLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        int m = Integer.parseInt(reader.readLine());

        for(int i=0; i<m; i++){
            String[] xy = reader.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            arr[y] = x;
        }

        System.out.println(chonsu(arr, A, B));
    }
    static int chonsu(int[] arr, int A, int B){
        int answer = -1;

        int cnt = 1;
        int fromA = A; //현재 지점(A에서 출발)
        int fromB = B; //현재 지점(B에서 출발)
        List<Integer> Alist = new ArrayList<>();
        List<Integer> Blist = new ArrayList<>();

        while(arr[fromA]!=0){
            if(arr[fromA]==B){
                return cnt;
            }else{
                fromA = arr[fromA];
                Alist.add(fromA);
                cnt++;
            }
        }
        cnt = 1;
        while(arr[fromB]!=0){
            if(arr[fromB]==A){
                return cnt;
            }else{
                fromB = arr[fromB];
                Blist.add(fromB);
                cnt++;
            }
        }
        cnt = 1;
        for(int a:Alist){
            int cnt2 = 1;
            for(int b:Blist){
                if(a==b){
                    return cnt+cnt2;
                }
                cnt2++;
            }
            cnt++;
        }

        return answer;
    }
}
