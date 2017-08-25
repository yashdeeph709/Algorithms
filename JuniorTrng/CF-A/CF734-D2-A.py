# Author : Yashdeep Hinge
# Codeforces 734 Div 2 A
length = int(raw_input())
matches = raw_input()
anton = 0
darik = 0

for char in matches:
    if char == "A":
        anton = anton + 1
    else:
        darik = darik + 1

if anton > darik:
    print "Anton"
elif darik > anton:
    print "Danik"
else:
    print "Friendship"
    

