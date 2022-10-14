def Lagrange(n,x,y):
    x_input = (float)(input("Podaj x:"))
    W = 0
    L=1
    for i in range(n):
        L=1
        for j in range(n):
            if i != j:
                L = L * ((x_input-x[j])/(x[i]-x[j]))

        W = W + (L * y[i])
    return W

n = 5 # liczba zadanych punktów
x = [-4,-2,0,2,4] # tablica przechowująca zmienne x
y = [-734,-66,2,-2,-318] # tablica przechowująca wartości dla zmiennych x y[0] to wartość dla x[0]
print(Lagrange(n,x,y))
