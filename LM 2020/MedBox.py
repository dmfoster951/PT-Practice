# Author: Daniel Foster
# Difficulty: See MedBox.java
# Needed: Splitting, lists, rstrip.

for _ in range(int(input())):
    # Width and height.
    w, h = map(int, input().split())
    
    
    # Get list of words.
    words = input().split()
    
    # Tracks how many words we've fit in the box.
    cur = 0
    
    # Final box.
    box = ""
    
    # Stop once we hit height limit
    for _ in range(h):
        # Number of words on current line.
        count = 0
        
        # Add another word to the box if it can fit on that line.
        while cur < len(words) and count + len(words[cur]) <= w:
            box += words[cur] + " "
            count += len(words[cur]) + 1
            cur += 1
        
        # Take out trailing space and add newline.
        box = box.rstrip() + "\n"
    
    # Take out extra newline.
    box = box.rstrip()
    
    # Check if I actually fit all the words in the box.
    if cur < len(words):
        print("WILL NOT FIT")
    else:
        print(box)
