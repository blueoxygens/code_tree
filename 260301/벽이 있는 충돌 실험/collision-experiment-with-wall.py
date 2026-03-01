from collections import deque

T = int(input())
dirs = {'L':(0,-1), 'R':(0,1), 'U':(-1,0), 'D':(1,0)}
opposite = {'L':'R', 'R':'L', 'U':'D', 'D':'U'}

for _ in range(T):
    N, M = map(int, input().split())
    x, y, d = [], [], []
    for _ in range(M):
        xi, yi, di = input().split()
        x.append(int(xi))
        y.append(int(yi))
        d.append(di)

    remain = deque(range(M))

    for _ in range(4 * N * N):  # 사이클 이상 돌면 종료
        if not remain:
            break

        pos_dict = {}  # 위치 -> 구슬 인덱스들

        next_remain = deque()

        for i in remain:
            dx, dy = dirs[d[i]]
            nx, ny = x[i] + dx, y[i] + dy

            # 벽에 부딪히면 방향 반전, 위치 유지
            if not (1 <= nx <= N and 1 <= ny <= N):
                d[i] = opposite[d[i]]
                nx, ny = x[i], y[i]

            x[i], y[i] = nx, ny

            if (nx, ny) not in pos_dict:
                pos_dict[(nx, ny)] = []
            pos_dict[(nx, ny)].append(i)

        # 충돌 처리
        survived = set()
        for pos, indices in pos_dict.items():
            if len(indices) == 1:
                survived.add(indices[0])
            # 2개 이상이면 모두 제거

        remain = deque(i for i in remain if i in survived)

    print(len(remain))