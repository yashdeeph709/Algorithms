# This program is written for converting hex to base64 for cryptopals challenges for cryptography.
# Conversion table for Hex to Binary
from collections import OrderedDict

Hex = [ 0b0000,0b001,0b0010,0b0011,0b0100,0b0101,0b0110,0b0111,0b1000,0b1001,0b1010,0b1011,0b1100,0b1101,0b1110,0b1111 ]
D = OrderedDict()
L = [chr(i) for i in range(ord('A'), ord('Z')+1) + range(ord('a'), ord('z')+1)]
L.extend(range(0, 10) + ['+', '/'])
for i in range(len(L)):
    D[L[i]] = bin("0b"+"{0:06b}".format(i))

print D













