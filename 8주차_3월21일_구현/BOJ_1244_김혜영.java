import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1244번: 스위치 켜고 끄기
public class BOJ_1244_스위치켜고끄기 {
	static int[] arr;
	static int[][] student;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine());
		
		arr = new int[switchNum+1];// 0: 꺼짐,   1: 켜짐
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		

		int studentNum = Integer.parseInt(br.readLine());
		
		student = new int[studentNum][2];
		//[][0]=1: 남학생,   [][0]=2: 여학생
		
		//입력
		for(int i=0; i<studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				student[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//System.out.println(Arrays.toString(arr));
		//스위치 바꾸기
		for(int i=0; i<student.length; i++) {
			if(student[i][0]==1) { //1: 남학생
				int a = student[i][1];
				for(int j=1; j<=(arr.length-1)/a; j++) { //arr.length==9
					swithState(arr,a*j);
				}
			}else{ //2: 여학생
				int x = student[i][1]-1; //2
				int y = student[i][1]+1; //4
				
				while(x>0 && y<arr.length && arr[x]==arr[y]) {
					x--; //1 //0
					y++; //5 //6
				}
				for(int j=x+1; j<y; j++) //x+1부터 y-1까지 스위치(1~5)
				swithState(arr,j);
			}
		}
		//System.out.println(Arrays.toString(arr));
		
		for(int i=1; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) { //20개씩 출력
				System.out.println();
			}
		}
	}
	private static void swithState(int[] arr, int i) {
		if(arr[i]==0) {
			arr[i]=1;
		} else {
			arr[i]=0;
		}
		//System.out.println(Arrays.toString(arr));
	}
}
