n = int(input())
segments = [tuple(map(int, input().split())) for _ in range(n)]
x1, x2 = zip(*segments)
x1, x2 = list(x1), list(x2)

# Please write your code here.

bits = [0]*101
full = (1 << n) - 1 

for i in range(n):
    for j in range(x1[i],x2[i]+1):
        bits[j] |= (1<<i)


for i in range(n):
    if bits[j] == full:
        print("Yes")
        break
else:
    print("No")