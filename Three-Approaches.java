1)Brute Force Approach 
TC : O(N^2)
Code :
public class Solution {
    public int solve(int A) {
        int cnt = 0;
        // Looping from 1 to A
        for(int i=1 ; i<=A ; i++){
            int factors = 0;
            // Looping from 1 to i
            for(int j=1;j<=i;j++) {
                if(i%j==0){
                    factors++;
                }
            }
            if(factors==2) {
                cnt++;
            }
        }
        return cnt;
    }
}
2)Slighter Optimize Approach 
  TC : O(N * Sqrt(N)) 
  Code : 
public class Solution {
    public int solve(int A) {
        int count = 0;
        if(A == 1){
            return 0;
        }
        for(int i=2;i<=A;i++){
            int c = 0;
            for(int j=1;j*j<=i;j++){
                if(i % j == 0){
                    c+=2;
                }
            }
            if(c == 2){
                count = count + 1;
            }
        }
        if(count > 0){
            return count;
        }
        return 0;
    }
}
Note : Solving this question on leetcode will give you TLE, To avoid TLE we have one concept for counting primes within a range from 1 to N, i.e Sieve Of Eratosthenes.
3)Sieve Of Eratosthenes : 
Steps :
1)Assume all numbers from 2 to N are prime numbers.
2)Which numbers are completely divisible eliminate them.
3)Remaining numbers which are not divisible are prime numbers and return their count.
class Solution {
    public int countPrimes(int n) {
     boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i] == true){
              count++;
            for(int j=i*2;j<n;j=j+i){
                isPrime[j] = false;
            }   
            }
        }   
        return count;
    }
}
