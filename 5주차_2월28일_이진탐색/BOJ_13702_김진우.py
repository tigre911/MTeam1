import sys

input = sys.stdin.readline

n, k = map(int, input().split())
# 주전가 개수 n , 사람수 k
arr = [int(input()) for _ in range(n)]

left = 0
right = arr[n-1]

print(arr, left, right)
try:
    while n<=k and left <= right:
        temp = 0 #임시변수 tmp
        mid = (left + right) // 2
        print(f'mid : {mid}')
        for i in arr:
            temp+= i//mid
        print(f'temp : {temp}')
        if temp>=k:
            result = mid
            left = mid +1
        else:
            right = mid -1
except Exception as e:
    print(e)
print(result)