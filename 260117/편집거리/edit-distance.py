A = input()
B = input()

# Please write your code here.
def solution(A, B):
    m, n = len(A), len(B)
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0: 
                dp[i][j] = j
            elif j == 0:
                dp[i][j] = i
            elif A[i-1] == B[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else: 
                dp[i][j] = 1 + min(dp[i-1][j],    
                                   dp[i][j-1],    
                                   dp[i-1][j-1])
    return dp[m][n]
print(solution(A,B))