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

    remain = set(range(M))
    seen_states = set()  # 상태 캐싱

    for _ in range(4 * N * N):
        if not remain:
            break

        # 현재 상태 해싱
        state = frozenset((x[i], y[i], d[i]) for i in remain)
        if state in seen_states:
            break  # 사이클 감지 → 더 이상 변화 없음
        seen_states.add(state)

        pos_dict = defaultdict(list)
        for i in remain:
            dx, dy = dirs[d[i]]
            nx, ny = x[i] + dx, y[i] + dy

            if not (1 <= nx <= N and 1 <= ny <= N):
                d[i] = opposite[d[i]]
                nx, ny = x[i], y[i]

            x[i], y[i] = nx, ny
            pos_dict[(nx, ny)].append(i)

        for indices in pos_dict.values():
            if len(indices) >= 2:
                remain -= set(indices)

    print(len(remain))