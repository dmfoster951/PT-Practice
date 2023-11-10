# Author: Daniel Foster
# Difficulty: Medium - standard use of dictionaries.
# Needed: Dictionaries.

# Test cases.
for _ in range(int(input())):
    # Maps arrival city to departure city.
    trips = {}

    # Read all boarding passes.
    for _ in range(int(input())):
        dep, arr = input().split()
        trips[arr] = dep
    
    # Find final destination.
    for s in trips:
        if s not in trips.values():
            last = s
            break
    
    # Loop back through passes until original is reached.
    print(last)
    while last in trips:
        last = trips[last]
        print(last)
