
n= int(input())

s_list=[] #시리얼 번호를 받아줄 리스트
for i in range(n):
    serial = input() #시리얼을 입력받는다

    sum = 0 #자리수의 합을 받을 변수

    for j in serial:
        if  (j>='0') and (j<='9'): #숫자인것만 더한다
            sum += int(j)

    s_list.append((serial, len(serial), sum)) #인덱스 0 부터 2까지 차례로 0:시리얼번호 1:길이 2:숫자합

print(s_list)

s_list.sort(key=lambda s:(s[1],s[2],s[0])) # 길이 -> 숫자합 -> 시리얼번호(사전순)으로 정렬

print(s_list)