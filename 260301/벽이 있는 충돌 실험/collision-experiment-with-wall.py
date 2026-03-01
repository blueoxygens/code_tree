# t 입력
t = int(input())

# 함수들
# in_range(x, y)
def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

# move_on_next_count(x, y, curr_d)
def move_on_next_count(x, y, curr_d):
    
    # dxs, dys
    dxs, dys = [-1, 0, 1, 0], [0, 1, 0, -1]
    
    # mapper
    mapper = {
        'U':0,
        'R':1,
        'D':2,
        'L':3
    }
    
    # nx, ny
    nx, ny = x + dxs[mapper[curr_d]], y + dys[mapper[curr_d]]
    # 범위 내이면
    if in_range(nx, ny):
        # next_count 올려주고
        next_count[nx][ny] += 1
        # next_count_dir 유지
        next_count_dir[nx][ny] = curr_d
    # 범위 밖이면
    else:
        # 방향 바꿔주고
        if curr_d == 'U':
            curr_d = 'D'
        elif curr_d == 'R':
            curr_d = 'L'
        elif curr_d == 'D':
            curr_d = 'U'
        else:
            curr_d = 'R'
        # next_count 유지
        next_count[x][y] += 1
        # next_count_dir 바꿔주기
        next_count_dir[x][y] = curr_d

# 설계
for _ in range(t):
    # n, m 입력
    n, m = map(int, input().split())
    count = [
        [0] * n
        for _ in range(n)
    ]
    count_dir = [
        [0] * n
        for _ in range(n)
    ]
    # sx, sy, d 입력
    for i in range(m):
        sx, sy, d = input().split()
        sx, sy = int(sx) - 1, int(sy) - 1
        count[sx][sy] = 1
        count_dir[sx][sy] = d
    
    # 시뮬레이션을 2n번 반복
    for _ in range(2*n):
        
        # next_count
        next_count = [
            [0] * n
            for _ in range(n)
        ]
        
        # next_count_dir
        next_count_dir = [
            [0] * n
            for _ in range(n)
        ]
        
        # count를 돌면서
        for i in range(n):
            for j in range(n):
                # 구슬을 발견하면
                if count[i][j]:
                    # next_count 위에서 옮겨주기
                    move_on_next_count(i, j, count_dir[i][j])
        
        # next_count를 돌면서
        for i in range(n):
            for j in range(n):
                # 2 이상을 발견하면
                if next_count[i][j] >= 2:
                    # 펑
                    next_count[i][j] = 0
                    next_count_dir[i][j] = 0

        # count에 next_count를 복사
        for i in range(n):
            for j in range(n):
                count[i][j] = next_count[i][j]
                count_dir[i][j] = next_count_dir[i][j]
    
    # 모든 시뮬레이션을 끝낸 후
    # ans
    ans = 0

    # 최종 count를 돌면서
    for i in range(n):
        for j in range(n):
            ans += count[i][j]
    
    # 출력
    print(ans)