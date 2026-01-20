n = int(input())
edges = [tuple(map(int, input().split())) for _ in range(n - 1)]

# Please write your code here.
edges = sorted(edges, key=lambda x: x[1])
# print(edges)

for p, c in edges:
    print(p)