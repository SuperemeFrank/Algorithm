class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }else if (n > 0) {
            return pow(x, n);
        }else {
            return 1.0/pow(x,n); // if n is Integer.MIN_VAULE we cannot use n * -1 here
        }
        
    }
    
    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = pow(x, n/2);
        if (n % 2 == 0) {
            return y * y;
        }else {
            return y * y * x; // n % 2 could be 1 or -1 here
        }
    }
}

//use binary idea