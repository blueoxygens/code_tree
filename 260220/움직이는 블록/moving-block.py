n = int(input())
blocks = [int(input()) for _ in range(n)]

# Please write your code here.
s = sum(blocks) // n

subblocks = [blocks[i] - s for i in range(n)]
ans = 0
for i in range(n):
    if subblocks[i] > 0:
        ans += subblocks[i]
print(ans) 