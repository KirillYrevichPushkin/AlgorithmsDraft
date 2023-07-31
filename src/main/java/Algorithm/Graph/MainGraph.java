package Algorithm.Graph;

public class MainGraph {

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();
        myGraph.addVertex('A');
        myGraph.addVertex('B');
        myGraph.addVertex('C');
        myGraph.addVertex('D');
        myGraph.addVertex('E');
        myGraph.addVertex('F');

        myGraph.addEdge(0, 2);
        myGraph.addEdge(0, 3);
        myGraph.addEdge(0, 4);
        myGraph.addEdge(0, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 4);
        myGraph.addEdge(2, 5);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(3, 5);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);


        myGraph.bfs();
        System.out.println();
        myGraph.dfs();


    }

}
