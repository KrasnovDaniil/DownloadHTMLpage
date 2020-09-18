import numpy as np
import matplotlib.pyplot as plt

'''
Строки матрицы:
    Рост
    Вес
    Уровень глюкозы
    Метка

'''

M = 4
N = 100
selection = np.zeros(M * N).reshape(M, N)
# selection = np.zeros((M, N))
# selection[1] = (np.random.normal(250, 50, (N)))
# selection[2] = (np.random.normal(150, 20, (N)))

selection[1] = 50 + 220 * (np.random.rand(N))
selection[2] = 20 + 130 * (np.random.rand(N))
x = np.linspace(0, N, N)

print(selection[1], '\n')
print(selection[2])

# Displaying
height_koef = selection[1] / selection[2]
print(156./(0.9**2))
bm_idx = selection[2]/((selection[1]/100.)**2)
print(height_koef)
print(bm_idx)

fig, h_ax = plt.subplots()
# h_ax.plot(x, height_koef)
h_ax.hist(height_koef, bins=20)  # гистограмма коэффициента отношения роста к весу
h_ax.set_title('Height koef')

# plt.plot(x, selection[1], 'b')
# plt.subplot()
# plt.plot(x, selection[2], 'r')
plt.show()

# Cleaning Up
for i, j in zip(selection[1], selection[2]):
    pass