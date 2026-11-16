import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public boolean breadthFirstSearch(T startVertex, T endVertex) {
        int startIndex = vertices.indexOf(startVertex);
        int endIndex = vertices.indexOf(endVertex);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        boolean[] visited = new boolean[vertices.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startIndex);
        visited[startIndex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == endIndex) {
                return true;
            }

            for (int i = 0; i < vertices.size(); i++) {
                if (matrix[current][i] != -1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return false;
    }

    public boolean depthFirstSearch(T startVertex, T endVertex) {
        int startIndex = vertices.indexOf(startVertex);
        int endIndex = vertices.indexOf(endVertex);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        boolean[] visited = new boolean[vertices.size()];
        Stack<Integer> stack = new Stack<>();

        stack.push(startIndex);
        visited[startIndex] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (current == endIndex) {
                return true;
            }

            for (int i = 0; i < vertices.size(); i++) {
                if (matrix[current][i] != -1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }

        return false;
    }
}
