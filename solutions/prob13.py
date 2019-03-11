# Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
# This is done easiest in Python, mainly because of I don't have to give a shit about integer sizes

with open("prob13.txt", "r") as f:
    array = f.readlines()
array = [int(f) for f in array] # f
total = sum(array) # Wow, that was easy!

print(str(total)[:10])

# real    0m0.060s
# user    0m0.034s
# sys     0m0.016s

# Not that bad, could be better