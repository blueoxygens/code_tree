n, q = map(int, input().split())
points = list(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(q)]

# Please write your code here
for un ,up in queries:
    count = 0
    for p in points:
        if un <= p <= up:
            count += 1
    print(count)
