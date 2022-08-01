#게임을 만든 동준이

n = int(input())

level = []

for _ in range(n):
    level.append(int(input()))


count = 0

for i in reversed(range(1,n)):
    while level[i-1] >= level[i]:
        level[i-1] -= 1
        count += 1

print(count)