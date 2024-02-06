import numpy as np

A = np.array([
    [-3, 0, -5],
    [4, 5, -1]
])
B = np.array([
    [-4, -2, -4, -3],
    [-2, -1, 4, -3],
    [1, -3, -3, -1]
])

# print(f"A + B: {A + B}")
# print(f"A - B: {A - B}")
print(f"4A: {4 * A}")
print(f"A * B: {np.dot(A, B)}")