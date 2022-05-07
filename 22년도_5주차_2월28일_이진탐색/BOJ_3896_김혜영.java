import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3896_소수사이수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//에라토스테네스의 체: 배수를 지우기
		boolean prime[] = new boolean[1299710];
        for(int i=2; i<1299710; i++) 				
            for(int j=i; i*j>2 && i*j<1299710; j++)	
                prime[i*j] = true; //소수 아닌 수==true
		
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {  //N회 반복
			int k = Integer.parseInt(br.readLine());
		    if(prime[k]) { 					//소수가 아닐 때
		    	int s = k;
		    	int e = k;
		    	while(true) {
		    		if(!prime[--s]) break;
		    	}
		    	while(true) {
		    		if(!prime[++e]) break;
		    	}
		    	System.out.println(e-s);
		    } else System.out.println(0);	//소수일 때
		}
	}
}