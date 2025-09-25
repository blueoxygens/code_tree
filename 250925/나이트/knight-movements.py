from collections import deque
import math

n = int(input())
r1, c1, r2, c2 = map(int, input().split())

# Please write your code here.
memo = [[math.inf]*(n+1) for _ in range(n+1)]
memo[r2][c2] = 0

def bfs():
    directions = [(-2,-1),(-2,1),(2,1),(2,-1),(-1,-2),(-1,2),(1,-2),(1,2)]
    visited = set()
    q = deque()
    q.append((r2,c2))
    while q:
        endf = False
        r, c = q.popleft()
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 1<= nr <= n and 1 <= nc <= n and (nr,nc) not in visited :
                q.append((nr,nc))
                memo[nr][nc] = memo[r][c] + 1
                if nr == r1 and nc == c1:
                    endf = True
                    break
        if endf:
            break
        visited.add((r,c))

bfs()
# print(memo)
if memo[r1][c1] == math.inf:
    print(-1)
else:
    print(memo[r1][c1])