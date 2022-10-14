import math


def roznica_progresywna(fx,x,k,i):
    if k-i == 1: return (fx[k]-fx[i])
    else: return (roznica_progresywna(fx,x,k,i+1) - roznica_progresywna(fx,x,k-1,i))

def inter_newton(fx,x):
    h = None
    dif = []
    for i in range(len(x)-1):
        dif.append(x[i+1] - x[i])
    for i in range(len(dif)-1):
        if dif[i] != dif[i+1]:
            return "Roznica miedzy punktami rozna"

    h = dif[i]
    print(h)
    n = len(x)
    x_input = (float)(input("Podaj x:"))

    wynik2 = 0
    for k in range(1,n):
        wynik = 1
        for j in range(k):
            wynik *= (x_input-x[j])
        wynik2 +=  wynik * roznica_progresywna(fx,x,k,0)/(math.factorial(k)*h**k)
    return wynik2+fx[0]

x = [-4,-2,0,2,4]
fx= [-734,-66,2,-2,-318]

print(inter_newton(fx,x))

