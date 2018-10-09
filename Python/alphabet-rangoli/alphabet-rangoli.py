import string
chars = list(string.ascii_lowercase)
# print(chars)

def print_rangoli(size):
    #take zero index into consideration
    size = size - 1 #2 = 3 -1
    #create a 2d matrix with - items
    w, h = (size*4 + 1),  (size*2 + 1)
    matrix = [['-' for x in range(w)] for y in range(h)] 


    # # matrix[0][4] = 'c'   
    # x
    
    # # matrix[1][2] = 'c'
    # x
    # # matrix[1][4] = 'b'
    # x
    # # matrix[1][6] = 'c'
    # x

    # # matrix[2][0] = 'c'
    # x
    # size = 2
    # # matrix[2][2] = 'b'
    # x
    # # matrix[2][4] = 'a'
    # x
    # # matrix[2][6] = 'b'
    # x
    # # matrix[2][8] = 'c'
    # x

    # # matrix[3][2] = 'c'
    # # matrix[3][4] = 'b'
    # # matrix[3][6] = 'c'

    # # matrix[4][4] = 'c'

    mid = w // 2
    midCol = h // 2
    for x in range(0, midCol+1):
        middle_char = chars[size - x]
        matrix[x][mid] = middle_char
        for y in range(1, x+1):
            selectedChar =  chars[size - x + y]
            matrix[x][mid - 2*y] = selectedChar
            matrix[x][mid + 2*y] = selectedChar        

    for x in range(midCol+1, h):
        # print('---')
        # print(x)
        x = x - midCol
        # print(x)
        middle_char = chars[x]
        matrix[x+midCol][mid] = middle_char
        for y in range(1, size-x+1):
            # print("y=")
            # print(y)
            selectedChar =  chars[x + y]
            matrix[x+midCol][mid - 2*y] = selectedChar
            matrix[x+midCol][mid + 2*y] = selectedChar  

    # print(matrix)
    for r in matrix:
        x = ""
        for c in r:
            x  = x + c
        print(x)
    pass
