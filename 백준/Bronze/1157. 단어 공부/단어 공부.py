str = input()
lower_str = str.lower()

alphabet = list(range(97,123))
max = 0
maxc = ''
count = 0

for c in alphabet:
  for s in lower_str:
    if s == chr(c):
      count += 1
  
  if count>0 and max == count:
    maxc = '?'
  if max < count:
    max = count
    maxc = chr(c)
    
  count = 0

print(maxc.upper())