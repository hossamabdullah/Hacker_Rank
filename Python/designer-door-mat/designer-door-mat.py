input_text = input()
numbers = input_text.split(" ")
height = int(numbers[0])
width = int(numbers[1])
middle = int(width / 2)

prev1 = "."
prev2 = "|"
for i in range(int(height/2)):
    elem = ""
    for j in range(width):
        if(j < middle-1-(3*i) or j >middle+1+(3*i)):
            elem += "-"
        else:
            if prev1 == "." and prev2 == ".":
                elem += "|"
                prev2 = prev1
                prev1 = "|"
            else:
                elem += "."
                prev2 = prev1
                prev1 = "."
    print(elem)

welcome = ""
for i in range(width):
    if(i < middle - 3 or i > middle + 3):
        welcome += "-"
    elif(i == middle):
        welcome +="WELCOME"

print(welcome)

for i in range(int(height/2)-1, -1, -1):
    # print(i)
    elem = ""
    for j in range(width):
        if(j < middle-1-(3*i) or j >middle+1+(3*i)):
            elem += "-"
        else:
            if prev1 == "." and prev2 == ".":
                elem += "|"
                prev2 = prev1
                prev1 = "|"
            else:
                elem += "."
                prev2 = prev1
                prev1 = "."
    print(elem)
