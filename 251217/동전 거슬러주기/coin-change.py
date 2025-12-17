N, M = map(int, input().split())
coin = list(map(int, input().split()))

# Please write your code here.
dp = [0]*(M+1)

for c in coin:
    dp[c] = 1
    # if 2*c <= M:
    #     if dp[2*c] != 0:
    #         dp[2*c] = min(dp[2*c], 2)
    #     else:
    #         dp[2*c] = 2

for i in range(1,M):
    for j in range(i+1,M+1):
        if j % i == 0:
            if dp[j] != 0:
                dp[j] = min(j/i*dp[i], dp[j])
            else:
                dp[j] = j/i*dp[i]
        else:
            if dp[j] != 0:
                dp[j] = min(dp[i]+dp[j-i], dp[j])
            else:
                dp[j] = dp[i]+dp[j-i]

print(int(dp[M]))