tc = int(input())
for i in range(tc):
    x, y = input().split()
    x = int(x)
    y = int(y)
    d = y-x
    s = 0
    k = 0
    g = 1
    L = []
    while True:
        if k == 0 :
            s = s + g
            L.append(g)
            k = 1
        elif k == 1 :
            s = s + g
            L.append(g)
            g = g + 1
            k = 0
        if d > s :
            continue
        elif d <= s :

            break
    print(len(L))
