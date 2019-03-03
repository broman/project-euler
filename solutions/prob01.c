#include <stdio.h>

int findNat(int in) {
    int out = 0;
    for(int i = 0; i < in; i++)
        if(i % 3 == 0 || i % 5 == 0)
            out += i;
    return out;
}

int main() {
    printf("%u\n", findNat(1000));
    return 0;
}

// and in python... sum([i for i in range(1000) if i%3==0 or i%5==0])
// python one liners > all