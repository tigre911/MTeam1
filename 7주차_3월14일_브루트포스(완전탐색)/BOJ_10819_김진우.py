#|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
from itertools import permutations

n = int(input())
array = list(map(int,input().split()))

arr_per = permutations(array)   #모든경우의수(수열)을 만들어준다

cnt = []
for arr in arr_per:
    sum = 0
    for i in range(n-1):
        sum += abs(arr[i]-arr[i+1])     #수열들에서 주어진식을 쓴 변수를 cnt배열에 넣어준다
        cnt.append(sum)

# print(cnt)
print(max(cnt)) #주어신식을 배열에 넣은것중 제일 큰 값을 출력한다.