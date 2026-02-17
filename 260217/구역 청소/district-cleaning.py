a, b = map(int, input().split())
c, d = map(int, input().split())

# Please write your code here.

section = [False] * 101
count = 0

for i in range(a,b+1):
    if not section[i]:
        section[i] = True
        count += 1

for i in range(c,d+1):
    if not section[i]:
        section[i] = True
        count += 1

# print(section)
print(count-1)