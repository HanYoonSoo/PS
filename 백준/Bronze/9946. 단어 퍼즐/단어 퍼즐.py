cnt=1
while 1:
    a=input()
    b=input()
    if a=='END' and b=='END' :break
    tmpa,tmpb=[0]*26, [0]*26
    for i in a: tmpa[ord(i)-97]+=1
    for i in b: tmpb[ord(i) - 97] += 1
    if tmpa==tmpb: print("Case %d: same"%cnt)
    else: print("Case %d: different"%cnt)
    cnt+=1
