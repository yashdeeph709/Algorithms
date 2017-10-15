number_of_tests=int(raw_input())

for i in range(0,number_of_tests):
    line=raw_input()
    N=int(line.split(" ")[0])
    M=int(line.split(" ")[1])
    rows={}
    for j in range(0,N):
        rows[j]=raw_input()
    test=raw_input()
    result=True
    for x in range(0,len(test)):
        if test[x] in rows[x%N]:
            index=rows[x%N].index(test[x])
            rowdata=rows[x%N]
            #print "Searching {} in {} at {}".format(test[x],rowdata,index)
            if index+1<len(rowdata) and index>0:
                rows[x%N]=rowdata[:index]+rowdata[index+1:len(rowdata)]
                #print rowdata[:index]
                #print rowdata[index+1:len(rowdata)]
                #print rows[x%N]
            elif index==0:
                rows[x%N]=rowdata[1:len(rowdata)]
            elif index+1==len(rowdata):
                rows[x%N]=rowdata[0:len(rowdata)-1]
                #print rows[x%N]
        else:
           #print rows
           result=False
           break
    if result:
        print "Yes"
    else:
        print "No"
