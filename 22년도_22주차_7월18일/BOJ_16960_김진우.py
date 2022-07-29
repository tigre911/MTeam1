from itertools import combinations
n,m = map(int,input().split())
lamp=[[]]
items=[]
for i in range(n):
    items.append(i+1)
for i in range(n):
    temp = list(map(int,input().split()))
    lamp.append(temp[1:])
select = list(combinations(items,n-1))
# print(lamp)
# print(select)
ans=0
answer=0
for i in range(len(select)):
    check=[]
    cnt=0
    for j in range(len(select[i])):
        for k in range(len(lamp[select[i][j]])):
            check.append(lamp[select[i][j]][k])
    check=set(check)
    for j in range(1,m+1):
        if j in check:
            cnt+=1
    # print(check)
    # print(cnt)
    if cnt==m:
        ans=1
        break
    else:
        continue
print(ans)