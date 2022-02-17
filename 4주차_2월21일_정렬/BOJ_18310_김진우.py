n = int(input())
list = list(map(int, input().split()))
# print(list)
list.sort()

print(list[(n-1)//2])