from collections import deque
n, k, u, d = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dirs = [(0,1),(0,-1),(1,0),(-1,0)]

comb = []

count = 0

ans = 0

def inrange(r,c):
    if 0<=r<n and 0<=c<n:
        return True
    return False

def qualified(r1,c1,r2,c2):
    if u <= abs(grid[r1][c1]-grid[r2][c2]) <= d:
        return True
    return False


def bfs (startr, startc, visited):
    if (startr,startc) in visited:
        return 0, visited
    before = len(visited)
    visited.add((startr,startc))
    q = deque()
    q.append((startr,startc))
    while q:
        r, c = q.popleft()
        for dr, dc in dirs:
            nr , nc = r + dr, c + dc
            if inrange(nr,nc) and (nr,nc) not in visited and qualified(nr,nc,r,c):
                q.append((nr,nc))
                visited.add((nr,nc))
    after = len(visited)
    return after - before, visited

def backtracking(arr, index):
    if len(arr) == k:
        comb.append(arr[:])
        return
    
    for i in range(index, n*n):
        r = i // n
        c = i % n
        arr.append((r, c))
        backtracking(arr, i+1)
        arr.pop()

backtracking([],0)

for selected in comb:
    visited = set()
    tmp = 0
    for r, c in selected:
        t, visited = bfs(r, c, visited)
        tmp += t
    ans = max(ans, tmp)

print(ans)
