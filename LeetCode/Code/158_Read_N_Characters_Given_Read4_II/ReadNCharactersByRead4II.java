/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    int buffPtr = 0;
    int buffCnt = 0;
    char[] buff = new char[4];
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0)
                buffCnt = read4(buff);
            if (buffCnt == 0) break;
            
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            
            if (buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }
}
/*
    The key difficulty is that we need to track the data we previously read.
    Here we use buffPtr and buffCnt (cause the previous reading is not exactly 4 bytes) to track the previous data
*/