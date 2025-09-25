n = int(input())

# Please write your code here.

def choose(n, visited, q):
    if len(q) == n:
        print(' '.join(map(str, q)))
        return
    for i in range(n, 0, -1):
        if i not in visited:
            q.append(i)
            visited.append(i)
            choose(n,visited,q)
            q.pop()
            visited.pop()
visited = []
q = []
choose(n, visited, q)