import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-3, 3, 100)
y = x ** 2
z = x ** 3

# отображение графиков
plt.figure()
plt.plot(x, y, ':r')  # парабола
plt.plot(x, z, 'b')  # гипербола
# :r - пунктир
# r - красный цвет
# s - квадраты
# plt.show()

plt.figure()
plt.subplot(1, 2, 1)  # одна строчка, 2 графика, отрисовать первый
plt.plot(x, y)
plt.subplot(1, 2, 2)  # одна строчка, 2 графика, отрисовать второй
plt.plot(x, z)
# plt.show()

# ____________________________________________________________
N = 1024
img = np.zeros((N, N, 3), dtype=np.uint8)
img[200:700, 200:700] = np.array([0,255,0])
img = np.uint8(255*np.random.rand(N,N,3))
print(img[0,0]) # триплет пикселя
plt.figure()
plt.imshow(img, cmap='gray') #cmap - палитра
plt.show()

# plt.imsave('simple_image.png', img) # сохранение изображения в папке с кодом
