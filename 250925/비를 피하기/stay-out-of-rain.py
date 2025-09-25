from collections import deque
import sys

# 입력이 많아질 것을 대비하여 sys.stdin.readline 사용
try:
    # 예외 처리를 위해 input() 대신 sys.stdin.readline() 사용
    # n, h, m = map(int, sys.stdin.readline().split())
    # 문제의 변수명을 고려하여 grid의 크기인 n만 사용하도록 변경
    n, h, m = map(int, input().split())
    grid = [list(map(int, input().split())) for _ in range(n)]
except ValueError:
    n, h, m = 0, 0, 0
    grid = []

def multi_source_bfs(n, grid):
    """
    모든 '3'을 시작점으로 하는 다중 시작점 BFS를 실행하여,
    각 위치에서 가장 가까운 '3'까지의 최단 거리를 계산합니다.
    """
    q = deque()
    # 최단 거리를 저장할 2차원 배열, 초기값은 -1 (미방문)
    dist = [[-1] * n for _ in range(n)]
    
    # 1. 모든 '3'의 위치를 BFS의 시작점으로 큐에 추가
    #    '3'의 위치는 거리가 0이므로 dist 배열에 0으로 초기화
    for i in range(n):
        for j in range(n):
            if grid[i][j] == 3:
                q.append((i, j))
                dist[i][j] = 0

    # 2. BFS 탐색 시작
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        y, x = q.popleft()
        
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            
            # 유효성 검사: 그리드 범위 내, 벽('1')이 아님, 미방문 상태
            if 0 <= ny < n and 0 <= nx < n and grid[ny][nx] != 1 and dist[ny][nx] == -1:
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny, nx))
    
    return dist

def solve():
    """
    문제의 최종 결과를 계산하고 출력합니다.
    """
    if n == 0:
        return
        
    distances = multi_source_bfs(n, grid)
    
    # '2' 위치에는 계산된 최단 거리를, 그 외에는 0으로 설정
    final_ans = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if grid[i][j] == 2:
                final_ans[i][j] = distances[i][j]
                
    # 결과 출력
    for row in final_ans:
        print(' '.join(map(str, row)))

solve()