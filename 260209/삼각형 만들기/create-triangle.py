# n 입력
n = int(input())
# pos_list
pos_list = list()
# pos_list 입력
for _ in range(n):
    pos_list.append(tuple(map(int, input().split())))

# 함수들
# x_parallel(a, b, c):
def x_parallel(a, b, c):

    # x1, y1 언팩킹
    x1, y1 = pos_list[a]
    # x2, y2 언팩킹
    x2, y2 = pos_list[b]
    # x3, y3 언팩킹
    x3, y3 = pos_list[c]

    # 한 쌍이라도 y값이 같은 쌍이 있으면 통과
    return y1 == y2 or y2 == y3 or y1 == y3

# y_parallel(a, b, c):
def y_parallel(a, b, c):

    # x1, y1 언팩킹
    x1, y1 = pos_list[a]
    # x2, y2 언팩킹
    x2, y2 = pos_list[b]
    # x3, y3 언팩킹
    x3, y3 = pos_list[c]

    # 한 쌍이라도 x값이 같은 쌍이 있으면 통과
    return x1 == x2 or x2 == x3 or x1 == x3

# calc(a, b, c)
def calc(a, b, c):

    # x1, y1 언팩킹
    x1, y1 = pos_list[a]
    # x2, y2 언팩킹
    x2, y2 = pos_list[b]
    # x3, y3 언팩킹
    x3, y3 = pos_list[c]

    # max_x, min_x, max_y, min_y
    max_x, min_x, max_y, min_y = max(x1, x2, x3), min(x1, x2, x3), max(y1, y2, y3), min(y1, y2, y3)

    # curr_area
    # * 삼각형의 넓이지만 2배할 예정이므로, 어짜피 직사각형의 넓이와 같음 * 
    curr_area = (max_x - min_x) * (max_y - min_y)

    # 반환
    return curr_area

# 설계
# max_area
max_area = 0

# 완전 탐색 시작
for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            # x축에 평행이고, y축에 평행인 변이 있으면
            if x_parallel(i,j,k) and y_parallel(i,j,k):
                # max_area 업데이트
                max_area = max(max_area, calc(i,j,k))

# 출력
print(max_area)