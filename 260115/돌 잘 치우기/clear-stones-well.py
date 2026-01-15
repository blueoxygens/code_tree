from collections import deque

n, k, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

starts = []
for _ in range(k):
    ri, ci = map(int, input().split())
    starts.append((ri - 1, ci - 1))

# 2. 제거 후보 선정 (모든 벽 '1'의 위치)
walls = [(i, j) for i in range(n) for j in range(n) if grid[i][j] == 1]
ans = 0
dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def get_count(selected_walls):
    q = deque(starts)
    visited = [[False] * n for _ in range(n)]
    for sr, sc in starts:
        visited[sr][sc] = True
    
    remove_set = set(selected_walls)
    count = 0
    
    while q:
        curr_r, curr_c = q.popleft()
        count += 1
        
        for dr, dc in dirs:
            nr, nc = curr_r + dr, curr_c + dc
            if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
                if grid[nr][nc] == 0 or (nr, nc) in remove_set:
                    visited[nr][nc] = True
                    q.append((nr, nc))
    return count

def backtracking(idx, selected):
    global ans
    if len(selected) == m:
        ans = max(ans, get_count(selected))
        return
    
    if idx == len(walls):
        ans = max(ans, get_count(selected))
        return

    selected.append(walls[idx])
    backtracking(idx + 1, selected)
    selected.pop()
    
    backtracking(idx + 1, selected)

actual_m = min(m, len(walls))
backtracking(0, [])

print(ans)