import time

def gcd(a, b):
  return a if b == 0 else gcd(b, a % b) 
 
def normalize(fraction):
  nominator = fraction[0]
  denominator = fraction[1]
  g_c_d = gcd(nominator, denominator)
  return (nominator / g_c_d , denominator / g_c_d)

def minus(fraction1, fraction2):
  return normalize((fraction1[0] * fraction2[1] - fraction2[0] * fraction1[1], fraction1[1] * fraction2[1]))

def areTheSame(fraction_1, fraction_2):
  return normalize(fraction_1) == normalize(fraction_2)

def main():
  start = time.time()
  
  d = 10**6
  atom = (1, d)
  result = (3, 7)
  while True:
    if (minus(result, atom)[1] <= d):
      break
    else:
      atom = (1, atom[1] - 1)
  print minus(result, atom)[0]

  end = time.time()
  print str((end - start) * 1000) + "ms"

main()
