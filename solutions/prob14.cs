using System; 
using System.Collections.Generic;
/*
Given the following composite function:
f(n) -> n/2 (n is even)
f(n) -> 3n + 1 (n is odd)
Continue the function until f(n) = 1.

Find the value of n under 1000000 that produces the longest chain.
*/
namespace euler {
    class prob14 {
        static void Main(string[] args) {
            new prob14().Problem14();
        }
        public void Problem14() {
            int largestChainLength = 0;
            int largestChainNumber = 0;
            List<long> largestChain = null;
            for(int i = 0; i < 1000000; i++) {
                List<long> chain;
                chain = GenerateChain(i);
                int length = chain.Count;
                if(length > largestChainLength) {
                    largestChainLength = length;
                    largestChainNumber = i;
                    largestChain = chain;
                }
            }
            foreach(int j in largestChain) {
                Console.Write($"{j} -> ");
            }
            Console.WriteLine($"\n\nThe value {largestChainNumber} had a {largestChainLength} long chain.");
        }
        static List<long> GenerateChain(long n) {
            // Generates a Collatz Problem chain given the starting value n.
            var chain = new List<long>{n};
            while(n > 1) {
                bool even = n % 2 == 0;
                n = even ? n/2 : 3*n+1;
                chain.Add(n);
            }
            return chain;
        }
    }
}