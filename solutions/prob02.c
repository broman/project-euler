#include <stdio.h>

int findFib(int in) {
    // finds the sum of the even fibonacci numbers <= in
    int out = 0;
    int a = 0;
    int b = 1;
    while(a <= in) {
        if(a % 2 == 0)
            out += a;
        int c = a + b;
        a = b;
        b = c;
    }
    return out;
}

int main() {
    printf("%d\n", findFib(4000000));
    return 0;
}