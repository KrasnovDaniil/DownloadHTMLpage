file = 'teapot.obj'


def run():
    maxX = maxY = maxZ = -100
    minX = minY = minZ = 100
    with open(file, 'r') as read_file:
        for line in read_file:
            if line[0] == 'v':
                string = line.split()
                maxX = max(maxX, float(string[1]))
                minX = min(minX, float(string[1]))

                maxY = max(maxY, float(string[2]))
                minY = min(minY, float(string[2]))

                maxZ = max(maxZ, float(string[3]))
                minZ = min(minZ, float(string[3]))
        print("max X = ", "%.6f" % maxX)
        print("max Y = ", "%.6f" % maxY)
        print("max Z = ", "%.6f" % maxZ, '\n')

        print("min X = ", "%.6f" % minX)
        print("min Y = ", "%.6f" % minY)
        print("min Z = ", "%.6f" % minZ)

run()
