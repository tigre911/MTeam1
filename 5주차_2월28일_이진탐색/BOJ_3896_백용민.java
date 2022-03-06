import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//find() 메서드를 이용해 전체 배열을 true(소수가 아닌 수), false(소수인 수)로 채운 뒤에
//직전과 직후의 소수를 찾아서 차를 구한다.

public class BOJ_3896_백용민 {

     static int N, max = 1299709;

     static boolean prime[];

     public static void main(String[] args) throws IOException {
          BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
          N = Integer.parseInt(bf.readLine());
          prime = new boolean[max + 1];
          find();

          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < N; i++) {
               int num = Integer.parseInt(bf.readLine());
               //소수일 때 if문 입장
               if (!prime[num]) {
                    sb.append(0).append("\n"); //소수면 0을 출력하게끔 만든다.
               } else { //소수가 아닐 때
                    int front = 0, end = 0;
                    //현재 소수가 아닌 수에서 직전의 소수를 찾기 위해서 front--
                    for (front = num - 1; front >= 2 && prime[front]; front--) ;
                    //현재 소수가 아닌 수에서 직후의 소수를 찾기 위해서 end++
                    for (end = num + 1; end <= max && prime[end]; end++) ;

                    //직전, 직후의 소수를 찾은 후에 차를 구해서 출력하게끔 만든다.
                    sb.append(end - front).append("\n");
               }
          }
          System.out.println(sb);
     }


     //소수가 아닌 수는 true로, 소수인 수는 false로 배열 요소 채우기
     public static void find() {
          prime[1] = true;
          for (int i = 2; i <= max; i++) {

               //소수인 숫자만 if문 입장, 소수가 아닌 수일 때는 for문을 건너뛴다.
               if (!prime[i]) {
                    //소수의 배수들을 모두 true로 만들어 소수가 아닌 수로 만들기
                    for (int j = i + i; j <= max; j += i) {
                         prime[j] = true;
                    }
               }
          }

     }
}