class Solution {
    public int calculate(String s) {
        if (s == null) {
            return -1;
        }
        Deque<String> dq = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) { // remove all the space
            if (s.charAt(i) != ' ') {
                str.append(s.charAt(i));
            }
        }
        int i = 0;
        int j = 0;
        boolean operate = false;
        while (j < str.length()) {

            if (j == str.length() - 1 || str.charAt(j) < '0' || str.charAt(j) > '9') {
                String num = j == str.length() - 1 ? str.substring(i, j + 1) : str.substring(i, j);
                i = j + 1;
                if (operate) {
                    String operation = dq.pollFirst();
                    String firstNum = dq.pollFirst();
                    String secondNum = num;
                    String res = calculateThree(firstNum, secondNum, operation);
                    dq.offerFirst(res);
                }else {
                    dq.offerFirst(num);
                }
                if (j == str.length() - 1) {
                    break;
                }
                dq.offerFirst(str.charAt(j) + "");
                if (str.charAt(j) == '/' || str.charAt(j) == '*') {
                    operate = true;
                }else {
                    operate = false;
                }
            }
            j++;
        }
        String res = dq.pollLast();
        while (!dq.isEmpty()) {
            String operation = dq.pollLast();
            String secondNum = dq.pollLast();
            res = calculateThree(res, secondNum, operation);
        }
        return Integer.valueOf(res);
    }

    public String calculateThree(String first, String second, String oper) {
        int firNum = Integer.valueOf(first);
        int secNum = Integer.valueOf(second);
        switch (oper){
            case "+" :
                return (firNum + secNum) + "";
            case "-" :
                return (firNum - secNum) + "";
            case "*" :
                return (firNum * secNum) + "";
            case "/" :
                return (firNum / secNum) + "";
        }
        return "";
    }
}

// Time: O(n)   Space: O(n)