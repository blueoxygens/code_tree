from collections import deque
n = int(input())
intervals = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
rintervals =  sorted(intervals, key=lambda x: x[1])
end = 0
ans = 0
for a, b in rintervals:
    if a > end:
        ans += 1
        end  = b
    else:
        end = b

print(ans)