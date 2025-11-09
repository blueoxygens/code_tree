n, m, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.

if n > 1:
    for i in range (n-1):
        for j in range (k-1, k+m-1): # -> 여기가 이상함
        # print(f'case: {i+1} {j}')
            if grid[i+1][j] == 1:
                for j in range(k-1, k+m-1):
                    grid[i][j] = 1
                break
        else:
            continue
        break
else:
    for j in range (k-1, k+m-1):
        grid[0][j] = 1
for i in grid:
    print(*i)