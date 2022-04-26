def solution(absolutes, signs):
    absolutes = [4, 7, 12]
    signs = [True, False, True]

    for index in range(len(absolutes)):
        if signs[index] == False:
            absolutes[index] = absolutes[index] * (-1)

    answer = 0

    for i in absolutes:
        answer += i

    return answer


absolutes = [4,7,12]
signs = [True,False,True]

for index in range(len(absolutes)):
    if signs[index] == False:
        absolutes[index] = absolutes[index] * (-1)

answer = 0

for i in absolutes:
    answer += i

print(answer)

