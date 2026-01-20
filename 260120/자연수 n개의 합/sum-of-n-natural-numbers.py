s = int(input())

# Please write your code here.
sum = 0
idx = 0
for i in range(1,s):
    sum += i
    if sum > s:
        idx = i-1
        break
print(idx)