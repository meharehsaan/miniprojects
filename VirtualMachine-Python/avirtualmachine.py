import sys
# import numpy as np

# loading file in program
def loadFile(filename):
    # Reading the input file
    with open(filename, 'r') as file:
        lines = file.readlines()

    # converting hex into integers and saving
    data_size = int(lines[0], 16)
    image_size = int(lines[1], 16)

    # print(data_size)
    # defining array of 0 to 11398
    data = [0 for _ in range(data_size)]

    # storing image vlaues in array in int form
    for i in range(image_size):
        data[i] = int(lines[i+2].strip(), 16)
        #data.append(int(lines.strip()), 16)
    
    return data, data_size

# functions given in instructions
def fFunc(val):
    global sp, data
    # print("sp = ",  sp)
    sp = sp - 1
    data[sp] = val

def gFunc():
    global sp, data
    mydata = data[sp]
    sp = sp + 1
    # print("sp = ",  sp)
    return mydata

# execute func
def execution():
    global ip, sp
    while True:
        cInstr = data[ip]
        ip = ip + 1

        # decoding instruction 
        binop = (cInstr >> 31) & 0x1        # 1 bit
        operation = (cInstr >> 24) & 0x7f   #127 #7 bits
        opt_data = (cInstr) & 0xFFFFFF      # remaining bits

        # so binop 1 bit value can be 0 or 1
        if binop == 0:
            if operation == 0:  # pop operation
                sp = sp + 1

            elif operation == 1: # push operation
                fFunc(opt_data)
            
            elif operation == 2: # push ip operation
                fFunc(ip)

            elif operation == 3: # push ap operation
                fFunc(sp)

            elif operation == 4: # load operation
                addr = gFunc()
                fFunc(data[addr])

            elif operation == 5: # store operation
                st_data = gFunc()
                addr = gFunc()
                data[addr] = st_data

            elif operation == 6: # imp operation
                cond = gFunc()
                addr = gFunc()
                if cond != 0:
                    ip = addr

            elif operation == 7: # not operation
                if gFunc() == 0:
                    fFunc(1)
                else:
                    fFunc(0)

            elif operation == 8: # putchar operation
                result = chr(gFunc() & 0xff)
                sys.stdout.write(result)

            elif operation == 9: # getchar operation
                x = sys.stdin.read(1)
                x = int.from_bytes(x, byteorder='little') # because our systems are little-endians
                fFunc(x & 0xff)

            elif operation == 10: # halt operation
                sys.exit()

        elif binop == 1:
            b = gFunc()
            a = gFunc()
        
            if operation == 0:  # add operation
                fFunc(a + b)

            elif operation == 1: # subtract operation
                fFunc(a - b)

            elif operation == 2: # multiply  operation
                fFunc(a * b)

            elif operation == 3: # divide operation
                if(b != 0):
                    val = int(a / b)
                    fFunc(val)

            elif operation == 4: # AND operation
                fFunc(a & b)

            elif operation == 5: # OR operation
                fFunc(a | b)

            elif operation == 6: # XOR operation
                fFunc(a ^ b)

            elif operation == 7: # assignment operation
                if(a == b):
                    val1 = 1
                    fFunc(val1)
                else:
                    val1 = 0
                    fFunc(val1)

            elif operation == 8: # lt operation
                val2 = int(a < b)
                fFunc(val2)

        else:
            print("Something went wrong...!ERROR")
            sys.exit()


# main execution of functions
def main():
    global data,ip,sp
    if len(sys.argv) != 2:
        print("Give file name in cmdline arg only 1")
        sys.exit()

    # saving filname from cmd argument    
    filename = sys.argv[1]
    result = loadFile(filename)
    data = result[0]        # assigning data return
    data_size = result[1]   # assigning data_size return

    # declaring variables in instructions
    ip = 0
    sp = data_size

    # execuitng instructions
    execution()

main()