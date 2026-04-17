n = int(input())
MOD = 10007

if n % 2 == 1:
    print(0)
else:
    # dp[i][j1][j2][j3]: i열 직전까지 꽉 채웠고
    # 1행, 2행, 3행의 튀어나옴 여부가 j1, j2, j3인 경우의 수
    dp = [[[[0]*2 for _ in range(2)] for _ in range(2)] for _ in range(n+2)]
    dp[1][0][0][0] = 1

    for i in range(1, n+1):
        for j1 in range(2):
            for j2 in range(2):
                for j3 in range(2):
                    val = dp[i][j1][j2][j3]
                    if val == 0:
                        continue

                    def go(row, cur, nxt, v):
                        """row번째 행부터 처리. cur=현재열 채움 상태(j1j2j3), nxt=다음열 튀어나옴"""
                        # 이미 채워진 행 건너뜀
                        while row < 3 and (cur >> row & 1):
                            row += 1
                        if row == 3:
                            # 현재 열 완성 → 다음 열 상태에 누적
                            nj1 = nxt >> 0 & 1
                            nj2 = nxt >> 1 & 1
                            nj3 = nxt >> 2 & 1
                            dp[i+1][nj1][nj2][nj3] = (dp[i+1][nj1][nj2][nj3] + v) % MOD
                            return
                        # 선택 1: 세로 도미노 (현재 행 + 바로 아래 행)
                        if row + 1 < 3 and not (cur >> (row+1) & 1):
                            go(row, cur | (1<<row) | (1<<(row+1)), nxt, v)
                        # 선택 2: 가로 도미노 (현재 행을 다음 열로 넘김)
                        go(row, cur | (1<<row), nxt | (1<<row), v)

                    # 튀어나온 칸(j1,j2,j3)은 이미 채워진 것으로 시작
                    start_mask = (j1 << 0) | (j2 << 1) | (j3 << 2)
                    go(0, start_mask, 0, val)

    print(dp[n+1][0][0][0])