# coin = [7,5,2,1]
# n = int(input())
#
# cnt = 0
#
# for i in coin:
#     cnt += n//i
#     n %= i
#
# print(cnt)

n = int(input())
dp = [100001]*(n+1) #지불해야 하는 금액의 MAX
dp[0] = 0 #0원은 동전 0개로 가능
coin = [7, 5, 2, 1] #동전 종류

for m in range(1, n+1): #1원부터 지불해야 하는 n원까지
    for c in coin:
        #동전 액면가보다 지불해야 하는 금액이 클 경우 and
        #동전 c를 주는 것이(dp[m-c]+1) 기존 경우(dp[m])보다 개수를 줄일 수 있는 경우
        if c <= m and dp[m-c]+1 < dp[m]:
            dp[m] = dp[m-c]+1
print(dp[-1])