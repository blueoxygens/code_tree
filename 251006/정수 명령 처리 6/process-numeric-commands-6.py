import heapq
N = int(input())
commands = []

for _ in range(N):
    line = input().split()
    if line[0] == "push":
        commands.append((line[0], int(line[1])))
    else:
        commands.append((line[0],))

# Please write your code here.
q = []
for command in commands:
    if command[0] == "push":
        heapq.heappush(q, -1*command[1])
    elif command[0] == "pop":
        print(-1*heapq.heappop(q))
    elif command[0] == "size":
        print(len(q))
    elif command[0] == "empty":
        print(1 if len(q) == 0 else 0)
    else:
        print(-q[0])