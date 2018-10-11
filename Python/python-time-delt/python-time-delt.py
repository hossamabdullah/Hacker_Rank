from datetime import datetime as dt


fmt = '%a %d %b %Y %H:%M:%S %z'
for i in range(int(input())):
    first_time = dt.strptime(input(), fmt)
    second_time = dt.strptime(input(), fmt)
    diff = (first_time - second_time).total_seconds()
    abs_diff = abs(diff)
    print(int(abs_diff))