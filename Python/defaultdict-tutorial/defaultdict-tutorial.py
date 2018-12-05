from collections import defaultdict
def format_output(data_array):
    formatted_output = ""
    for element in data_array:
        formatted_output += str(element + 1) + " "
    return formatted_output

d = defaultdict(list)

n, m = input().split()
n = int(n)
m = int(m)

for i in range(n):
    n_a = input()
    d[n_a].append(i)

for i in range(m):
    n_b = input()
    print(format_output(d[n_b]))