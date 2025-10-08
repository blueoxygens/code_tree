n, k = map(int, input().split())
arr = [[0]*(n+1)]
for _ in range(n):
    arr.append([0] + list(map(int, input().split())))
# Please write your code here.
ps = [[0]*(n+1) for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        ps[i][j] = ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1] + arr[i][j]

# 정사각형 탐색 진행하는데..k * k 크기만큼 진행
ans = 0
for i in range(k,n+1):
    for j in range(k,n+1):
        if k > 1:
            ans = max(ans, ps[i][j] - ps[i-k][j] - ps[i][j-k] + arr[1][1])
        else:
            ans = max(ans, ps[i][j] - ps[i-k][j] - ps[i][j-k])
print(ans)