# Author : Yashdeep Hinge
# Codeforces 677 Div 2 A

(n,h) =  tuple(map(int,raw_input().split(" ")))
#print "Person:{}".format(n)
#print "Height of the wall:{}".format(h)
heights = list(map(int,raw_input().split(" ")))
#print "Height of First Person: {}".format(heights[0])
width = 0
for height in heights:
    if height>h:
        width = width+2
    else:
        width = width+1
print width
