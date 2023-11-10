# Author: Daniel Foster
# Difficulty: Medium - okay if you know dictionaries and recursion.
# Needed: Dictionaries, recursion.

# Maps category to list of products under it.
hier = {}

# Print hierarchy correctly.
def printHier(parent, depth):
    # Go through each product under parent category.
    for p in hier[parent]:
        # Print the product.
        print(("-" * depth) + p)

        # If parent is its own category, recurse.
        if p in hier:
            printHier(p, depth + 1)

# Number of products instead of test cases.
for _ in range(int(input())):
    # Get product and its parent.
    prod, parent = input().split(',')

    # Add parent to the hierarchy. 
    if parent not in hier:
        hier[parent] = [prod]
    # Or add product to existing list for parent.
    else:
        hier[parent].append(prod)
        hier[parent].sort()

# Result.
printHier("None", 0)
