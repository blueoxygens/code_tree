n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
count = 0
for i in range (n):
    for j in range(n-2):
        temp = 0
        for k in range(j,j+3):
            if grid[i][k] == 1:
                temp += 1
        count = max(count, temp)

print(count)
    