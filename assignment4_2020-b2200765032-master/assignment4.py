# -*- coding: utf-8 -*-
"""
Created on Thu Dec 17 18:56:42 2020

@author: Görkem Kola
"""

class ParameterNumberError(Exception):              pass
class UndefinedParameterError(Exception):           pass
class FileCouldNotBeReadError(Exception):           pass
class FileIsEmptyError(Exception):                  pass
class InvalidCharacterInFileError(Exception):       pass
# defining the errors
try:
    import sys
    if len(sys.argv) != 5:
        raise ParameterNumberError
    # raising parameternumbererror if sys.argv hasn't got enough arguments
    
    r = "Key"
    if sys.argv[2][-1:-5:-1] != "txt.":
        raise FileCouldNotBeReadError
    # raising filecoludnotbereaderror if the input is not a text file
    f1k = open(sys.argv[2],"r")
    a = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" ,"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " "]
    # takes all numbers as a list to use indexing method.
    key = f1k.read()
    if len(key) == 0:
        raise FileIsEmptyError
    # raising fileisemtyerror if input file is empty
    key = [[int(i) for i in j.split(",")] for j in key.split("\n")]
    # making matrix key file
    for i in key:
        for j in range(i.count("")):
            key[key.index(i)].remove(j)
        for j in i:
            if j not in [1,2,3,4,5,6,7,8,9,0]:
                r = "key"
                raise InvalidCharacterInFileError
                # checing the key file if it has numbers that must not be there
    

    def invmatrix():
        global counter, Ikey
        Ikey = [[0 for i in range(len(key[0]))] for j in range(len(key))]
        # making matrix to inverse matrix
        for i in range(len(key)): Ikey[i][i] = 1
        # converting Ikey to Identity matrix
        for counter in range(len(key)):
            m = 1/key[counter][counter]
            # defining a number to divide the row because we want the focus diagonel character 1
            for i in range(len(key[counter])):
                key[counter][i] = key[counter][i]*m
                Ikey[counter][i] = Ikey[counter][i]*m
                # making the focus diagonel character 1 
            for j in range(len(key)):
                if j!= counter:
                    n = key[j][counter]/key[counter][counter]
                    for i in range(len(key[1])):
                        key[j][i] = key[j][i]-n*key[counter][i]
                        Ikey[j][i] = Ikey[j][i]-n*Ikey[counter][i]
                        # making the column except for the converted character 0
                         
    def decoding():
        global r
        cypher_text = f2i.read().strip(", ").split(",")
        if cypher_text == [""]:
            raise FileIsEmptyError
            # giving a fileisemptyerror if the input file is empty
        for i in range(cypher_text.count("")):
            cypher_text.remove("")
            # deleting the empty characters
        for i in "".join(cypher_text):
            if i not in ["1","2","3","4","5","6","7","8","9","0"," "]:
                r ="input"
                raise InvalidCharacterInFileError
                # checking if the input file has invalid characters and if it has giving an error
        for i in range(len(Ikey)):
            B.append(cypher_text[i::len(key)])
            # making a list that will be converted the message
        for j in range(len(B[0])):
            C = []
            for i in range(len(B)):
                C.append(B[i][j])
            message.append(C)
        # message is transpose of B
        C = [[0 for i in range(len(message[0]))] for j in range(len(message))]
        # making a matrix
        for i in range(len(Ikey)):
            for j in range(len(Ikey[0])):
                for k in range(len(message)):
                    C[k][j] += Ikey[j][i]*int(message[k][i])
        # multiplying Inverse key matrix and message matrix and writing it in C
        for i in range(len(C)):
            for j in range(len(C[0])):
                C[i][j] = a[int(C[i][j]-1)]
        # turning the numbers to alphabet
        f3k = open(sys.argv[4],"w")
        C = "".join(["".join([str(i) for i in j]) for j in C])
        f3k.write(C)
        # writing it in a file
    B = []
    message = []
    def encoding():
        global r
        plain_input = "".join(f2i.read().upper().split("\n"))
        if plain_input == "":
            raise FileIsEmptyError
            # giving a fileisemptyerror if the input file is empty
        for i in plain_input:
            if i not in a:
                r = "input"
                raise InvalidCharacterInFileError
                # checking if the input file has invalid characters and if it has giving an error
        if len(plain_input)%len(key) != 0:
            plain_input = plain_input + (len(key)-len(plain_input)%len(key))*" "
            # if len(input) cannot divide by  len(key) we add input enough spaces to do it
        for i in range(len(key)):
            B.append(plain_input[i::len(key)])
            # making a list that will be converted
    
        for j in range(len(B[0])):
            C = []
            for i in range(len(B)):
                C.append(B[i][j])
            message.append(C)
        # message is transpose of B
        for i in message:
            for j in i:
                message[message.index(i)][i.index(j)] = a.index(j)+1
        # making message characters to numbers
        C = [[0 for i in range(len(message[0]))] for j in range(len(message))]
        # making a matrix to multiply matrixes
        for i in range(len(key)):
            for j in range(len(key[0])):
                for k in range(len(message)):
                    C[k][j] += key[j][i]*message[k][i]
                    # multiplying key by message.
        f3k = open(sys.argv[4],"w")
        c = ",".join([",".join([str(i) for i in j]) for j in C])
        f3k.write(c)
        # writing it in a file
        f3k.close()
    r = "Input"
    f2i = open(sys.argv[3],"r")
    if sys.argv[1] == "enc":
        encoding()
    if sys.argv[1] == "dec":
        invmatrix(),decoding()
    if sys.argv[1] not in ["enc","dec"]:
        raise UndefinedParameterError
    if sys.argv[3][-1:-5:-1] != "txt.":
        r = "The input"
        raise FileCouldNotBeReadError
    
        
except ParameterNumberError:
    print("Parameter number error"),sys.exit()
except UndefinedParameterError:
    print("Undefined parameter error"),sys.exit()
except FileCouldNotBeReadError:
    print(f"{r} file could not be read error"),sys.exit()
except FileNotFoundError:
    print(f"{r} file not found error"),sys.exit()
except FileIsEmptyError:
    print(f"{r} file is empty error"),sys.exit()
except InvalidCharacterInFileError:
    print(f"Invalid character in {r} file error"),sys.exit()
except ValueError:
    print("Invalid character in key file error")
    # giving errors
except ZeroDivisionError:
    key[counter],key[counter+1] = key[counter+1],key[counter]
    Ikey[counter],Ikey[counter+1] = Ikey[counter+1],Ikey[counter]
    invmatrix(),decoding()
    # if the key matrix has a 0 at the focus digonel, changing it with the down and trying it again