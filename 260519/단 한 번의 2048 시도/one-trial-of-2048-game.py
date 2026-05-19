# Read 4x4 grid
grid = [list(map(int, input().split())) for _ in range(4)]

# Read direction
d = input()

# Please write your code here.
dirs = {
    'L' : 3,
    'R' : 1,
    'U' : 2,
    'D' : 0
}

result = [[0]*4 for _ in range(4)]

#돌리는 함수 방향 : 시계 방향
def rotate():
    ngrid = [[0]*4 for _ in range(4)]

    for i in range(4):
        for j in range(4):
            ngrid[j][3-i] = grid[i][j]
    return ngrid

# 중력 함수
def gravity(grid):
    for j in range(4):
        for i in range(2,-1, -1):
            if grid[i][j] != 0:
                r = i+1
                while r < 4 and grid[r][j] == 0:
                    r+=1
                if r - 1 != i:
                    grid[r - 1][j] = grid[i][j]
                    grid[i][j] = 0
    return grid

#합치는 함수
def merge(grid):
    ngrid = [[0]*4 for _ in range(4)]
    visited = set()
    for j in range(4):
        for i in range(3,0,-1):
            if grid[i][j] == -1:
                continue
            if grid[i][j] == grid[i-1][j] and (i,j) not in visited:
                ngrid[i][j] = 2*grid[i][j]
                visited.add((i-1,j))
            elif (i,j) not in visited:
                ngrid[i][j] = grid[i][j]
        if (0,j) not in visited:
            ngrid[0][j] = grid[0][j]
    
    ngrid = gravity(ngrid)
    return ngrid

for i in range(dirs[d]):
    grid = rotate()
grid = gravity(grid)
grid = merge(grid)


if d != 'D':
    for i in range(4-dirs[d]):
        grid = rotate()  

for l in grid:
    print(*l)