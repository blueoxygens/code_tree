x1, y1, x2, y2 = map(int, input().split())
a1, b1, a2, b2 = map(int, input().split())

# Please write your code here.

if (a1 <= x1 <=a2 or  a1 <= x2 <=a2) or ( b1 <= y1 <=b2 or b1 <= y2 <=b2):
    print("overlapping")
elif (x1 <= a1 <=x2 or  x1 <= a2 <=x2) or ( y1 <= b1 <=y2 or y1 <= b2 <=y2):
    print("overlapping")
else:
    print("nonoverlapping")