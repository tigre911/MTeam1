import sys

input = sys.stdin.readline

# N명의 원생, K개의 조
n,k = map(int, input().split())

#원생들의 키
child = list(map(int, input().split()))

#조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼 든다
count = [] #키차이를 담아 줄 배열을 생성

#옆에 있는 학생과의 키차이를 배열에 넣는다.
for i in range(n-1):
    count.append(child[i+1] - child[i])

count.sort() # 정렬
print(count)

sum = 0
for j in range(n-k):    #학생수와 조의 수를 빼면 더해야할 키차이의 수가 나온다
    sum += count[j]

print(sum)