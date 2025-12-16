n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
dp = [0]*n

dp[0] = 1

for i in range (n):
    if arr[i] > 0:
        for j in range(1,arr[i]):
            k = i + j
            if k < n and arr[k] > 0:
                dp[k] = max(dp[k], dp[i]+1)
print(max(dp))