from itertools import permutations

n = int(input())
list = []
for i in range(1,n+1):
    list.append(i)

print(list)

per = permutations(list,n)
for nums in (per):
    for i in nums:
        print(i, end=' ')   #순열들 안의 요소들을 공백을 넣어 한줄에 출력
    print()     #줄바꿈