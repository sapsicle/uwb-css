import numpy as np

u = np.array([
    [10, -7, 0],
    [1, 5, 4],
    [2, 9, -4]
])
v = np.array([
    [1, 0, 0],
    [0, 1, 0],
    [0, 0, 1]
])

print(np.dot(u, v))