public class Main {
    public static void main(String[] args) {

        WeightedGraph<String> graph = new WeightedGraph<>(6);

        // add six delivery sites
        graph.addVertex("New York");
        graph.addVertex("Chicago");
        graph.addVertex("Denver");
        graph.addVertex("Los Angeles");
        graph.addVertex("Seattle");
        graph.addVertex("Miami");

        // routes with fuel costs
        graph.addEdge("New York", "Chicago", 790);
        graph.addEdge("New York", "Miami", 1300);
        graph.addEdge("Chicago", "Denver", 920);
        graph.addEdge("Chicago", "Seattle", 1730);
        graph.addEdge("Denver", "Los Angeles", 830);
        graph.addEdge("Denver", "Seattle", 1020);
        graph.addEdge("Los Angeles", "Seattle", 1130);
        graph.addEdge("Los Angeles", "Miami", 2340);
        graph.addEdge("Miami", "Chicago", 1380);

        // display graph
        graph.displayMatrix();
    }
}

