import sys
input = sys.stdin.readline

n = int(input())
card_list = list(map(int, input().split()))

m = int(input())
card_list2 = list(map(int, input().split()))

# print(card_list)
# print(card_list2)
result = []

def binary(k, card_list, start, end):
    mid = (start+end)//2
    if start>end:
        result.append(0)
    elif k == card_list[mid]:
        result.append(1)
    elif k > card_list[mid]:
        binary(k, card_list, mid+1, end)
    elif k < card_list[mid]:
        binary(k, card_list, start, mid-1)

for k in card_list2:    #  k : 10 9 -5 2 3 4 5 -10
    start = 0
    end = len(card_list)-1 # len(card_list) = 5 >>> end = 4
    binary(k, card_list, start, end)

print(result)

for i in result:
    print(i, end=" ")