n = int(input())
intervals = [tuple(map(int, input().split())) for _ in range(n)]

# 시작점 기준 정렬
intervals.sort()

merged = []
for a, b in intervals:
    if merged and merged[-1][1] >= a:
        # 겹치면 합치기
        merged[-1] = (merged[-1][0], max(merged[-1][1], b))
    else:
        merged.append((a, b))

print(len(merged))