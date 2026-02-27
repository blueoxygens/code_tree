n = int(input())

i = (n - 1) // 8  # n=8일 때 i=0이 아닌 올바른 주기 계산
count = i * 8

for j in range(i * 15 + 1, i * 15 + 16):
    if j % 3 == 0 or j % 5 == 0:
        continue
    count += 1
    if count == n:
        print(j)
        break