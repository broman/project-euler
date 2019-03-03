#include <stdio.h>

int reverse(int in) { 
    // reverses an int
    int reverse = 0; 
    while(in > 0) { 
        reverse = reverse * 10 + in % 10; 
        in /= 10; 
    } 
    return reverse; 
} 

int largestPalidrome() {
    // finds the largest palindome made from the product of two 3-digit numbers
    int largest;
    for(int i = 0; i <= 999; i++)
        for(int j = 0; j <= 999; j++) {
            int prod = i * j;
            if(reverse(prod) == prod)
                if(prod > largest)
                    largest = prod;
        }
    return largest;
}

int main() {
    printf("%d\n", largestPalidrome());
    return 0;
}