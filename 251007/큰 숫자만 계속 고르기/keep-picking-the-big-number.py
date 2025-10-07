from collections import deque

n, m = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
q = deque(sorted(arr, key = lambda x :-x))
for _ in range(m):
    q.append(q.popleft()-1)
    q = deque(sorted(q, key = lambda x :-x))

print(q.popleft())