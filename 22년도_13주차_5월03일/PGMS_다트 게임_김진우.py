def solution(dartResult):
    dart = list(dartResult)  # 배열로 변환

    score = []

    for i in range(len(dart)):
        if dart[i] == '1' and dart[i + 1] == '0':  # 10점일때 체크 1D2S#10S
            score.append('10')
        elif dart[i] == '0' and dart[i - 1] == '1':
            continue
        else:
            score.append(dart[i])


    answer = []

    for j in score:
        if j.isdigit():
            # str.isdigit() 문자열이 '숫자'로만 이루어져있는지 확인하는 함수
            # 숫자면 num
            num = int(j)
        elif j.isalpha():
            # str.isalpha() 문자열의 구성이 알파벳인지에 대해서 확인하는 함수
            # 숫자가 아니면 계산
            if j == 'S':
                num = num ** 1
                answer.append(num)
            elif j == 'D':
                num = num ** 2
                answer.append(num)
            elif j == 'T':
                num = num ** 3
                answer.append(num)
        # 스타상(*) , 아차상(#) 처리하기
        if j == '*':
            if len(answer) >= 2:  # (*) 두번 나오면 전의 값도 두배가 되어야함
                answer[-1] = answer[-1] * 2
                answer[-2] = answer[-2] * 2
            else:
                answer[-1] = answer[-1] * 2

        if j == '#':
            answer[-1] = answer[-1] * (-1)  # ('#')이 나오자마자 바로 연산하니까 리스트의 마지막 요소를 -로 변경

    return sum(answer)

# Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱
# 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
# 아차상(#) 당첨 시 해당 점수는 마이너스
# 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다.
# 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다.
# 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다.

dartResult = "1D2S#10S"

dart = list(dartResult)     #배열로 변환

score = []

print(dart)
print(dart[-2])
for i in range(len(dart)):
    if dart[i] == '1' and dart[i+1] == '0':     #10점일때 체크 1D2S#10S
        score.append('10')
    elif dart[i] == '0' and dart[i-1] == '1':
        continue
    else:
        score.append(dart[i])

print(f'score : {score}')

answer = []

for j in score:
    if j.isdigit():
        # str.isdigit() 문자열이 '숫자'로만 이루어져있는지 확인하는 함수
        # 숫자면 num
        num  = int(j)
    elif j.isalpha():
        # str.isalpha() 문자열의 구성이 알파벳인지에 대해서 확인하는 함수
        # 숫자가 아니면 계산
        if j == 'S':
            num = num**1
            answer.append(num)
        elif j == 'D':
            num = num**2
            answer.append(num)
        elif j == 'T':
            num = num**3
            answer.append(num)
    print(f'num:{num}')
    print(f'answer : {answer}')

    # 스타상(*) , 아차상(#) 처리하기
    if j == '*':
        if len(answer) >=2 : # (*) 두번 나오면 전의 값도 두배가 되어야함
            answer[-1] = answer[-1] * 2
            answer[-2] = answer[-2] * 2
        else:
            answer[-1] = answer[-1]*2

    if j == '#':
        answer[-1] = answer[-1]*(-1) # ('#')이 나오자마자 바로 연산하니까 리스트의 마지막 요소를 -로 변경

print(answer)
print(sum(answer))