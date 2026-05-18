from collections import deque
import math
expression = input()

# Please write your code here.

operators = ['+','-','*']

chr_to_index = {}
chr = set()
ans = -math.inf

# l = 0
for e in expression:
    if e not in operators:
        # l += 1
        chr.add(e)

chr = list(chr)
chr.sort()
cl = len(chr)

for i, c in enumerate(chr):
    chr_to_index[c] = i

comb = []

def backtracking(arr):
    if len(arr) == cl:
        comb.append(arr[:])
        return
    
    for i in range(1,5):
        arr.append(i)
        backtracking(arr)
        arr.pop()

backtracking([])

def calc(c):
    result = 0
    if len(expression) == 1:
        return c[chr_to_index[expression[0]]]
    q = deque(expression)

    while q:
        a = q.popleft()
        if a not in operators:
            op = q.popleft()
            b = q.popleft()

            if op == '+':
                result = c[chr_to_index[a]] + c[chr_to_index[b]]
            elif op == '-':
                result = c[chr_to_index[a]] - c[chr_to_index[b]]
            else:
                result = c[chr_to_index[a]] * c[chr_to_index[b]]
        else:
            b = q.popleft()
            if a == '+':
                result += c[chr_to_index[b]]
            elif a == '-':
                result -= c[chr_to_index[b]]
            else:
                result *= c[chr_to_index[b]]
    
    return result


for c in comb:
    ans = max(calc(c),ans)

print(ans)
