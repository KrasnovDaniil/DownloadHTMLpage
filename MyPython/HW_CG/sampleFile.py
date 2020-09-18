import numpy as np

'''
np.int32
np.int16
np.int64
np.uint8

вещественные типы
np.float32
np.float64

комплескные числа
np.complex128
np.complex256 (мб его нет)

булевский тип
np.bool

___________________________________________
'''
# Создание массива:
# из списка
a = [1, 2, 3]
ar = np.array(a)
print(ar.shape)  # измерение = 3
print(ar.size)  # общее кол-во эл-тов

b = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
br = np.array(b, dtype=np.float64)
print(br.shape)

# ___________________________________________

c = np.linspace(0, 1, 100)  # 0, 1/100, 2/100, ..., 99/100, 1
print(c)
d = np.arange(10, 20, 2)  # 10, 12, ..., 18, 20
e = np.zeros((10, 10))  # 0, 0, 0,..., 0 dim = 10x10
f = 20 * np.ones((10, 10))  # 20, 20,...,20 dim = 10x10
g = np.random.rand(10, 10)  # равномерное распределение
print(np.mean(g))  # матожидание = 1/2
print(np.var(g))  # дисперсия = (b-a)^2/12

h = np.random.randn(10, 10)  # нормальное распределение
# ____________________________________________________
np.std(g)  # стандартное отклонение
np.median(g)  # медиана

m = e * f  # поэлементное умножение
m2 = np.dot(g, h)  # матричное умножение
m3 = g @ h

# ______________________________________________________

h[5]  # обращение к 5-ой строке
h[5, :]  # аналогично

h[:, 6]  # обращение к 5-му столбцу
h[2:8]  # со 2 по 8 строку
h[2:8:2]  # с 2 по 8 с шагом 2 строчки (правая граница не включительна)

h[::-1]  # развернуть массив

h[2:8:2, 3:9:3]  # массив на пересечении соотв. строк и столбцов

# _____________________________________________________________

# формируеся массив true/false там, где чисело < 0
ind = (h < 0)
h[ind] = 0

# _____________________________________________________________
# соединение 2мерных массивов
v = np.hstack([g, h])  # по горизонтали
q = np.vstack([g, h])  # по вертикали

# переопределение размерности массива
r = np.arange(20)
w = np.reshape(r, (4, 5))
