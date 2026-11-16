import java.util.ArrayList;

public class WeightedGraph<T> {
    private ArrayList<T> vertices;
    private int[][] matrix;

    public WeightedGraph(int size) {
        vertices = new ArrayList<>();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    public void addVertex(T vertex) {
        if (vertices.size() < matrix.length && !vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    public void addEdge(T source, T destination, int weight) {
        int sourceIndex = vertices.indexOf(source);
        int destinationIndex = vertices.indexOf(destination);

        if (sourceIndex != -1 && destinationIndex != -1) {
            matrix[sourceIndex][destinationIndex] = weight;
            matrix[destinationIndex][sourceIndex] = weight;
        }
    }
}