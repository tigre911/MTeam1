n, m = map(int, input().split())
# 6 9
li = []
for _ in range(n):
    li.append(list(input()))
# [[-||--||--]
# [--||--||-]
# [|--||--||]
# [||--||--|]
# [-||--||--]
# [--||--||-]]
cnt = 0
for i in range(n): # n = 6  , i = 0,1,2,3,4,5
    j = 0
    while j < m: # m = 9
        if li[i][j] == '|':
            j += 1
        else:
            cnt += 1
            while j < m and li[i][j] == '-':
                j += 1
for j in range(m):
    i = 0
    while i < n:
        if li[i][j] == '-':
            i += 1
        else:
            cnt += 1
            while i < n and li[i][j] == '|':
                i += 1
print(cnt)
'''
6 9
-||--||--
--||--||-
|--||--||
||--||--|
-||--||--
--||--||-
'''