package lecture_9_graph2;

import java.util.HashMap;

public class ShortestPathLength extends BreadthFirstSearch {
    private Vertex target;
    private int pathLength = -1;
    private HashMap<Vertex, Integer> verticesLevel = new HashMap<>();
    private int numComponent = 0;

    public ShortestPathLength(Graph graph) {
        super(graph);
    }

    protected void additionalProcessing() {
       numComponent++;
    }

    @Override
    protected void processEdge(Edge e) {
        if (numComponent != 0) return;

        if (verticesLevel.containsKey(e.v)) {
//            System.out.println(e.v + " - " + verticesLevel.get(e.v));
            verticesLevel.put(e.u, verticesLevel.get(e.v) + 1);

            if (verticesLevel.containsKey(target)) {
                pathLength = verticesLevel.get(target);
            }
        }
    }

    public int shortestPathLength(Vertex u, Vertex v){
        target = v;
        verticesLevel.put(u, 0);
        start(u);

        return pathLength;
    }
}
