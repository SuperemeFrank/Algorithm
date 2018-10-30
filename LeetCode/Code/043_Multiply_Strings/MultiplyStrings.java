class Solution {
    public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
   
    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10; // we don't need to consider if p1 > 10 here, cause it will be handled afterward
            pos[p2] = (sum) % 10;
        }
    }  
    
    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
    }
}

/* Time: O(n ^ 2)  Space: O(n + m)

****the ith digit in num1 product the jth digit in num2 affect (i + j)th and (i + j + 1)th digits of the result

         1368
         912
        456 
     + --------
        56088
    
    the result of num1[i]  * num2[j] affects at most the (i + j)th digit of the result, and (i + j + 1)th.
*/


class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        } 
        
        StringBuilder res = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) { // the digit to multiply
            StringBuilder multiple = new StringBuilder();
            int mult1 = num1.charAt(i) - '0';
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mult2 = num2.charAt(j) - '0';
                int digit = (mult1 * mult2 + carry) % 10;
                carry = (mult1 * mult2 + carry) / 10;
                multiple.insert(0, digit);
            }
            if (carry != 0) {
                multiple.insert(0, carry);
                carry = 0;
            }
            for (int m = 0; m < num1.length() - 1 - i; m++) {
                multiple.append('0');  // get the result each multiply
            } 
            
            // add this multiply with the revious result
            StringBuilder reverse1 = multiple.reverse();
            StringBuilder reverse2 = res.reverse();
            int plusCarry = 0;
            for(int x = 0; x < reverse1.length(); x++) {
                if (x < reverse2.length()) {
                    int a = reverse1.charAt(x) - '0';
                    int b = reverse2.charAt(x) - '0';
                    int digit = (a + b + plusCarry) % 10;
                    plusCarry = (a + b + plusCarry) / 10;
                    reverse1.setCharAt(x, (char)(digit + '0'));
                } else {
                    int a = reverse1.charAt(x) - '0';
                    int digit = (a + plusCarry) % 10;
                    plusCarry = (a + plusCarry) / 10;
                    reverse1.setCharAt(x, (char)(digit + '0'));
                }
            }
            if (plusCarry != 0) {
                reverse1.append(plusCarry);
            }
            res = reverse1.reverse(); 
        }
        return res.toString();
    }
}
// 思路，正常的乘法做法
// Time: O(M * N + M * N) ~ O(M * N) M is the length of num1, N is the length of num2
//Space: O(M * N) ? StringBuilder Space



