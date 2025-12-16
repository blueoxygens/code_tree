n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
dp = [0]*n

for i in range (n):
    if arr[i] > 0:
        for j in range(1,arr[i]+1):
            k = i + j
            if k < n:
                if i == 0:
                    dp[k] = max(dp[k], dp[i]+1)
                elif dp[i]>0:
                    dp[k] = max(dp[k], dp[i]+1)
print(max(dp))