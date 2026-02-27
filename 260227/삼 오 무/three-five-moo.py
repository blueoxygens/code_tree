n = int(input())

# Please write your code here.
# 8 -> 15당

i = n//8

count = i*8
ans = 0

for j in range(i*15+1,i*15+16):
    if j % 3 ==0 or j % 5 ==0:
        continue
    count += 1
    if count == n:
        ans = j
        break

print(ans)
