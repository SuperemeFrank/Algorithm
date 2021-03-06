/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean endFile = false;
        int readBytes = 0;
        while (readBytes < n && !endFile) {
            int readCount = read4(buffer);
            if (readCount < 4)
                endFile = true;
            int length = Math.min(n - readBytes, readCount);
            for (int i = 0; i < length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }
}

// weired solution