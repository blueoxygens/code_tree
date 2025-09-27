from collections import deque

n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

d = [(1,0),(0,-1),(-1,0),(0,1)]

def bfs():
    q = deque()
    q.append((0, 0, 0))
    
    # set 대신 2차원 visited 배열 사용
    visited = [[False]*m for _ in range(n)]
    visited[0][0] = True

    while q:
        y, x, lv = q.popleft()
        for dy, dx in d:
            ny, nx = y + dy, x + dx
            if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx] and a[ny][nx] != 0:
                if ny == n-1 and nx == m-1:
                    return lv+1
                visited[ny][nx] = True  # 큐에 넣을 때 바로 방문 체크
                q.append((ny, nx, lv+1))
    return -1

print(bfs())
