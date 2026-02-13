n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
ans = float('inf')
for i in range(n):
    test = arr[:]
    test[i] = 2*test[i]
    for k in range(n):
        dp = [0] * n
        for j in range(n-1):
            if k == j:
                dp[j] = 0
            else :
                dp[j] = abs(test[j] - test[j+1])
        ans = min(ans, sum(dp))
    
print(ans)