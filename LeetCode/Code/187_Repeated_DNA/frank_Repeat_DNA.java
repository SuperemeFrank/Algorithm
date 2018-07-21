class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        
        Set<String> seen = new HashSet<>();
        Set<String> duplica = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i ++) {
            String dna = s.substring(i, i + 10);
            if (! seen.add(dna)) {
                duplica.add(dna);
            }
        }
        return new ArrayList<String>(duplica);
    }
}