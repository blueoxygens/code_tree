n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
m = 0
for i in range(n-k+1):
    t = 0
    for j in range(i,i+k):
        t += arr[j]
    m = max(m,t)

print(m)