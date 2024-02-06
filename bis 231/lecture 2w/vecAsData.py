import numpy as np
import pandas as pd

# X = np.array([[1, 1], [1,0], [0, 2], [2, 4], [3, 5]]) # This is an ndarray. Mathematically it's a matrix but we won't learn about matrices until week 4.
# print(X)

df = pd.read_csv("data_example1.csv")
df.head()

Y = df.to_numpy() # Uses the to_numpy() method available to Pandas dataframes to convert df to a ndarray.
print(Y)
type(Y)

v = np.array([[-2],[4],[-9], [2]])
# What does v.shape[0] return and why?
print(v.shape[0])

# indexing and slicing
# bottom bound inclusive, upper bound exclusive
# Y[0:4,1:3]
# makes a 2x4 table

def fun1(word):
    if word[2] == 'a':
        return 1
    else:
        return 0
# or
# def fun1(word):
#     return 1 if word[2] == 'a' else 0
# for ternary

def fun2(a):
    a = 1.5 if a > 1 else 100 if a == 1 else 0
# ternary for
# def fun2(a):
#     if a > 1:
#         a = 1.5
#     elif a == 1:
#         a = 100
#     else:
#         a = 0