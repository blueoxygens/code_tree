from collections import deque
n = int(input())
q = deque()
visited = []

# Please write your code here.
def choose(n, visited, q):
    if len(visited) == n:
        print(' '.join(map(str, q)))
        return

    for i in range(1, n+1):
        if i not in visited :
            q.append(i)
            visited.append(i)
            choose(n, visited, q)
            q.pop()
            visited.pop()

choose(n, visited, q)
    