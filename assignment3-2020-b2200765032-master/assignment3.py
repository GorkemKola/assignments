# -*- coding: utf-8 -*-
"""
Created on Sun Dec  6 02:16:04 2020

@author: Görkem Kola
"""

# takes the input.txt through terminal
import sys
f = open(sys.argv[1], "r")
commands = f.read().split("\n")
# Adds the input.txt to commands and splits
f.close()
# Closes input.txt
def init():
    # Creates the board and pieces as a list and when the function called it returns the initialize position.
    global board
    board = [["R1", "N1", "B1", "QU", "KI", "B2", "N2", "R2"], ["P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8"],
             ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "], ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
             ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "], ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
             ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"], ["r1", "n1", "b1", "qu", "ki", "b2", "n2", "r2"]]
init()
coords = [["a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"], ["a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"],
          ["a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"], ["a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"],
          ["a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"], ["a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"],
          ["a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"], ["a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"]]
# Creates board coordinates as a list
bp = ["P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "R1", "N1", "B1", "QU", "B2", "N2", "R2"]
wp = ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "r1", "n1", "b1", "qu", "b2", "n2", "r2"]
# Defines the pieces what color has they except for kings, because they cannot be eaten


# Defines showmoves function
def showmoves():
    global moves, y
    moves, y = "", 0
    # Defines "moves" is string that will be using
    while y < 8 and command[1] not in board[y]: y += 1
    # Finds the piece's vertical position which is in the command's second index (command[1])
    if y == 8: return "FAILED"
    # If the piece which is given is not in the board it returns FAILED and continues the next line

    def mv(a, b, m, n):
        u, r = y, board[y].index(command[1])
        # Defines 2 variable to find the places that the piece can move freely
        global moves
        # If the piece can move in the same line program finds where it can go
        if command[1] in ["QU", "qu", "r1", "r2", "R1", "R2", "b1", "b2", "B1", "B2"]:
            while u in range(int(abs(m/2)-m/2),8-(int(abs(m/2)+m/2))) and r in range(int(abs(n/2)-n/2),8-(int(abs(n/2)+n/2))) and board[u+m][r+n] == "  ":  moves, u, r = moves + coords[u+m][r+n] + " ", u+m, r+n           
            # I found a range by using mathematics not to program's gives Index Error.
        if u in range(int(abs(m/2)-m/2),8-(int(abs(m/2)+m/2))) and r in range(int(abs(n/2)-n/2),8-(int(abs(n/2)+n/2))) and (board[u+m][r+n] in a or board[u+m][r+n] in b): moves = moves + coords[u+m][r+n] + " "       
        # If the piece can move 1 step too the program finds it. Just this code line is available for kings, knights and pawns.
      
    if command[1] in ["P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8"]:  mv(wp,"  ", 1, 0)
    elif command[1] in ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"]:  mv(bp,"  ", -1, 0)
    # Pawns' moves
    elif command[1] in ["R1", "R2"]: mv(wp,wp,-1,0), mv(wp,wp,1,0), mv(wp,wp,0,1), mv(wp,wp,0,-1)
    elif command[1] in ["r1", "r2"]: mv(bp,bp,-1,0), mv(bp,bp,1,0), mv(bp,bp,0,1), mv(bp,bp,0,-1)
    # Rooks' moves
    elif command[1] in ["B1", "B2"]: mv(wp,wp, 1,1), mv(wp,wp, 1,-1)
    elif command[1] in ["b1", "b2"]: mv(bp,bp, -1,-1),mv(bp,bp, -1,1)
    # Bishops' moves
    elif command[1] in ["N1", "N2"]: mv(wp,"  ",1,2), mv(wp,"  ",-1,2), mv(wp,"  ",2,1), mv(wp,"  ",2,-1), mv(wp,"  ",1,-2), mv(wp,"  ",-1,-2), mv(wp,"  ",-2,1), mv(wp,"  ",-2,-1), mv("  ","  ",1,1), mv("  ","  ",1,-1), mv("  ","  ",-1,1), mv("  ","  ",-1,-1)
    elif command[1] in ["n1", "n2"]: mv(bp,"  ",1,2), mv(bp,"  ",-1,2), mv(bp,"  ",2,1), mv(bp,"  ",2,-1), mv(bp,"  ",1,-2), mv(bp,"  ",-1,-2), mv(bp,"  ",-2,1), mv(bp,"  ",-2,-1), mv("  ","  ",1,1), mv("  ","  ",1,-1), mv("  ","  ",-1,1), mv("  ","  ",-1,-1)
    # Knights' moves
    elif command[1] == "KI":         mv(wp,"  ",1,1), mv(wp,"  ",1,-1), mv(wp,"  ",-1,1), mv(wp,"  ",-1,-1), mv(wp,"  ", 1, 0), mv(wp,"  ", -1, 0), mv(wp,"  ", 0, 1), mv(wp,"  ", 0, -1)
    elif command[1] == "ki":         mv(bp,"  ",1,1), mv(bp,"  ",1,-1), mv(bp,"  ",-1,1), mv(bp,"  ",-1,-1), mv(bp,"  ", 1, 0), mv(bp,"  ", -1, 0), mv(bp,"  ", 0, 1), mv(bp,"  ", 0, -1)
    # Kings' moves
    elif command[1] == "QU":         mv(wp,wp,1,0), mv(wp,wp,-1,0),mv(wp,wp,0,1), mv(wp,wp,0,-1), mv(wp,wp, 1,1), mv(wp,wp, 1,-1), mv(wp,wp, -1,1), mv(wp,wp, -1,-1)
    elif command[1] == "qu":         mv(bp,bp,1,0), mv(bp,bp,-1,0),mv(bp,bp,0,1), mv(bp,bp,0,-1), mv(bp,bp, 1,1), mv(bp,bp, 1,-1), mv(bp,bp, -1,1), mv(bp,bp, -1,-1)
    # Queens' moves 
        
    if moves == "": return "FAILED"
    # If moves is empty, returns failed
    return " ".join(sorted(moves.split(" "))).strip(" ")

# Defining a function to replace
def move():
    if command[2] in moves.split(" "): u = 0
    # checks if the place where wants to piece to go is in the moves
    else:  return "FAILED"
    while command[2] not in coords[u]: u += 1
    # Finds the place's vertical position that will the piece go
    board[y][board[y].index(command[1])], board[u][coords[u].index(command[2])] = "  ", command[1]
    # Replace the places which is the piece is in and the piece will be in
    return "OK"
for command in commands:
    # command is traveling each line one by one
    print(">",command)
    # Shows the command at the screen
    command = command.split(" ") 
    # Command split word by word
    if command[0] == "initialize": print("OK\n----------------------"), init(), [print(" ".join(i)) for i in board],print("-----------------------")
    # If the command is initialize it prints OK and the initialize board will be our new board and prints the board.
    elif command[0] == "print":print("-----------------------"), [print(" ".join(i)) for i in board], print("-----------------------")
    # Prints the board
    elif command[0] == "exit": sys.exit()
    # Exits the program
    elif command[0] == "showmoves": print(showmoves())
    # Shows the places where the piece can go with showmoves() function
    elif command[0] == "move": showmoves(), print(move())
    # Finds the places where the piece can go and if the position where wants to go is in it replace the piece and shows the new board.