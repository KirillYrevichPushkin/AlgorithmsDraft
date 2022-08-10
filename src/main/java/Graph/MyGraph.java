package Graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyGraph {

    class Vertex{
        char label;
        boolean isVisited;

        public Vertex(char label) {
            this.label = label;
            isVisited = false;
        }
    }

    private Vertex[] vertexList;
    private final int MAX_VERTS = 32;
    private int[][]adjMat;
    private int size;

    public MyGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    /*
    * если делать взвешенный граф, то вместо 1 - ставить соответствующий вес
    * в данном примере двунаправленный граф (но если убрать одну из строк, станет однонаправленным)
    * */
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }

    //получение смежной непосещенной вершины
    public int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i]!=0 && !vertexList[i].isVisited){
                return i;
            }
        }
        return -1;
    }

    //обход в глубину
    public void dfs(){
        Stack<Integer> stack = new Stack<>();
        vertexList[0].isVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()){
            int v = getAdjUnvisitedVertex(stack.peek());
            if(v == -1){
                stack.pop();
            }else {
                vertexList[v].isVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        //обнулим посещаемость для повторного использования метода
        for (int i = 0; i < size; i++) {
            vertexList[i].isVisited = false;
        }
    }

    //обход в ширину
    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].isVisited = true;
        displayVertex(0);
        queue.add(0);
        int v1, v2;
        while (!queue.isEmpty()){
            v1 = queue.remove();

            //посетим все смежные точки и добавим их в очередь для следующего круга
            while ( (v2 = getAdjUnvisitedVertex(v1))!= -1 ){
                queue.add(v2);
                displayVertex(v2);
                vertexList[v2].isVisited = true;
            }
        }
        //обнулим посещаемость для повторного использования метода
        for (int i = 0; i < size; i++) {
            vertexList[i].isVisited = false;
        }
    }









}
