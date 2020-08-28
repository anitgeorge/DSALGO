import java.lang.Character.UnicodeBlock;

public class UnionFind {

    int size;
    int[] sz;
    int[] parent;
    int numComponents;

    UnionFind(int N){

        size = numComponents = N;
        sz = new int[N];
        parent = new int[N];

        for(int i= 0; i < N; i++) {
            sz[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int node){

        int root = node;
        while(root != parent[root])
            root = parent[root];

        while(node != root){
            int next = parent[node];
            parent[node] = root;
            node  = next;
        }

        return root;
    }

    public void union(int p, int q){

        int root1 = find(p);
        int root2 = find(q);
        if(root1 == root2)
            return;
        if(sz[root1] > sz[root2]){
            sz[root1] += sz[root2];
            parent[root2] = root1;
        } else{
            sz[root2] += sz[root1];
            parent[root1] = root2;
        }
    }
}
