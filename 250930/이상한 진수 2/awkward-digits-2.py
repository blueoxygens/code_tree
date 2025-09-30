a = input()

# Please write your code here.
ans = 0
a = list(a)
for i in range(len(a)):
    temp = a[:]
    temp[i] = '1' if temp[i] == '0' else '0'
    ans = max(ans, int(''.join(temp), 2))
print(ans)