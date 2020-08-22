/**
 * <p>
 *     https://www.youtube.com/watch?v=xR4sGgwtR2I&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=26
 * </p>
 *
 * <p>
 *     https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/EulerianPathDirectedEdgesAdjacencyList.java
 * </p>
 *
 * @author anitgeorge
 */

import java.lang.*;
import java.util.*;

class EulerianPath{

    int n;
    int[] in;
    int[] out;
    int edgeCount;
    List<Integer> path;
    List<List<Integer>> graph;

    EulerianPath(int size){
        n         = size;
        in        = new int[n];
        out       = new int[n];
        edgeCount = 0;
        path      = new LinkedList<>();
        graph     = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
    }

    public void addEdge(int from, int to){
        graph.get(from).add(to);
    }

    public int[] getEulerianPath(){

        setUp();
        if(!hasEulerianPath())
            return null;
        dfs(findStartNode());
        return path;
    }

    private void setUp(){
        for(int from = 0; from < n; from++)
            for(int to : graph.get(from)){
                in[to]++;
                out[from]++;
                edgeCount++;
            }
    }

    private boolean hasEulerianPath(){

        int startNode = 0, endNode = 0;
        if(edgeCount < 1)
            return false;
        for(int i = 0; i < n; i++){
            if(Math.abs(in[i] - out[i]) > 1)
                return false;
            if(out[i] - in[i] == 1)
                startNode++;
            else if(in[i] - out[i] == 1)
                endNode++;
        }

        return (startNode == 0 && endNode == 0) || (startNode == 1 && endNode == 1);
    }

    private int findStartNode(){

        int start = -1;
        for(int i = 0; i < n; i++){

            if(out[i] - in[i] == 1){
                return i;
            }
            if(out[i] > 0)
                start = i;
        }

        return start;
    }

    private void dfs(int at){

        while(out[at] != 0)
            dfs(graph.get(at).get(--out[at]));
        path.add(0, at);
    }
}