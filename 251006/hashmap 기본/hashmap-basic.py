from collections import defaultdict
n = int(input())
commands = []
for _ in range(n):
    line = input().split()
    cmd = line[0]
    k = int(line[1])
    if cmd == "add":
        v = int(line[2])
        commands.append((cmd, k, v))
    else:
        commands.append((cmd, k))

# Please write your code here.
cont = defaultdict()
for command in commands:
    if command[0] == "add":
        cont[command[1]] = command[2]
    elif command[0] == "remove":
       del cont[command[1]]
    else:
        print(cont[command[1]]) if command[1] in cont else print("None")