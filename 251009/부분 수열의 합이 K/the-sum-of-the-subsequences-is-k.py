n, k = map(int, input().split())
arr = [0] + list(map(int, input().split()))

# Please write your code here.
ps = [0] * (n+1)

for i in range(1, n+1):
    ps[i] = ps[i-1] + arr[i]

count = 0

for i in range(1,n+1):
    if ps[i] == k:
        count += 1

for i in range (1,n+1):
    for j in range(1,n+1-i):
        temp = ps[j+i] - ps[j]
        if temp == k:
            count += 1

print(count)     