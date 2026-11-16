
import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<T> {

    private List<T> vertices;
    private int[][] adjacencyMatrix;

    public WeightedGraph(int capacity) {
        vertices = new ArrayList<>();
        adjacencyMatrix = new int[capacity][capacity];


        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                adjacencyMatrix[i][j] = -1;
            }
        }
    }

    public void addVertex(T vertex) {
        if (vertices.size() >= adjacencyMatrix.length) {
            throw new IllegalStateException("Graph is full.");
        }

        if (vertices.contains(vertex)) {
            return;
        }

        vertices.add(vertex);
    }


    public void addEdge(T source, T destination, int weight) {
        int sourceIndex = vertices.indexOf(source);
        int destinationIndex = vertices.indexOf(destination);

        if (sourceIndex == -1 || destinationIndex == -1) {
            throw new IllegalArgumentException(
                    "Both vertices must exist in the graph."
            );
        }

        if (weight < 0) {
            throw new IllegalArgumentException(
                    "Weight must be non-negative."
            );
        }

        adjacencyMatrix[sourceIndex][destinationIndex] = weight;


        adjacencyMatrix[destinationIndex][sourceIndex] = weight;
    }

    public void displayMatrix() {
        System.out.print("     ");

        for (T vertex : vertices) {
            System.out.printf("%15s", vertex);
        }

        System.out.println();

        for (int i = 0; i < vertices.size(); i++) {
            System.out.printf("%-15s", vertices.get(i));

            for (int j = 0; j < vertices.size(); j++) {
                System.out.printf("%15d", adjacencyMatrix[i][j]);
            }

            System.out.println();
        }
    }
}
