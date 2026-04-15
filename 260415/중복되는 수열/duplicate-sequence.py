n = int(input())
sequences = [input() for _ in range(n)]

sequences.sort()

for i in range(n-1):
    if sequences[i] == sequences[i+1][0:len(sequences[i])]:
        print(0)
        break
else:
    print(1)