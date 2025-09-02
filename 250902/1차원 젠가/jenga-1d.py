n = int(input())
blocks = [int(input()) for _ in range(n)]
s1, e1 = map(int, input().split())
s2, e2 = map(int, input().split())

# Please write your code here.
for i in range(2):
    if i == 0:
        temp = blocks[0:s1-1] + blocks[e1:]
        blocks = temp
        # print(blocks)
    else:
        temp = blocks[0:s2-1] + blocks[e2:]
        blocks = temp
        # print(blocks)

print(len(blocks))
for i in blocks:
     print(i)