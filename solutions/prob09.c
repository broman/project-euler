#include <stdio.h>
#include <math.h>
#include <stdbool.h>
/*
* There exists exactly one Pythagorean triplet for which a + b + c = 1000.
* Find the product abc.

Did quite a bit of Googling for this one...

This seems pretty straightforward, but it is... not.
a Pythagorean triplet is a set of three integers such that:
* a^2 + b^2 = c^2

The problem describes but does not explicitly state that the solution is a *primitive* triplet
This means our new constraints are:
* a^2 + b^2 = c^2
* a < b < c
* Exactly one of {a, b, c} is even
* a, b, and c are coprime, meaning gcd({a, b, c}) -> 1


The Euclidian forumula allows us to generate Pythagorean triplets:
* For natural numbers m and n, values {a, b, c} are a primitive Pythagorean triplet if and only if:
* a = m^2 - n^2
* b = 2m * n
* c = m^2 + n^2
We can rewrite our original equation such that it must now satisfy the following:
* (m^2 - n^2)^2 + (2m * n) = (m^2 + n^2)^2
* m^2 - n^2 + 2mn + m^2 + n^2 = 1000
** Solving for n in terms of m:
** n = (500 - m^2) / m
NOTE: We can terminate the loop early if f(n) results in a noninteger.
We're only interested in positive integers. Considering n = 0:
* 0 = (500 - m^2) / m
n will be negative if abs(m) > sqrt(500). Since sqrt(500) ≈ 22.4, m <= 22.
So we've dropped down from our original Euledian equation's sample space down to:
n < m <= 22

We've finally done it!
*/

int main() {
    int a = 0, b = 0, c = 0;
    int n = 0, m = 22; 
    int target = 500;
    bool found = false;

    while (!found) {
        int divides = (target - m * m) % m;
        if (!divides) {
            int a2, b2, c2; 
            n = (target - m * m) / m;
            if ( m < n ) break;
            // Euclidian formula
            a = m * m - n * n;
            b = 2 * m * n;
            c = m * m + n * n;

            a2 = a * a;
            b2 = b * b;
            c2 = c * c;

            if ((a2 + b2) == c2) found = true;
        }
        m--; 
    }
    printf("a = %d, b = %d, c = %d\n", a, b, c);
    printf("abc = %d\n", a * b * c);
    return 1;
}