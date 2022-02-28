package study004;
import java.util.*;
import java.io.*;

public class BOJ_1388_김다빈 {

	/*	

	Char 단위의 입출력 (Reader/Writer) : 문자 단위의 입출력에 특화된 기능을 제공
		
		1. Reader : Char단위 입력을 수행하는 추상 클래스로 [FileReader][BufferedReader][InputStreamReader]
			# 주요 메서드
				- int skip(long n)			: n개의 char 스킵하기 (실제 스킵된 char 수 리턴)
				- int read()				: int(4byte)의 하위 2byte에 읽은 데이터를 저장하여 리턴
				- int read(char[] cbuf)		: 읽은 데이터를 cahr[] cbuf에 저장하여 읽은 char 수를 리턴
				- abstract int read(char[] cbuf, int off, int len)	: length 개수만큼 읽은 데이터를 char[] cbuf의 offset위치 부터 저장(추상메서드)
				- abstract void close()		: Reader의 자원반환
		
		
		
		2. Writer : char단위 출력을 수행하는 추상 클래스로 [FileWriter][BufferedWriter][OutputStreamWriter][PrintWriter]
			# 주요 메서드
				- abstract void flush()		: 메모리 버퍼에 저장된 데이터를 내보내기
				- void write(int c)			: int(4byte)의 하위 2byte를 메모리버퍼에 출력
				- void write(char[] cbuf)	: 매개변수로 넘겨진 char[] cbuf 데이터를 메모리 버퍼에 출력
				- void write(Stirng str)	: 매개변수로 넘겨진 String 값을 메모리 버퍼에 출력
				- void Write(Stirng str, int off, int length)		: str의 offset위치에서부터 length 개수를 읽어와 메모리 버퍼에 출력
				- abstract void write(char[] cbuf, int off, int len): char[]의offset위치에서부터 length의 개수를 읽어와 출력(추상메서드)
				- abstract void close()		: Reader의 자원 반환 (추상메서드)
		
		
		
		3.BufferedReader / BufferedWriter 
		
		- 입출력과정에서 메모리 버퍼를 사용함으로써 속도 향상
		
		- BufferedReader 생성자
			BufferedReader(Reader in) // Default Buffer size 사용
			BufferedReader(Reader in, int size) // 직접 Buffer size 지정
		
		- BufferedReader 추가 메서드
			String readLine() 한 줄 씩 읽어  String으로 리턴

		-  BufferedWriter 생성자
			BufferedWriter(Writer out)
			BufferedWriter(Writer out, int size)



		4. InputStreamReader / OutputStreamWriter
		
		- Byte 단위 입출력 → Char 단위 입출력으로 변환
		
		- 문법적인 구조는 InputStream을 Reader로 만들고 OutputStream을 Writer로 만든다.
		
		- 실제로는 InputStream을 Reader로 만들면 InputStreamReader 가 만들어진다.
		
		- OutputStreamWriter는 Writer를 OutputStream 으로 쓰는 것
		
		- InputStreamReader 생성자
			InputStream  Byte단위 → Reader Char 단위
			InputStreamReader(InputStream in) // Default Charset 
			InputStreamReader(InputStream in, Charset cs)  // Charset에 따라 문자를 읽어 char 형태로 출력
			InputStreamReader(InputStream in, String charsetName)
			
		- Charset.dafaultCharset() = MS949인 경우 → UTF-8 파일 읽어오기



	*/
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// bufferReader를 InputStream에 읽어오기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	// bufferWriter를 OutputStream에 읽어오기
        StringBuilder sb = new StringBuilder();						// 16크기의 빈문자열 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine());	// 문자열을 여러개의 문자열로 분리하기 위해 사용
        
        /* 
        String Builder
		- 객체 생성시 일정 크기(16)를 갖는 빈 문자열 객체가 생성된다.
		- 문자열 대입 시에 빈 공간에 문자가 할당되는 방식.
		- 메서드는 StringBuffer와 거의 같다.

		String Tokenizer 클래스
		- 하나의 문자열을 여러개의 문자열을 분리하기 위해 사용
		- java.util 패키지 내의 클래스이기에 import 필요
		StringTokenizer st = new StringTokenizer(hobby,"/");
         */

        final int MAX_COLS = Integer.parseInt(st.nextToken());		// 변수 (String->Int) 행을 위한
        final int MAX_ROWS = Integer.parseInt(st.nextToken());		// 변수 (String->Int) 열을 위한
        char graph[][] = new char[MAX_COLS][MAX_ROWS];				// [행][열] 값을 넣어 행열 크기를 정해줌
        int ansCount = 0;												
       
        // BFS(넓이탐색법)
        for (int i = 0; i < MAX_COLS; i++) {						// 행부터 봐보자
            graph[i] = br.readLine().toCharArray();					// 0부터 버퍼리더로 행에 문자 값 순서대로 입력받기
            for (int j = 0; j < MAX_ROWS; j++) {					
                if (graph[i][j] == '-') {							// 만약 [i][j] 의 값이 '-' 일때 = 1*2 에 -가 있을 때
                    ansCount++;										// ansCount++ 값을 1 추가해라
                    while (j < MAX_ROWS && graph[i][j] == '-') {	// 1*2일때
                    												// 1<행 이고 1*2 = - 이면  -가 연속되면 cnt추가안하고 j추가
                        j++;										// j++해라
                    }												//
                }
            }
        }

        // DFS(깊이탐색법)
        for (int i = 0; i < MAX_ROWS; i++) {						// 이번엔 열을 보자
            for (int j = 0; j < MAX_COLS; j++) {					// 0부터 증가~
                if (graph[j][i] == '|') {							// j와 i의 위치를 바꿔 위에 예시들었던 것과 반대로 2*1에 |가 있다면
                    ansCount++;										// asnCount++ 값을 1 추가해라
                    while (j < MAX_COLS && graph[j][i] == '|') {	// 반복(2<열 이고 2*1 = |)이면 |가 연속되면 cnt추가 안하고 j추가
                        j++;										// j++해라
                    }
                }
            }

        }
        sb.append(ansCount);		// 기존 문자열에 추가한다.				// 카운트 된 값을 문자열로 보낸다
        sb.append("\n");			// 기존 문자열 건너뛰기				

        bw.write(sb.toString());

        bw.flush();				// 버퍼가 가득차면 전송해준다.
        br.close();				// 사용후엔 닫아줘야한다.
        bw.close();				// 

    }


}
