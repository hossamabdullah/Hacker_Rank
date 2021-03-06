from collections import defaultdict
d = defaultdict(list)

n, m = map(int, input().split())

for i in range(n):
    n_a = input()
    d[n_a].append(i+1)

for i in range(m):
    n_b = input()
    if n_b in d:
        print(*d[n_b], sep=' ')
    else:
        print('-1')