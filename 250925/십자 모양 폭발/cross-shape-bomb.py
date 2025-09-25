n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())

# Please write your code here.
def gravity ():
    # r = len(grid)
    # c = len(grid[0])

    for i in range(n-1):
        for j in range(n):
            p = i

            while 0 <= p and grid[p][j] != 0 and grid[p+1][j] == 0:
                grid[p][j], grid[p+1][j] = grid[p+1][j], grid[p][j]
                p -= 1

def explode (y, x):
    direction = [(-1,0),(1,0),(0,-1),(0,1)]
    v = grid[y][x]
    grid[y][x] = 0
    for dy, dx in direction:
        for i in range(1, v):
            ny = y + dy*i
            nx = x + dx*i
            if 0 <= ny < n and 0<= nx < n:
                grid[ny][nx] = 0
    gravity()

explode(r-1, c-1)
for i in range(n):
    for j in range(n):
        print(grid[i][j], end=' ')
    print()