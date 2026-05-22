n = int(input())
arr = list(map(int, input().split()))

total = sum(arr)

dp = [False] * (total + 1)
dp[0] = True

for v in arr:
    for j in range(total, v - 1, -1):
        dp[j] |= dp[j - v]

ans = total

for s in range(total + 1):
    if dp[s]:
        ans = min(ans, abs(total - 2 * s))

print(ans)