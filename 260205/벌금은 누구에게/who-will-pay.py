N, M, K = map(int, input().split())
student = [int(input()) for _ in range(M)]

# Please write your code here.

s = [0] * (N+1)

for n in student:
    s[n] += 1
    if s[n] >= K:
        print(n)
        break 