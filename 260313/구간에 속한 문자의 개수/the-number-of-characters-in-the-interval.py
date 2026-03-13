n, m, k = map(int, input().split())

# Read grid as list of strings since we need character-by-character access
grid = [input() for _ in range(n)]

# Read k queries as tuples
queries = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.
cgrid = [(0,0,0)*(m+1) for _ in range(n+1)]

for i in range(n):
    for j in range(m):
        t = grid[i][j]
        cgrid[i+1][j+1] = 