import calendar

m, d, y=map(int,input().split())
day_num = calendar.weekday(y, m, d)
days_list = list(calendar.day_name)

print(days_list[day_num].upper())
