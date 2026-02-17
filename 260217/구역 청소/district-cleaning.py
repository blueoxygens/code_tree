a, b = map(int, input().split())
c, d = map(int, input().split())

covered = [False] * 101

for i in range(a, b):
    covered[i] = True

for i in range(c, d):
    covered[i] = True

print(sum(covered))