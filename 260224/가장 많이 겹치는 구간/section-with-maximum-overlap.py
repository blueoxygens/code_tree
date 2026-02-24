n = int(input())
intervals = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
rintervals = sorted(intervals, key=lambda x:x[1])
l = rintervals[n-1][1]
memo = [0]*(l+1)
start = 0
for x1, x2 in intervals:
    memo[x1] = 1
    memo[x2] = -1
for i in range(1,l+1):
    memo[i] += memo[i-1]
print(max(memo))