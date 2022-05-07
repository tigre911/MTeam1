
#1
import sys

input = sys.stdin.readline

def dp(k):
    # DP 테이블 초기화
    d_a = [0] * 46
    d_b = [0] * 46

    d_a[1], d_b[1] = 0, 1
    d_a[2], d_b[2] = 1, 1

    # DP bottom-up
    for i in range(3, k+1):
        d_a[i] = d_a[i-1] + d_a[i-2]
        d_b[i] = d_b[i-1] + d_b[i-2]

    return d_a[k], d_b[k]

if __name__ == '__main__':
    k = int(input())

    print(*dp(k))

#2
k = int(input())
a = [0] * 46
b = [0] * 46
a[0] = 1
for i in range(1, k + 1):
    a[i] = b[i - 1]
    b[i] = a[i - 1] + b[i - 1]

print(a[k], b[k])
