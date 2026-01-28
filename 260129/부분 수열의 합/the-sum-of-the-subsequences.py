n, m = map(int, input().split())
A = list(map(int, input().split()))

# Please write your code here.

dp = [False] * (m+1)

dp[0] = True

for num in A:
    for i in range(m,num-1,-1):
        if dp[i-num] : 
            dp[i] = True

if dp[m]:
    print('Yes')
else:
    print('No')