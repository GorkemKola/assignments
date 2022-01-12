print("THE ROOT OF SECOND ORDER EQUATION")
a = float(input("enter the cofficient of x²:    "))
b = float(input("enter the cofficient of x¹:    "))
c = float(input("enter the cofficient of x⁰:    "))
Δ = b**2-4*a*c
m = int(a)
n = int(b)
k = int(c)
if a%m ==0 and b%n == 0 and c%k == 0:
    print(str(m)+"x² +"+str(n)+"x +"+str(k))
elif a%m != 0 and b%n == 0 and c%k == 0:
    print(str(a)+"x² +"+str(n)+"x +"+str(k))
elif a%m == 0 and b%n != 0 and c%k == 0:
    print(str(m)+"x² +"+str(b)+"x +"+str(k))
elif a%m == 0 and b%n == 0 and c%k != 0:
    print(str(m)+"x² +"+str(n)+"x +"+str(c))
elif a%m != 0 and b%n != 0 and c%k == 0:
    print(str(a)+"x² +"+str(b)+"x +"+str(k))
elif a%m != 0 and b%n == 0 and c%k != 0:
    print(str(a)+"x² +"+str(n)+"x +"+str(c))
elif a%m == 0 and b%n != 0 and c%k != 0:
    print(str(m)+"x² +"+str(b)+"x +"+str(c))
elif a%m != 0 and b%n != 0 and c%k != 0:
    print(str(a)+"x² +"+str(b)+"x +"+str(c))
if Δ > 0:
    print("the first root of equation is:    ", (-b+Δ**0.5)/2*a)
    print("the second root of equaiton is:    ", (-b-Δ**0.5)/2*a)
elif Δ == 0:
    print("the root of equation is    ", -b/2*a)
else:
    print("this equation has no root that is a real number")