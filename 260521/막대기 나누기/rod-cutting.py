n = int(input())
profit = list(map(int, input().split()))

# dp[j]는 크기 j를 채웠을 때 얻을 수 있는 최대 수익
dp = [0] * (n + 1)

# i는 현재 고려하고 있는 아이템의 크기 (1부터 n까지)
for i in range(1, n + 1):
    # 만약 profit 리스트가 n보다 짧을 경우를 대비한 예외 처리
    if i - 1 >= len(profit):
        break
    
    v = profit[i-1] # 크기 i인 아이템의 가치
    
    # j 크기를 채울 때, 현재 아이템을 추가하는 것이 이득인지 계산
    for j in range(i, n + 1):
        dp[j] = max(dp[j], dp[j - i] + v)

# 최종적으로 크기 n을 채웠을 때의 최대 가치 출력
print(dp[n])