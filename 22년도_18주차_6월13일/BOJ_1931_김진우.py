n = int(input()) #회의의 수
meeting = []

for i in range(n):
    a,b = map(int,input().split())
    meeting.append([a,b])

print(meeting)
# meeting.sort(key= lambda x: (x[0], x[1]))
# print(meeting)
meeting.sort(key= lambda x: (x[1], x[0]))
print(meeting)

start = meeting[0][0] #1
end = meeting[0][1] #4

cnt = 1

for i in range(1,n):
    start = meeting[i][0]
    if start>=end:

        end = meeting[i][1]
        cnt+=1

print(cnt)