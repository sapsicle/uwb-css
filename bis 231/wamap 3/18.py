import numpy as np

A = np.array([
    [1, -2],
    [0, 2],
    [4, -1]
])

print(np.dot(A.T, A))