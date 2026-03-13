n, m, k = map(int, input().split())

# Read grid as list of strings since we need character-by-character access
grid = [input() for _ in range(n)]

# Read k queries as tuples
queries = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.
agrid = [[0]*(m+1) for _ in range(n+1)]
bgrid = [[0]*(m+1) for _ in range(n+1)]
cgrid = [[0]*(m+1) for _ in range(n+1)]

for i in range(n):
    for j in range(m):
        t = grid[i][j]
        if t == 'a':
            agrid[i+1][j+1] = agrid[i][j+1] + agrid[i+1][j] - agrid[i][j] + 1
            bgrid[i+1][j+1] = bgrid[i][j+1] + bgrid[i+1][j] - bgrid[i][j]
            cgrid[i+1][j+1] = cgrid[i][j+1] + cgrid[i+1][j] - cgrid[i][j]
        elif t == 'b':
            agrid[i+1][j+1] = agrid[i][j+1] + agrid[i+1][j] - agrid[i][j]
            bgrid[i+1][j+1] = bgrid[i][j+1] + bgrid[i+1][j] - bgrid[i][j] + 1
            cgrid[i+1][j+1] = cgrid[i][j+1] + cgrid[i+1][j] - cgrid[i][j]
        else:
            agrid[i+1][j+1] = agrid[i][j+1] + agrid[i+1][j] - agrid[i][j]
            bgrid[i+1][j+1] = bgrid[i][j+1] + bgrid[i+1][j] - bgrid[i][j]
            cgrid[i+1][j+1] = cgrid[i][j+1] + cgrid[i+1][j] - cgrid[i][j] + 1

for a, b, c, d in queries:
    print(f'{agrid[c][d] - agrid[a-1][d] - agrid[c][b-1] + agrid[a-1][b-1]} {bgrid[c][d] - bgrid[a-1][d] - bgrid[c][b-1] + bgrid[a-1][b-1]} {cgrid[c][d] - cgrid[a-1][d] - cgrid[c][b-1] + cgrid[a-1][b-1]}')