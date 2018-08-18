#!/bin/python3

import math
import os
import random
import re
import sys

    
if __name__ == '__main__':
    t = int(input().strip())
    for t_itr in range(t):
        n = int(input().strip())
        remaining = 0
        for n_itr in range(n):
            actual = sys.stdin.read()
            estimated = sys.stdin.read()
            print(estimated)
