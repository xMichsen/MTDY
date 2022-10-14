def iloraz_roznicowy(fx,x,k,i):
    if k-i == 1: return (fx[k]-fx[i])/(x[k]-x[i])
    else: return (iloraz_roznicowy(fx,x,k,i+1) - iloraz_roznicowy(fx,x,k-1,i))/(x[k]-x[i])

def inter_newton(fx,x):
    n = len(x)
    x_input = (float)(input("Podaj x:"))

    wynik2 = 0
    for k in range(1,n):
        wynik = 1
        for j in range(k):
            wynik *= (x_input-x[j])
        wynik2 +=  wynik * iloraz_roznicowy(fx,x,k,0)
    return wynik2+fx[0]

x = [-4,-2,0,2,4]
fx= [-734,-66,2,-2,-318]

print(inter_newton(fx,x))
