N, M = map(int, input().split())
coin = list(map(int, input().split()))

INF = 10**15
dp = [INF] * (M + 1)
dp[0] = 0

for c in coin:
    for x in range(c, M + 1):
        dp[x] = min(dp[x], dp[x - c] + 1)

print(-1 if dp[M]==INF else dp[M])