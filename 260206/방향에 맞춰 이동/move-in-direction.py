n = int(input())
moves = [tuple(input().split()) for _ in range(n)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

# Please write your code here.
dirs = {'N':(0,1),'S':(0,-1),'E':(1,0),'W':(-1,0)}

x = 0
y = 0

for i in range(n):
    dx, dy = dirs[dir[i]]
    nx = x + dx*dist[i]
    ny = y + dy*dist[i]
    x = nx
    y = ny

print(f'{x} {y}')