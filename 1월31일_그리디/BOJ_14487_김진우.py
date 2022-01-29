import sys

input = sys.stdin.readline

n = int(input())    #마을의 수

v = list(map(int,input().split()))  #마을간 거리

v.sort(reverse=True)    #내림차순 정렬

sum = 0 #최종 값 변수 설정

for i in v:
    sum += i

print(sum - v[0])
#제일 거리가 큰 마을부터 출발하면 최소 거리가 나오므로 전체를 더한 값에서 제일 거리가 큰 마을을 빼준다.
