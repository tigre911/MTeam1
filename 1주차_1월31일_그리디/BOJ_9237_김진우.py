
n = int(input()) #첫번째 줄 입력 값 n
trees = list(map(int,input().split())) #나무의 자라는 날 리스트형으로 입력 받기

# print(trees)
trees.sort(reverse=True) # reverse 는 False 가 기본값(오름차순이 기본값)
# print(trees)

day = [] #각 요일에 나무가 완성된 날들

for i in range(1 , len(trees)+1): #len()은 자바에서 array.length 와 같은 뜻으로 배열의 길이를 뜻함
    day.append(i + trees[i-1]) # 요일 + 나무의 자라는 날

# print(day)
day.sort(reverse=True)
print(day[0] + 1)


