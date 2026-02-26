n, k = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.
record = {i : set([i]) for i in range(1, n+1)}
cton =  {i : i for i in range(1, n+1)}
ntoc =  {i : i for i in range(1, n+1)}

for i in range(3*k):
    c1, c2 = edges[i%k]
    a, b = cton[c1], cton[c2]
    record[a].add(c2)
    record[b].add(c1)
    cton[c1], cton[c2] = b, a
    ntoc[a], ntoc[b] = c2, c1

# print(record)
for i in range(1, n+1):
    print(len(record[i]))