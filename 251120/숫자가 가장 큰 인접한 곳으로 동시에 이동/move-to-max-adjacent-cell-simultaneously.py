n, m, t = map(int, input().split())

# Create n x n grid
a = [list(map(int, input().split())) for _ in range(n)]

# Get m marble positions
marbles = [tuple(map(int, input().split())) for _ in range(m)]
r = [pos[0] for pos in marbles]
c = [pos[1] for pos in marbles]

# Please write your code here.
dirs = [(-1,0),(1,0),(0,-1),(0,1)] #상하좌우
for time in range(t):
    for i in range(m):
        mm = 0
        d = [0,0]
        for dr, dc in dirs:
            nr, nc= r[i] + dr, c[i] + dc
            if 0<= nr-1 < n and 0<= nc-1 < n:
                if a[nr-1][nc-1] > mm:
                    mm = a[nr-1][nc-1]
                    d[0], d[1] = nr, nc
        r[i], c[i] = d[0], d[1]
dup = 0
visited = set()
duplist = set()
for i in range(m):
    if (r[i],c[i]) in visited:
        dup += 1
        duplist.add((r[i],c[i]))
    else:
        visited.add((r[i],c[i]))

print(m-dup-len(duplist))