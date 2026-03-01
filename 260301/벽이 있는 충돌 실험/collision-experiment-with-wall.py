from collections import defaultdict

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

    remain = set(range(M))  # deque → set으로 변경 (삭제 O(1))

    for _ in range(4 * N * N):
        if not remain:
            break

        pos_dict = defaultdict(list)  # 위치 -> 구슬 목록

        for i in remain:
            dx, dy = dirs[d[i]]
            nx, ny = x[i] + dx, y[i] + dy

            if not (1 <= nx <= N and 1 <= ny <= N):
                d[i] = opposite[d[i]]
                nx, ny = x[i], y[i]

            x[i], y[i] = nx, ny
            pos_dict[(nx, ny)].append(i)

        # 충돌 제거 — 한 번에 처리
        for pos, indices in pos_dict.items():
            if len(indices) >= 2:
                remain -= set(indices)  # 충돌한 것만 제거

    print(len(remain))