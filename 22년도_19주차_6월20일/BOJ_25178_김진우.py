import sys
input = sys.stdin.readline

n = int(input())

arr = ['a', 'e' , 'i' ,'o' ,'u']

input_arr = []
for _ in range(2):
    input_arr.append(input())

print(input_arr)

ex1 = []
ex2 = []

for i in range(n):
    ex1.append(input_arr[0][i])
#
# for i in range(n):
    ex2.append(input_arr[1][i])

print(ex1, ex2)

for i in range(5):
    # print(arr[i])
    for j in range(n):
        # print(ex1[j])
        if arr[i]==ex1[j]:
            # print(ex1[j], '랑' ,arr[i])
            ex1.remove(ex1[j])
            ex1.append(0)
print(ex1)

for i in range(5):
    # print(arr[i])
    for j in range(n):
        # print(ex2[j])
        if arr[i]==ex2[j]:
            # print(ex2[j], '랑' ,arr[i])
            ex2.remove(ex2[j])
            ex2.append(0)
print(ex2)

if ex1 == ex2:
    print('YES')
else:
    print('NO')