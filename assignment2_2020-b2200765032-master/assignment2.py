# -*- coding: utf-8 -*-
"""
Created on Tue Nov 24 15:12:23 2020

@author: Görkem Kola
"""


area = input("Please enter the feeding map as a list: \n").replace("], ","]\n").replace("[","").replace("]","").replace("'","").replace(",","").strip(" ").split("\n")
directions = input("Please enter direction of movements as a list: \n").replace("[","").replace("]","").replace(","," ").replace("'","")
score = 0
#Here, the program takes inputs and deletes non-essantial characters.

print("Your board is:   ")
for i in area: print(i)
#Prints the first version of the map.

def scores():
    global newplace, score
    if newplace == "C": score += 10
    elif newplace == "A": score += 5
    elif newplace == "M": score -= 5
    #Here I created a function to calculate the score more easily.

for i in area:
    for j in i: 
        if j == "*": vertical, horizontal = area.index(i), i.index("*")  
        #In this loop, the program finds where the rabbit is.           
    
area[vertical] = list(area[vertical])
#the program turns area[vertical] to the list because program cannot changes characters in the string.            

for k in directions:
    if k == "U" and vertical > 0:
        area[vertical-1] = list(area[vertical-1])
        newplace = area[vertical-1][horizontal]
        if newplace != "W": 
            area[vertical-1][horizontal], area[vertical][horizontal] = "*", "X"
            vertical -= 1
            scores()
            if newplace == "P": break
        #Here, the loop looks directions and if it finds "U", it looks for if the rabbit can go upward.
        
    elif k == "D" and vertical < len(area)-1:
            area[vertical+1] = list(area[vertical+1])
            newplace = area[vertical+1][horizontal]
            if newplace != "W":
                area[vertical+1][horizontal], area[vertical][horizontal] = "*", "X"
                vertical += 1
            scores()
            if newplace == "P": break
        #Here, the loop looks directions and if it finds "D", it looks for if the rabbit can go downward.
        
    elif k == "L" and horizontal > 0:
        newplace = area[vertical][horizontal - 2]
        if newplace != "W":
            area[vertical][horizontal-2], area[vertical][horizontal] = "*", "X"
            horizontal -= 2
            scores()
            if newplace == "P": break
        #Here, the loop looks directions and if it finds "L", it looks for if the rabbit can go left.
        
    elif k == "R"and horizontal < len(i)-2:
        area[vertical] = list(area[vertical])
        newplace = area[vertical][horizontal+2]
        if newplace != "W":
            area[vertical][horizontal+2], area[vertical][horizontal] = "*", "X"
            horizontal += 2
            scores()
            if newplace == "P": break    
        #Here, the loop looks directions and if it finds "R", it looks for if the rabbit can go right.
        
print("Your output should be like this:     ")
for i in area: print("".join(i))
print("Your score is:",score)
#Prints the last version of the map and score.