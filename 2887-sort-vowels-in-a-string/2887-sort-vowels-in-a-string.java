class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('a','e','i','o','u',
    'A','E','I','O','U'
);
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->{
            return a-b;
        });
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(vowels.contains(c)){
            pq.add(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(vowels.contains(c))
            sb.append(pq.poll());
            else
            sb.append(c);
        }
        return sb.toString();
    }
}