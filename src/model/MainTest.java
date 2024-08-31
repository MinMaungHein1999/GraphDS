package model;

public class MainTest {

	public static void main(String[] args) {
		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		Node nodeI = new Node("I");
		Node nodeJ = new Node("J");
		Node nodeK = new Node("K");
		Node nodeL = new Node("L");
		
		Graph graph = new Graph();
		graph.addEdge(new Edge(nodeA, nodeB, 5));
		graph.addEdge(new Edge(nodeA, nodeC, 2));
		graph.addEdge(new Edge(nodeA, nodeD, 3));
		graph.addEdge(new Edge(nodeA, nodeE, 1));
		
		graph.addEdge(new Edge(nodeB, nodeG, 5));
		graph.addEdge(new Edge(nodeD, nodeH, 2));
		graph.addEdge(new Edge(nodeE, nodeI, 3));
		graph.addEdge(new Edge(nodeE, nodeF, 1));
		
		graph.addEdge(new Edge(nodeG, nodeJ, 5));
		graph.addEdge(new Edge(nodeH, nodeK, 2));
		graph.addEdge(new Edge(nodeF, nodeL, 3));
	
		graph.addEdge(new Edge(nodeI, nodeL, 3));
		graph.addEdge(new Edge(nodeH, nodeL, 3));
		
		graph.searchRoutes(nodeA, nodeL);
		

	}

}
