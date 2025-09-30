from collections import deque
R, C = map(int, input().split())
grid = [list(input().split()) for _ in range(R)]

# Please write your code here.
start = grid[0][0]
count = 0
fq = deque()
if grid[R-1][C-1] != start:
    for i in range (1,R-1):
        for j in range(1,C-1):
            if grid[i][j] != start:
                fq.append((i,j))
    while fq:
        y, x = fq.popleft()
    
        for i in range(y+1,R-1):
            for j in range(x+1,C-1):
                if grid[i][j] == start:
                    count += 1
print(count)