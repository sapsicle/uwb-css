import numpy as np

D = np.array([
    [-2, 10, 3, 6, 4],
    [7, 5, -6, -9, -10],
    [8, 2, -4, 9, -3],
    [4, 3, 8, 9, 0],
    [5, -2, 1, -6, -8]
])

print(D + D.T)