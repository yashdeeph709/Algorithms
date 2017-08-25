import math
def combiner(list1,list2):
    #print "combiner started"
    list3=[]
    for x in range(0,len(list1)):
        for y in range(0,len(list2)):
            #print str(list1[x])+""+str(list2[y])
            #print str(list2[y])+""+str(list1[x])
            list3.append(str(list1[x])+""+str(list2[y]))
            list3.append(str(list2[y])+""+str(list1[x]))
    #print "combiner end"
    return list3
        
def order(n):
    #print "Order called for "+str(n)
    limit=0
    if n is 1:
        return list([1])
    if n is 2:
        return list([2,11])
    if n is 3:
        return list([12,21])
    if n is 4:
        return list([22,1111,112,211,121])

    if n%2==0:
       limit=n/2+1
    else:
       limit=n/2+2 

    result=[]

    for i in range(1,limit):
       #print "triggering combine of order("+str(i)+"), order("+str(n-i)+")";
        result=list(result+(combiner(order(i),order(n-i))))

    return result

def printSeq(comby,outputStream):
    for i in comby:
        #print i
        outputStream.write(i)
        outputStream.write("\n")

def printlen(comby,outputStream):
    outputStream.write(str(len(comby)))

def create_combs(number):
    result=0
    factor=1
    i=number/2+1
    j=number/2
    print "number:i"+str(i)+"number:"+str(j)
    while j >= 1:
        result = result + (math.factorial(i)/(math.factorial(j)*math.factorial(i-j)))
        print result
        i+=1
        j-=1
    result+=1
    return result

def create_combs_even(number):
    result=0
    factor=2
    i=number/2+1
    j=factor
    while j>=1:
       result = result + (math.factorial(i)/(math.factorial(factor)*math.factorial(i-factor))) 
       print result
       j=i-factor
       i=i+1
       factor+=2
    result+=1
    return result

inp = open("input.txt","r")
output = open("output.txt","w")
number = int(inp.readlines()[0])
if number%2 != 0:
    print(create_combs(number))
else:
    print(create_combs_even(number))
    
    
