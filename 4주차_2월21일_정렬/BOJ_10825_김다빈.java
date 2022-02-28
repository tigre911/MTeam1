package study006;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class BOJ_10825_김다빈 {
	/*
	 * IO (Input, Output)은 항상 오류(IO Exception)이 뜨기 때문에 try-catch 구문으로 묶어서 사용하는 것이 일반적이다.
	 
	 * 모든 스트림은 쓰고 나면 닫아야한다.
		Stream : 파일 등을 읽어들이고 쓰기 위한 일종의 통로
		InputStream : 입력 장치(키보드 등)을 통해 사용자에게 입력받은 내용을 읽어온다.
		OutputStream : 사용자에게 입력받은 내용을 출력장치(모니터 등)에 출력한다. System.out.print의 기능
		FileInputStream : 파일의 내용을 읽어온다.
	 	FileOutputStream : 파일의 내용을 새로 쓴다.
		BufferedInputStream : 읽어올 내용을 한번에 모아서 읽어드리는 보조스트림으로 경로 직접접근은 불가능하다.
		BufferedOutputStream : 쓸 내용을 한 번에 모아서 파일에 쓰는 보조스트림으로 경로 직접접근은 불가능하다.
		 
	 * Reader와 Writer
		Reader : 문자 단위로 읽어드리는 스트림으로 글자만 읽는다.
		Writer : 문자 단위로 쓰는 스트림
		BufferedReader : 읽어올 내용을 한 번에 모아서 읽어드리는 보조 스트림
		BufferedWriter : 쓸 내용을 한 번에 모아서 파일에 쓰는 보조스트림
		
	 */
	
	
    public static void main(String args[]) throws Exception {
    	//	BufferedReader 사용 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //	br(BufferedReader)에 문자열을 입력받아 정수형으로 반환
        int N = Integer.parseInt(br.readLine());
        //	문자 2차원배열 arr은 [입력받은 값][4]; -> N만큼의 줄이 반복되어야 하므로, 4 = 이름, 국, 영, 수점수
        String[][] arr = new String[N][4];
        //	i는 N만큼 반복한다.
        for (int i = 0; i < N; i++) {
            //	배열[0] = 값을 입력받는다. split사용해서 " "을 기준으로 구분하게 한다.
        	arr[i] = br.readLine().split(" ");
        }
        
        //	Comparator과 Comparable 사용
        //	Comparable : 클래스의 기본 정렬 기준을 설정하는 인터페이스
        //	Comparator : 기본 정렬 기준과는 다르게 정렬할 때 사용하는 인터페이스
        Arrays.sort(arr, new Comparator<String[]>() {
        	//	오버라이드 : 메서드의 재정의로 부모클래스가 가지고 있던 메서드를 상속받아 자식에 맞게 변경해서 사용
            @Override
            public int compare(String[] s1, String[] s2) {
                if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
                    if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
                        if (Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {
                            
                            //국영수 점수가 같다면 사전 오름차순
                            return s1[0].compareTo(s2[0]);
                        }
        
                        //국어점수 같고 영어점수 같을 때, 수학 점수는 내림차순
                        return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));
 
                    }
                    //국어 점수 같을 때, 영어 점수는 오름차순
                    return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
                }
                //국어점수는 내림차순
                return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
            }
 
        });
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0]);
 
        }
    }
}