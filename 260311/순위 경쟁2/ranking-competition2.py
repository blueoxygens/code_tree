n = int(input())
c = []
s = []
for _ in range(n):
    ci, si = input().split()
    c.append(ci)
    s.append(int(si))

# Please write your code here.

honor = 'A, B'
a = 0
b = 0
ans = 0

for i in range(n):
    if c[i] == 'B':
        b += s[i]
    else:
        a += s[i]
    
    if a > b and honor != 'A':
        honor = 'A'
        ans += 1
    elif a < b and honor != 'B':
        honor = 'B'
        ans += 1
    elif a == b and honor != 'A, B':
        honor = 'A, B'
        ans += 1

print(ans)