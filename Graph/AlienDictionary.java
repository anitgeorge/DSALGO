public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {

        if(word == null || words.length == 0)
           return "";
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        for(String word: words)
           for(char ch : word.toCharArray()){

               indegree.put(ch, 0);
               graph.put(ch, new ArrayList<>());
           }
        for(int i = 0; i < words.length - 1; i++){

            String w1 = words[i], w2 = words[i + 1];
            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++){

                 char parent = w1.charAt(j), child = w2.charAt(j);
                 if(parent != child){

                    graph.get(parent).add(child);
                    indegree.put(child, indegree.get(child) + 1);
                 }
            }
        }
        for(Map.Entry<Character, Integer> entry : indegree.entrySet())
           if(entry.getValue() == 0)
              queue.offer(entry.getKey());
        while(!queue.isEmpty()){

            char src = queue.poll();
            builder.append(src);
            for(char child : graph.get(src)){

                indegree.put(child, indegree.get(child) - 1);
                if(indegree.get(child) == 0)
                   queue.offer(child);
            }
        }

        return builder.length() == indegree.size() ? builder.toString() : "";
    }
}
