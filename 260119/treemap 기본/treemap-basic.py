n = int(input())

cmd = []
k = []
v = []

for _ in range(n):
    line = input().split()
    cmd.append(line[0])
    if line[0] == "add":
        k.append(int(line[1]))
        v.append(int(line[2]))
    elif line[0] == "remove" or line[0] == "find":
        k.append(int(line[1]))
        v.append(0)
    else:
        k.append(0)
        v.append(0)

# Please write your code here.
p = {}
for i in range(n):
    if cmd[i] == "add":
        p[k[i]] = v[i]
    elif cmd[i] == "find":
        print(p[k[i]] if k[i] in p else "None")
    elif cmd[i] == "remove":
        p.pop(k[i])
    else:
        print(" ".join(str(p[x]) for x in sorted(p)) if p else "None")
