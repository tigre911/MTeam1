def solution(lottos, win_nums):
    lottos = sorted(lottos, reverse=True)
    win_nums = sorted(win_nums, reverse=True)
    print(lottos, win_nums)
    count = 0
    zero_count = 0
    for i in lottos:
        if i == 0 :
            zero_count += 1
    print(zero_count)

    for i in range(len(lottos)):
        for j in lottos:
            if win_nums[i]==j:
                count +=1
    print(count)
    if zero_count==6:
        answer = [1,6]
    elif zero_count==0 and count==0:
        answer = [6,6]
    else:
        answer = [7-count-zero_count, 7-count]

    return answer

solution([44, 1, 0, 0, 31, 25],[31, 10, 45, 1, 6, 19])
