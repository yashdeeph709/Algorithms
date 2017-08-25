# Author : Yashdeep Hinge
# Codeforces 791 Div 2 A

(l,b) = tuple(map(int,raw_input().split(" ")))
n = 0
while l<=b:
    l=l*3
    b=b*2
    n=n+1
print n

