# Uses python3
n = int(raw_input())
a = [int(x) for x in raw_input().split()]
assert(len(a) == n)

if a[0]>a[1]:
    max1=a[0]
    max2=a[1]
else:
    max1=a[1]
    max2=a[0]


for i in range(2, n):
    #print i, max1, max2
    if a[i] > max1:
        max2=max1
        max1=a[i]
    else: 
        if a[i] > max2:
         max2=a[i]
    #print i, max1, max2

print(max1*max2)


