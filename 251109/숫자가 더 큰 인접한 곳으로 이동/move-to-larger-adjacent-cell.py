n, r, c = map(int, input().split())
a = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    row = list(map(int, input().split()))
    for j in range(1, n + 1):
        a[i][j] = row[j - 1]

# Please write your code here.
d = [(-1,0),(1,0),(0,-1),(0,1)] #상하좌우

move = 1
record = [a[r][c]]
while move:
    for dr, dc in d:
        nr = r + dr
        nc = c + dc
        if 0<= nr < n and 0 <= nc < n and a[nr][nc] > a[r][c]:
            record.append(a[nr][nc])
            r = nr
            c = nc
            break
    else:
        move = 0

print(*record)