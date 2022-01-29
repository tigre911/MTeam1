import sys
input = sys.stdin.readline

n = int(input())
sugar_list = [5,3]

count = 0

for i in sugar_list:
    count += n//i   #1. 5로 나눈 몫을 더하고            2. 3으로 나눈 몫을 더함
    n %= i          #1. 5로 나눈 나머지를 n에 다시 대입
    if n > 0 :      #나머지가 0보다 크면 정확하게 N킬로그램을 만들 수 없는 것
        count = -1

print(count)