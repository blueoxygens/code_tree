x1, y1, x2, y2 = map(int, input().split())
a1, b1, a2, b2 = map(int, input().split())

# Please write your code here.
x3 = min(x1,a1,x2,a2)
y3 = max(y1,b1,y2,b2)
x4 = max(x1,a1,x2,a2)
y4 = min(y1,b1,y2,b2)

# print(f'{x3},{y3},{x4},{y4}')
print(abs(x3-x4) * abs(y3-y4))
