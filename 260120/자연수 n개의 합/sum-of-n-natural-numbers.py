s = int(input())

# Please write your code here.
sum = [0]*(s+1)
idx = 0
for i in range(1,s):
    sum[i] = sum[i-1] + i
    if sum[i] > s:
        idx = i-1
        break
print(idx)