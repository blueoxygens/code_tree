n, q = map(int, input().split())
points = sorted(list(map(int, input().split())))
queries = [tuple(map(int, input().split())) for _ in range(q)]

# Please write your code here

points.sort()

for lb, hb in queries:
    start = 0
    while points[start] < lb:
        start += 1
    end = q
    while points[end] > hb:
        end -= 1
    print(end - start + 1)