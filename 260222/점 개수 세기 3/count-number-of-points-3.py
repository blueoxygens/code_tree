import bisect

n, q = map(int, input().split())
points = sorted(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(q)]

for lb, hb in queries:
    start = bisect.bisect_left(points, lb)   
    end = bisect.bisect_right(points, hb)    
    print(end - start)