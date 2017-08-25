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
