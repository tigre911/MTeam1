package study010;

class PGMS_키패드누르기_김다빈 {
	   public String solution(int[] numbers, String hand) {
	        String answer = "";	// 값을  계속 저장할 변수
	        
	        // *=10, 0=11, #=12 라 가정
	        int left = 10;
	        int right = 12;
	        
	        // 누르는 횟수만큼 반복
	        for(int i = 0;i<numbers.length;i++){
	            // 1,4,7은 왼손
	            if(numbers[i] == 1 || numbers[i] == 4||numbers[i] == 7){                
	                answer+="L";
	                // left에 number[i] 저장
	                left = numbers[i];
	                continue;
	            // 3,6,9는 오른손
	            }else if(numbers[i] == 3 || numbers[i] == 6||numbers[i] == 9){
	                answer+="R";
	                // right에 number[i]저장
	                right = numbers[i];
	                continue;  
	            // 중앙의 번호들은 거리에 따라 누르게 된다.
	            }else{
	                // 중앙이 0일때 번호는 11 아니면 해당 번호를 대입한다.
	                int x = numbers[i] == 0 ? 11 : numbers[i];
	                /*	맨해튼 거리 측정법 : 왼손과 오른손으로부터 중앙의 번호와의 거리*/
	                
	                
	                // ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
	                
	                int l_length = Math.abs((x-1)/3 - (left-1)/3) + Math.abs((x-1)%3 - (left-1)%3);
	                int r_length = Math.abs((x-1)/3 - (right-1)/3) + Math.abs((x-1)%3 - (right-1)%3);
	                // 구한 거리가 같은 경우 hand에 따라 저장
	                if(l_length == r_length) {                    
	                    if(hand.equals("right")){
	                        answer+="R";
	                        right = x;
	                    }else{
	                        answer+="L";
	                        left=x;
	                    }                
	                }               
	                // 왼손으로부터의 거리가 짧은 경우는 왼손을, 오른손으로부터의 거리가 짧은 경우는 오른손을 저장
	                else {
	                	// 왼손이 가까운 경우
	                    if(l_length<r_length){
	                        answer+="L";
	                        left=x;
	                    }else{ // 오른손이 가까운 경우
	                        answer+="R";
	                        right=x; 
	                    }
	                }
	            }                
	        }
	       
	        return answer;
	    }
	}
