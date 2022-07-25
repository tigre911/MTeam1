n, a, d = map(int,input().split())
list = list(map(int, input().split()))

print(list)

cnt = 0

for i in range(n):
    if list[i] == a:
        cnt+=1
        a = a+d

print(cnt)
