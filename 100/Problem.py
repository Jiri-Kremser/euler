# thx 2 http://www.alpertron.com.ar/QUAD.HTM
x, y, limit = 85, 120, 1000000000000
while y < limit:
    x, y = 3 * x + 2 * y - 2, 4 * x + 3 * y - 3
print x,y
