from collections import deque
import math
import sys

try:
    n = int(sys.stdin.readline())
    r1, c1, r2, c2 = map(int, sys.stdin.readline().split())
except:
    sys.exit()


def bfs(n, start_r, start_c, end_r, end_c):
    dist = [[-1] * (n + 1) for _ in range(n + 1)]
    
    directions = [(-2, -1), (-2, 1), (2, 1), (2, -1), 
                  (-1, -2), (-1, 2), (1, -2), (1, 2)]
    
    q = deque()
    
    dist[start_r][start_c] = 0
    q.append((start_r, start_c))
    
    while q:
        r, c = q.popleft()
        
        if r == end_r and c == end_c:
            return dist[r][c]
            
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            
            if 1 <= nr <= n and 1 <= nc <= n and dist[nr][nc] == -1:
                dist[nr][nc] = dist[r][c] + 1
                q.append((nr, nc))
                
    return -1


result = bfs(n, r1, c1, r2, c2)

print(result)