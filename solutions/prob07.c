#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>

bool isPrime(int n) {
	// only halfway naive, you can iterate up o sqrt(n) for the same result
	for(int i = 2; i < (int) (sqrt(n) + 1); ++i)
		if(n % i == 0) return false;
	return true;
}

int nthPrime(int n) {
	// calculate the nth prime in the series of primes
	int candidate, count;
	for(candidate = 2, count = 0; count < n; ++candidate)
		if(isPrime(candidate)) ++count;
	return candidate - 1;
}

int getNthPrime(int n) {
    // this prints a list of primes up to N, not actually the Nth prime.......... fuck
	int primes[n];
	int i,j;

	for(i=2;i<n;i++) primes[i] = 1;		
	for(i = 2; i < n; i++) {
		for(j = i; i * j < n; j++){
			primes[i * j] = 0;
		}
	}	
	for(i = 2; i < n; i++) {
		if(primes[i]) {
			printf("%d\n",i);
		}
	}
	return 0;
	
}

int main() {
    printf("%d\n", nthPrime(10001));
    return 0;
}