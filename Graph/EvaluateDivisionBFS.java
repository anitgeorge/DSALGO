/**
 *
 * <p>
 *     https://leetcode.com/problems/evaluate-division/
 * </p>
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() == values.size(),
 * and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 *
 * @author anitgeorge
 */

class EvaluateDivisionBFS {
    public class Node {
        private String str;
        private Double cost;
        public Node(String str, Double cost) {
            this.str = str;
            this.cost = cost;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        if(equations.isEmpty() || queries.isEmpty()
                || values == null || values.length == 0
                || values.length != equations.size()
        )
            return new double[]{};
        Map<String, List<Node>> map = new HashMap<>();
        double[] res = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            List<String> curr = equations.get(i);
            map.putIfAbsent(curr.get(0), new ArrayList<>());
            map.putIfAbsent(curr.get(1), new ArrayList<>());
            map.get(curr.get(0)).add(new Node(curr.get(1), values[i]));
            map.get(curr.get(1)).add(new Node(curr.get(0), 1 / values[i]));
        }

        for (int i = 0; i < res.length; i++) {

            List<String> query = queries.get(i);
            if (map.containsKey(query.get(0))
                    && map.containsKey(query.get(1)))
                res[i] = bfs(map, query.get(0), query.get(1));
            else
                res[i] = -1;
        }

        return res;
    }

    private double bfs(Map<String, List<Node>> map, String from, String to) {

        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Node(from, 1.0));
        visited.add(from);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.str.equals(to))
                return curr.cost;
            List<Node> next = map.get(curr.str);
            for (Node n : next) {
                if (visited.contains(n.str)) continue;
                queue.add(new Node(n.str, curr.cost * n.cost));
                visited.add(n.str);
            }
        }
        return -1.0;
    }
}