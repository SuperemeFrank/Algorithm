import java.util.*;
public class EncodeDecodeStrings {

	public static void main(String[] args) {
		Codec cd = new Codec();
		List<String> strs = new ArrayList<>();
		strs.add("012312sada");
		System.out.println(cd.encode(strs));
	}
}

class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder ret = new StringBuilder();
        for (String str : strs) {
            ret.append(str.length()).append("/").append(str);
        }
        return ret.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> ret = new ArrayList<>();
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + 1 + size;
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));