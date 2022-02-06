import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_18405 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int  N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
		
		//증식 시작 시점의 저장을 위해 배열 2개 생성
		int arr[][] = new int[N][N];
		int arr2[][] = new int[N][N];

		for(int x=0; x<N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y=0; y<N; y++) {
				arr[x][y]=Integer.parseInt(st.nextToken());
			}
		}
                
		//이차원배열 복사
		for(int z = 0; z < arr.length; z++){ // 반복문 + ArrayCopy
			System.arraycopy(arr[z], 0, arr2[z], 0, arr2[z].length);
			}

		//System.out.println(Arrays.deepToString(arr2));
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		//상하좌우 경쟁적 증식
		for(int j=1; j<=S; j++) { //S회 반복
			for(int i=1; i<=K; i++) { //번호가 낮은 종류의 바이러스부터 먼저 증식
				for(int x=0; x<N; x++) {
					for(int y=0; y<N; y++) {
						if(arr[x][y]==i) {
							//행렬테두리의 배열범위 예외처리
							//x값 기준, y값 유지
							if(x==0 && arr2[x+1][y]==0){ //다른 바이러스가 없을 때(0일때) 증식 가능
								arr2[x+1][y]=i;
							}else if(x==N-1 && arr2[x-1][y]==0) {
								arr2[x-1][y]=i;
							}else if(0<x && x<N-1){
								if(arr2[x+1][y]==0) {
								arr2[x+1][y]=i;
								}else if(arr2[x-1][y]==0)
								arr2[x-1][y]=i;
							}
							//y값 기준, x값 유지
							if(y==0 && arr2[x][y+1]==0){
								arr2[x][y+1]=i;
							}else if(y==N-1 && arr2[x][y-1]==0) {
								arr2[x][y-1]=i;
							}else if(0<y && y<N-1){
								if(arr2[x][y+1]==0) {
								arr2[x][y+1]=i;
								} else if (arr2[x][y-1]==0) {
								arr2[x][y-1]=i;
								}
							}//예외
						}
					}
				}
				for(int z = 0; z < arr.length; z++){ // 반복문 + ArrayCopy
					System.arraycopy(arr2[z], 0, arr[z], 0, arr[z].length);
					}
			 //변화시점 일치시키기
			}
			//System.out.println(Arrays.deepToString(arr));
		}	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(arr[X-1][Y-1])); 
        bw.flush();
        bw.close();
	}
}
