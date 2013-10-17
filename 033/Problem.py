def gcd(a, b):
  return a if b == 0 else gcd(b, a % b) 
 
def normalize(fraction):
  nominator = fraction[0]
  denominator = fraction[1]
  g_c_d = gcd(nominator, denominator)
  return (nominator / g_c_d , denominator / g_c_d)

def areTheSame(fraction_1, fraction_2):
  return normalize(fraction_1) == normalize(fraction_2)

def doTheReduction(fraction):
  nom_0 = fraction[0] // 10
  nom_1 = fraction[0] % 10
  denom_0 = fraction[1] // 10
  denom_1 = fraction[1] % 10
  ret_list = []
  if nom_0 == nom_1 or denom_0 == denom_1 or nom_0 == 0 or nom_1 == 0 or denom_0 == 0 or denom_1 == 0 or (nom_0 == denom_0 and nom_1 == denom_1):
    return ret_list
  if nom_0 == denom_0:
    ret_list.append((nom_1, denom_1))
  if nom_0 == denom_1:
    ret_list.append((nom_1, denom_0))
  if nom_1 == denom_0:
    ret_list.append((nom_0, denom_1))
  if nom_1 == denom_1:
    ret_list.append((nom_0, denom_0))
  return ret_list


def isOk(fraction):
  forms = doTheReduction(fraction)
  return len(forms) != 0 and any(areTheSame(x, fraction) for x in forms)

def main():
  result = normalize(reduce(lambda x, y: (x[0] * y[0], x[1] * y[1]), [(a,b) for b in range(12, 100) for a in range(12, b) if isOk((a,b))]))[1]
  print result

main()
