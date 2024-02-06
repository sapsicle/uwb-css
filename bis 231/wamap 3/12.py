import numpy as np

u = np.array([
    [-6, 3, -8, -1],
    [-4, 6, 8, -3],
    [4, -10, -2, 1]
])
v = np.array([
    [1, 7, -10],
    [10, 3, -5],
    [-2, -1, 4],
    [-8, 5, 6]
])

print(np.dot(u, v))