n = int(input())
m = []
groups = []

for _ in range(n):
    nums = list(map(int, input().split()))
    m.append(nums[0])
    groups.append(nums[1:])

# Please write your code here.

bits = [0] *(n+1)

for i in range(n):
    num = m[i]
    for j in range(num):
        p = groups[i][j]
        bits[i] |= (1 << p)

ans = 0

for i in range(n-1):
    for j in range(i+1,n):
        if bits[i] & bits[j] == 0:
            ans += 1

print(ans)