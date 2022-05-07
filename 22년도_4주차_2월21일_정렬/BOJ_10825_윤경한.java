package baek.feb_21_sort;

import java.util.*;
import java.io.*;

public class BOJ_10825 {
    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        Student[] students = new Student[N];
        String name;
        int korean, english, math;

        for(int i=0; i<N; i++){
            String[] info = reader.readLine().split(" ");
            name = info[0];
            korean = Integer.parseInt(info[1]);
            english = Integer.parseInt(info[2]);
            math = Integer.parseInt(info[3]);

            students[i] = new Student(name, korean, english, math);
        }

        Comparator<Student> comp = (x,y)->{
            int result = 0;
            int compKor = Integer.compare(x.korean, y.korean);
            if(compKor!=0){
                result = -compKor;
            }else{
                int compEng = Integer.compare(x.english, y.english);
                if(compEng!=0){
                    result = compEng;
                }else{
                    int compMath = Integer.compare(x.math, y.math);
                    if(compMath!=0){
                        result = -compMath;
                    }else{
                        result = x.name.compareTo(y.name);
                    }
                }
            }
            return result;
        };

        Arrays.sort(students,comp);

        for(Student s:students){
            writer.write(s.name+"\n");
        }
        writer.flush();
    }
}
