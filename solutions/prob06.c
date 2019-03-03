#include <stdio.h>
#include <math.h>
// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

int sumOfSquares(int n) {
    int sum = 0;
    for(int i = 1; i <= n; i++)
        sum += i * i;
    return sum;
}

int squareOfSum(int n) {
    int sum = 0;
    for(int i = 1; i <= n; i++)
        sum += i;
    return sum * sum;
} 

int main() {
    printf("%d\n", squareOfSum(100) - sumOfSquares(100));
    return 0;
}