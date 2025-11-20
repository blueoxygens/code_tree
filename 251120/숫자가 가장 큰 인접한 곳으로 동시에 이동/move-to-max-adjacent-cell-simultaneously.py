from collections import defaultdict
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
    dd = defaultdict(list)
    m = len(r)
    for i in range(m):
        mm = 0
        d = [0,0]
        for dr, dc in dirs:
            nr = r[i] + dr
            nc = c[i] + dc
            if 0<= nr-1 < n and 0<= nc-1 < n:
                if a[nr-1][nc-1] > mm:
                    mm = a[nr-1][nc-1]
                    d[0], d[1] = nr, nc
        r[i], c[i] = d[0], d[1]
        dd[(r[i],c[i])].append(i)
    nr = []
    nc = []
    for items in dd:
        arr = dd[items]
        if len(arr) > 1:
            continue
        nr.append(items[0])
        nc.append(items[1])
    r = nr
    c = nc
print(len(r))