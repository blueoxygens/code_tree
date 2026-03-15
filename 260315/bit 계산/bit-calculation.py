q = int(input())
commands = []
for _ in range(q):
    line = input().split()
    if line[0] != "clear":
        commands.append((line[0], int(line[1])))
    else:
        commands.append((line[0],))

# Please write your code here.
s = 0
for i in range(q):
    if commands[i][0] == 'add':
        s |= (1<<commands[i][1])
    elif commands[i][0] == 'print':
        if s & (1<<commands[i][1]):
            print(1)
        else:
            print(0)
    elif commands[i][0] == 'delete':
        s &= ~(1<<commands[i][1])
    elif commands[i][0] == 'toggle':
        s ^= (1<<commands[i][1])
    else:
        s = 0