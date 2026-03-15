n = int(input())
# name = []
# korean = []
# english = []
# math = []
info = []

for _ in range(n):
    student_info = input().split()
    info.append((student_info[0], int(student_info[1]),int(student_info[2]),int(student_info[3]),))
    # name.append(student_info[0])
    # korean.append(int(student_info[1]))
    # english.append(int(student_info[2]))
    # math.append(int(student_info[3]))

# Please write your code here.

info.sort(key = lambda x : (-x[1],-x[2],-x[3]))

for i in info:
    print(f'{i[0]} {i[1]} {i[2]} {i[3]}')