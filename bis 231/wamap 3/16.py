import numpy as np

u = np.array([
    [1, -1, -1],
    [1, -1, 1],
    [-1, -1, -1]
])
v = np.array([
    [0],
    [0],
    [1]
])

print(np.dot(u, v))