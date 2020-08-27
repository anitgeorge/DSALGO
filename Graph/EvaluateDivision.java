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


class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        if(equations.isEmpty() || queries.isEmpty()
                || values == null || values.length == 0
                || values.length != equations.size()
        )
            return new double[]{};
        double[] res = new double[queries.size()];

        Map<String, HashMap<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){

            List<String> vertices = equations.get(i);
            graph.putIfAbsent(vertices.get(0), new HashMap<>());
            graph.putIfAbsent(vertices.get(1), new HashMap<>());
            graph.get(vertices.get(0)).put(vertices.get(1), values[i]);
            graph.get(vertices.get(1)).put(vertices.get(0), 1 / values[i]);
        }
        for(int i = 0; i < queries.size(); i++){

            List<String> query = queries.get(i);
            String src  = query.get(0);
            String dest = query.get(1);
            res[i] = dfs(src, dest, 1 , graph, new HashSet<String>());
        }

        return res;
    }

    private double dfs(String src, String dest, double result,
                       Map<String, HashMap<String, Double>> graph, Set<String> visited){

        if(!graph.containsKey(src))
            return -1;
        if(src.equals(dest))
            return result;
        visited.add(src);
        Map<String, Double> next = graph.get(src);
        for(String str : next.keySet()){
            if(visited.contains(str))
                continue;
            double res = dfs(str, dest, result * next.get(str), graph, visited);
            if(result != -1)
                return res;
        }
        return -1;

    }
}