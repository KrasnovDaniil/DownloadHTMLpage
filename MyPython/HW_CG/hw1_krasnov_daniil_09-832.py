file = 'teapot.obj'


def run():
    countF = 0
    countV = 0
    with open(file, 'r') as read_file:
        for line in read_file:
            if line[0] == 'v':
                countV += 1
            elif line[0] == 'f':
                countF += 1
    print("Vertexes = ", countV)
    print("Faces    = ", countF)


run()
