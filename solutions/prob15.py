# Look how easy this is :^)
def lattice_paths(n, k):
    return factorial(n) / (factorial(n - k) * factorial(k))

def factorial(n):
    if n == 0: return 1
    return n * factorial(n - 1)
print(lattice_paths(40, 20))
