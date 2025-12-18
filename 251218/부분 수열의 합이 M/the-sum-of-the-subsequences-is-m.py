import math
n, m = map(int, input().split())
A = list(map(int, input().split()))

INF = math.inf
dp = [INF] * (m + 1)
dp[0] = 0

for num in A:
    for x in range(m, num - 1, -1):
        if dp[x - num] != INF:
            dp[x] = min(dp[x], dp[x - num] + 1)

print(-1 if dp[m] == INF else dp[m])