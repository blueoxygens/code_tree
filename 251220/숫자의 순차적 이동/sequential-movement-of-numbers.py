n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
d = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]

h1 = {}
h2 = {}

for i in range(n):
    for j in range(n):
        h1[grid[i][j]] = (i,j)
        h2[(i,j)] = grid[i][j]

for i in range(1,m+1):
    for target in range(1,n**2+1):
        x, y = h1[target]
        mnum = 0

        for dx, dy in d:
            nx = x + dx
            ny = y + dy
            
            if 0<=nx<n and 0<=ny<n:
                mnum = max(mnum, h2[(nx,ny)])

        h1[target], h1[mnum] = h1[mnum], h1[target]
        h2[(x,y)], h2[h1[target]] = h2[h1[target]], h2[(x,y)]

for i in range(n):
    for j in range(n):
        grid[i][j] = h2[(i,j)]

for l in grid:
    print(*l)