# Author: Daniel Foster
# Difficulty: Medium - solid medium, nothing unexpected.
# Needed: Strings, reversing.

for _ in range(int(input())):
    # Length of stream.
    l = int(input())
    
    # Stream to check.
    stream = input()
    
    # Stores each message.
    messages = []
    
    # Stream index we are checking.
    index = 0
    while index < l - 3:
        # Get current 3-letter token and its reverse.
        tok = stream[index:index+3]
        tokRev = tok[::-1]
        
        # Check if reverse occurs after original token.
        revIndex = stream.find(tokRev);
        if (revIndex > index + 3):
            # Get message between tokens.
            mess = stream[index+3:revIndex]
            
            # Take out double escape characters.
            letIndex = 0
            while letIndex < len(mess)-1: # While, because Python for doesn't recheck.
                # If this letter is in the token, take it out of message.
                if mess[letIndex] in tok:
                    mess = mess[:letIndex] + mess[letIndex+1:]
                letIndex += 1
            
            # Add message to list and set index after the end of it.
            messages.append(mess)
            index = revIndex + 3
            
        # Otherwise just move ahead by 1.
        else:
            index += 1
    
    # Result.
    print("\n".join(messages))
