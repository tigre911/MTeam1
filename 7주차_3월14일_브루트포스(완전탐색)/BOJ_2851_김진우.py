import sys
input = sys.stdin.readline

count = 0
list = []

for _ in range(10):
    list.append(int(input()))


find_min = []   # list들을 더한 값들에서 100을 뺀 변수를 저장할 리스트 생성
for i in range(10):
    count += list[i]
    print(count)
    find_min.append(abs(100-count)) #abs는 절댓값을 구하는 함수

print(find_min) #100을 뺀것들을 모은 리스트
print(min(find_min)) # 그중 최소값

min_index = find_min.index(min(find_min)) #최소값의 인덱스
print(f'min_index : {min_index}')
# print(f'min_index+1 : {find_min[min_index + 1]}')
#만약 100에 가까운 수가 2개라면 (예: 98, 102) 마리오는 큰 값을 선택한다.
if min_index<9:
    if find_min[min_index] == find_min[min_index+1]:
            min_index = min_index + 1


print(f'min_index : {min_index}')
ans = 0
for i in range(min_index+1):
    ans += list[i]

print(ans)