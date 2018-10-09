class Solution {
    final String[] LESS_THAN_20 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
                                      "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", 
                                      "Eighteen ", "Nineteen "};
    final String[] TENS = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    final String[] THOUSANDS = {"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        
        
        if (num == 0) return "Zero";
        String res = "";
        int i = 0;
        
        while (num != 0) {
            if (num % 1000 != 0) {
                res = thousHelper(num % 1000) + THOUSANDS[i] + res;
            }
            num /= 1000;
            i++;
        }
        res = res.trim();
        return res;
    }
    
    private String thousHelper(int num) { // num is smaller than 1000
        if (num < 20) {
            return LESS_THAN_20[num];
        }else if (num < 100) {
            return TENS[num / 10] + thousHelper(num % 10);
        }else {
            return LESS_THAN_20[num / 100] + "Hundred " + thousHelper(num % 100);
        }
    }
}


/*  Time: O(n)  Space: O(1)   n is the digits of the num
    each 1000 there are a new title for thatn like million, thousand
    
    442, 231    4 hundred forty five thousand, 2 hundred thirty one
    
    if we treat 'thousand' as a separator, left and right could be treat as the same
    
    note that in englist, the names of 0 - 19 are unique, after 20 - 99 are the same format (xty y,  twenty one)

*/