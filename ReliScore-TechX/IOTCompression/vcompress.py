# Author : Yashdeep Hinge
# Problem: Compress IOT data with correcting it first.

def store(line,devices):
    parts = line.rstrip('\n').split(',')
    if type(devices[devices[parts[1]]]) is list:
        devices[devices[parts[1]]].append(parts[2])
    else:
        devices[devices[parts[1]]]=[parts[2]]


devices={}
with open('input1.txt','r') as fp:
    for line in fp: 
        store(line,devices)
print devices
        

