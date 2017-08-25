numbers = [4,2,3,3,5,5,6,1,1,3]

min = numbers[0]
for i in range(1,len(numbers)):
    if min > numbers[i]:
        min = numbers[i]
print "minimum of this array is {}".format(min)

