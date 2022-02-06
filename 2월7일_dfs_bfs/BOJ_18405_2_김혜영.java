import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//경쟁적 전염
//BFS로 구현하기
public class BOJ_18405_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       int N = Integer.parseInt(st.nextToken());
	       int K = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[N][N];

			for(int x=0; x<N; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<N; y++) {
					arr[x][y]=Integer.parseInt(st.nextToken());
				}
			}
	                
			//System.out.println(Arrays.deepToString(arr2));
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken())-1;
			int Y = Integer.parseInt(st.nextToken())-1;
			
			if(arr[X][Y]!=0) { 
				//만약 이미 바이러스가 있다면 그대로 출력하고 종료.
				System.out.println(arr[X][Y]); 
				System.exit(0); 
			}
			
			int[] dx = {-1, 1, 0, 0}; 
			int[] dy = {0, 0, -1, 1}; 
			for(int t=0; t<S; t++) { //S초
				for(int z=1; z<=K; z++) { //K개의 바이러스 
					Queue<Integer> xx = new LinkedList<Integer>(); 
					Queue<Integer> yy = new LinkedList<Integer>(); 
					//큐에 넣은 다음 마지막에 한 번에 처리 해준다. 
					//한번에 처리하지 않으면 아래에서 한번씩 더 바이러스가 퍼지는 논리오류 발생
					for(int i=0;i<N;i++) { 
						for(int j=0;j<N;j++) { 
							if(arr[i][j]==z) { 
								//만약 현재 퍼질 바이러스의 칸에 왔다면, 
								for(int d=0;d<4;d++) { 
									//배열범위에서 벗어나면 에러생기므로 새로운 변수 설정
									int nowi = i+dx[d]; 
									int nowj = j+dy[d]; 
									if(nowi<0 || nowi>=N || nowj<0 || nowj>=N) continue; 
									//범위에서 벗어나지 않으면 컨티뉴
									if(arr[nowi][nowj]==0) { 
										xx.add(nowi); yy.add(nowj); 
									} 
								}
							}
						}
					}
				
					while(!xx.isEmpty()) { //큐에서 출력하여 배열인덱스값으로 설정
						arr[xx.poll()][yy.poll()] = z; 
						} 
					} if(arr[X][Y]!=0) { 
						//만약 이미 바이러스가 있다면 그대로 출력하고 종료. 
						System.out.println(arr[X][Y]); 
						System.exit(0);

					}
				System.out.println(Arrays.deepToString(arr));
			}	
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(String.valueOf(0)); 
	        bw.flush();
	        bw.close();
		}
	}