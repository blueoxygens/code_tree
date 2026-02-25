from collections import deque
n = int(input())
intervals = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
rintervals =  sorted(intervals, key=lambda x: x[1])
l = rintervals[n-1][1]
memo = [0]*(l+2)
for a, b in intervals:
    memo[a] = 1
    memo[b] = -1

q = deque(memo)

ans = 0
stck = deque()
while q:
    t = q.popleft()
    if t == 1:
        stck.append(t)
    elif t == -1:
        stck.pop()
        while stck:
            if q.popleft() == -1:
                stck.pop()
        ans += 1

print(ans)