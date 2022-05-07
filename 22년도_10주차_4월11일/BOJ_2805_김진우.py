N, M = map(int, input().split())
tree = list(map(int, input().split()))
start, end = 1, max(tree)  # 이분탐색 검색 범위 설정
# 1을 시작, end를 나무 중 긴 길이
# 원하는 나무 높이

while start <= end:  # 적절한 벌목 높이를 찾는 알고리즘
    mid = (start + end) // 2 # 1~20중 나무 높이의 절반 값

    log = 0  # 벌목된 나무 총합
    for i in tree:
        if i >= mid: # 나무 리스트의 인덱스보다 나무높이 보다 클 때
            log += i - mid # 나무 - 나무 높이 => 즉 벌목된 부분

    # 벌목 높이를 이분탐색
    if log >= M: #위에서 구한 벌목된 나무값이 얻어야할 나무량보다 크다면
        start = mid + 1 #다시 구할 나무높이의 시작부분인 start를 조정해준다.
        # 왜냐하면 1~20중에 구하는거였는데, 벌목된 값이 더 얻어야할 나무량보다 더 크니까
        # 나무의 높이가 올라가면 벌목될 log값이 줄어들기 떄문이다.
    else:
        end = mid - 1
        # log가 M보다 작으면 즉 벌목된 나무값이 구해야할 나무값보다 작다면
        # end 즉 구해야할 끝 부분을 중간 부분에서 1만큼 빼서 재설정 해준다.
        # 그래야 mid=나무높이의 값이 줄어들면서 벌목될 log 값이 커지기 때문이다
print(end) # 나무의 최대높이인 end값을 출력해 준다.
