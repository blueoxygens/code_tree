import math

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# dp[r][c]: (0,0)에서 (r,c)까지 올 때 거친 경로 중 최솟값의 최대치
dp = [[0] * n for _ in range(n)]

# 시작점 초기화
dp[0][0] = grid[0][0]

# 첫 번째 행 채우기 (오른쪽으로만 이동)
for c in range(1, n):
    dp[0][c] = min(dp[0][c-1], grid[0][c])

# 첫 번째 열 채우기 (아래로만 이동)
for r in range(1, n):
    dp[r][0] = min(dp[r-1][0], grid[r][0])

# 나머지 격자 채우기
for r in range(1, n):
    for c in range(1, n):
        # 위에서 오는 경우와 왼쪽에서 오는 경우 중 더 큰 최솟값을 선택
        from_top = min(dp[r-1][c], grid[r][c])
        from_left = min(dp[r][c-1], grid[r][c])
        dp[r][c] = max(from_top, from_left)

print(dp[n-1][n-1])