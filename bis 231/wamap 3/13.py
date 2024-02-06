import numpy as np

B = np.array([
    [0, -1, -3],
    [-7, -5, -8]
])
A = np.array([
    [8, -6, -8],
    [5, -9, 7],
    [0, 6, -5]
])

print(np.dot(B, A.T))