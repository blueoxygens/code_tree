n = int(input())

# Please write your code here.
def gcd (n,m):
    a = n%m
    if a == 0:
        return m
    else:
        return gcd(n,a)

count = 0
i = 0
while count < n:
    i += 1
    if i % 3 ==0 or i % 5 == 0:
        continue
    count += 1

print(i)