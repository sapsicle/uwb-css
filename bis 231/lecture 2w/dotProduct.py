import numpy as np

u = np.array([[4],[-2],[3]])
v = np.array([[-2],[0],[1]])

u_v_dot = np.dot(u.T,v)
print(u_v_dot)