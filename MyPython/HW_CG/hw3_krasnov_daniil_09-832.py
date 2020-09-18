import numpy as np

file = 'teapot.obj'


def run():
    vs = [[0, 0, 0]]
    total_area = 0
    with open(file, 'r') as read_file:
        for line in read_file:
            if line[0] == 'v':
                line = line.split()[1:]
                vs.append([float(i) for i in line])
            else:
                break

        vs = list(map(np.array, vs))
        for line in read_file:
            points = line.split()[1:]
            points = [int(i) for i in points]
            total_area += findTriangle(vs[points[0]], vs[points[1]], vs[points[2]])
        return total_area


def findTriangle(p1, p2, p3):
    # calculate using Gerone's formula
    d1 = np.linalg.norm(p1 - p2)
    d2 = np.linalg.norm(p1 - p3)
    d3 = np.linalg.norm(p2 - p3)
    p = (d1 + d2 + d3) / 2
    return (p * (p - d1) * (p - d2) * (p - d3)) ** (1 / 2)


print("Total area of teapot: ", run())
