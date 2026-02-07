cmd = input()

# Please write your code here.
dirs = [(0,1),(1,0),(0,-1),(-1,0)]
d = 0
x = 0
y = 0

for c in cmd :
    if c == 'R':
        d = (d+1) % 4
    elif c == 'L':
        d = (d-1) % 4
    else:
        x = x + dirs[d][0]
        y = y + dirs[d][1]

print(f'{x} {y}')