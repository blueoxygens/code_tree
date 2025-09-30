import math
n = int(input())
A = list(map(int, input().split()))

# Please write your code here.

ans = math.inf

for i in range(n):
    t = 0
    for j in range(n):
        t += abs((i-j))*A[j]
    ans = min(ans, t)

print(ans)