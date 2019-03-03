#include <stdio.h>
#include <math.h>
#include <stdbool.h>
// What is the largest prime factor of the number 600851475143 ?

bool isPrime(int in) {
    for(int i = 2; i < in; i++)
        if(in % i == 0) // if any number divides evenly, it is not prime
            return false;
    return true;
}

int largestPrimeFactorOf(long in) {
    // check factor first, then check prime
    int largest_prime;
    for(int i = 1; i < sqrt(in); i++) {
        if(in % i != 0) continue; // dont need to check if its prime if its not a factor
        if(isPrime(i)) largest_prime = i;
    }
    return largest_prime;
}

int main() {
    printf("%d\n", largestPrimeFactorOf(600851475143));
    return 0;
}