def check_prime(n):
    s=0
    if n!=1:
        for i in range(2,n):
            s=s+1
            if n%i==0:
                return False,s
    else:
        False,s
    return True,s
print(check_prime(10),check_prime(13),check_prime(23))

def my_search(numbers,x):
    s=0
    for i in numbers:
        s=s+1
        if i==x:
            return True,s
    return False,s
numbers=[10,13,23,310,49]
x=310
print(my_search(numbers,x))

import random

def get_my_list(s):
    list_1=[]
    for i in range(s):
        t=int(random.uniform(0,1000))
        list_1.append(t)
    return list_1

def get_my_number():
    return int(random.uniform(0,1000))


def my_search_complexity(numOfItem=10,numOfTrials=5):

    my_list=get_my_list(numOfItem)
    print(my_list)

    print("liste boyutu : ",len(my_list))
    my_search_numbers=get_my_list(numOfTrials)
    t=0
    for i in my_search_numbers:
        t_1=my_search(my_list,i)[1]
        t=t+t_1
    a,b=t,t/len(my_search_numbers)
    print("ortalama değer : ",b)

my_search_complexity(50,25)