from collections import Counter

A = input()
B = input()

# Please write your code here.
A = list(A)
B = list(B)
dp = [[0]*(len(A)+1) for _ in range((len(B))+1)]

for i in range(len(B)):
    for j in range(len(A)):
        if A[j] == B[i]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j],dp[i][j-1])

print(dp[len(B)-1][len(A)-1])