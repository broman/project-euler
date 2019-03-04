#include <stdio.h>
#include <stdbool.h>
// FINALLY AN EASY ONE
// Find the sum of all the primes below two million.

#define limit 2000000
static int numArray[limit] = {0};

int main() {
	// Let's use the Sieve of Eratosthenes 
	int i;
	long long result = 2;
	int last_prime = 2; 
	bool prime_found = true;

	// 1. Populate an array of evey number up to your limit
	for (i = 1; i < limit; i+=2) numArray[i] =  i;

	// 2. Find a prime, then nullify all multiples of it (since they are by definition unprime)
	while (prime_found) {
		int j;
		prime_found = false;

		for (i = last_prime+1; i < limit; i++) {
			if (numArray[i] != 0) {
				last_prime = i; 
				result += i;
				prime_found = true;
				break;
			}
		}

		if (prime_found) {
			for ( j = 2; j < limit; j++ ) {
				if (j * last_prime > limit) break;
				numArray[j*last_prime] = 0;
			}
		}
	// 4. Rinse and repeat
	}
	printf("The sum of all primes below %d is %lld \n", limit, result);
	return 0;
}