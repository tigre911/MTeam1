import sys
input = sys.stdin.readline

#설탕 N 킬로그램
n = int(input())

count = 0

if n % 5 == 0:  # 5으로 나눠떨어질 때
    print(n // 5)
else:           # 5으로 나눠떨어지지 않을 때
    while n > 0:
        n -= 3          # 3kg 한봉을 담아서 전체 무게에서 3키로를 빼주고 5키로로 다되는지 확인하는 과정을 거침
        count += 1
        if n % 5 == 0:  # 3kg과 5kg를 조합해서 담을 수 있을 때
            count += n // 5
            print(count)
            break
        elif n == 1 or n == 2:  # 설탕 봉지만으로 나눌 수 없을 때 3이하 1,2일때 나눠지지 않음
            print(-1)
            break
        elif n == 0:  # 3으로 나눠떨어질 때
            print(count)
            break
