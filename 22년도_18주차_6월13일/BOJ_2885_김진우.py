import sys
input= sys.stdin.readline

k = int(input())
# 6

buy = k//2 #구매해야하는 초콜릿
buy_extra = k%(2**(buy-1)) #초콜릿이 2의 배수일경우를 구하기위한 나머지
print("buy : " ,buy, "buy_extra : ", buy_extra)

if buy_extra==0:
    buy = buy-1

choco = 2**buy
print("choco : " ,choco)
cnt = 0

if k//choco==0:
    cnt=0

    for i in range(1,buy + 1):
        print(f'k : {k}')
        print(f'choco//2*i : {choco//(2*i)}')
        k = k - choco//(2*i)
        if k <0:
            break
        print(k, choco//(2*i))
        cnt += 1

    # if k == 0 :
    #     break



# print(choco, cnt)
print(choco, end=' ')
print(cnt)