from collections import defaultdict

T = int(input())
opposite = {'L':'R', 'R':'L', 'U':'D', 'D':'U'}
dirs = {'L':(0,-1), 'R':(0,1), 'U':(-1,0), 'D':(1,0)}

for _ in range(T):
    N, M = map(int, input().split())
    x, y, d = [], [], []
    for _ in range(M):
        xi, yi, di = input().split()
        x.append(int(xi))
        y.append(int(yi))
        d.append(di)

    remain = set(range(M))

    for _ in range(2 * N):
        if not remain:
            break
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