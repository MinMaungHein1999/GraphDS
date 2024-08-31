package model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<Edge> edges;
	private Node start;
	private Node goal;
	private List<Path> routes;

	public Graph() {
		this.edges = new ArrayList<>();
		this.routes = new ArrayList<>();
	}
	
	public List<Node> getNodes(){
		List<Node> nodes = new ArrayList<>();
		for(Edge edge : edges) {
			nodes.add(edge.getStartNode());
		}
		return nodes;
	}
	
	public void addEdge(Edge e) {
		this.edges.add(e);
	}
	
	public List<Node> getChilds(Node node){
		List<Node> childs = new ArrayList<Node>();
		node = this.validateStartNode(node);
		
		List<Edge> edges = searchEdges(node); 
		for(Edge edge : edges) {
			childs.add(edge.getEndNode());
		}
		return childs;
	}
	
	private List<Edge> searchEdges(Node node) {
		List<Edge> result = new ArrayList<Edge>();
		for(Edge edge : this.edges) {
			if(edge.getStartNode().equals(node)) {
				result.add(edge);
			}
		}
		return result;
	}

	public void travelPaths(Node startNode, Path previousPath) {
		List<Node> childs = this.getChilds(startNode); 
		System.out.println(startNode.getName()+ " Childs : " + childs.size());
		
		for(Node child : childs) {
			Path childPath = new Path(child.getName());
			if(previousPath==null) {
				previousPath = new Path(startNode.getName());	
			}
			previousPath.setChildPath(childPath);
			
			
			
			if(child.equals(this.goal)) {
				addRoutes(childPath);
			}else {
				travelPaths(child, childPath);
			}
		}
		
	}
	
	private Path rootPath(Path childPath) {
		if(childPath.getParentPath()==null) {
			return childPath;
		}else {
			return rootPath(childPath.getParentPath());
		}
	}
	

	private void addRoutes(Path childPath) {
		Path root = rootPath(childPath);
		if(root.getName().equals(this.start.getName())){
			this.routes.add(childPath);
		}
	}

	public Node validateStartNode(Node startNode) {
		for(Node node : this.getNodes()) {
			if(node.equals(startNode)) {
				return node;
			}
		}
		return null;
	}
	
	public void searchRoutes(Node startNode, Node endNode) {
		startNode = validateStartNode(startNode);
		this.start = startNode;
		this.goal = endNode;
		List<Path> paths = null;
		if(startNode != null) {
			travelPaths(startNode, null);
		}
		for(Path path : this.routes) {
			display(path, "");
		}
		
	}

	private void display(Path path, String str) {
		if(path.getParentPath() != null) {
			str = path.getName() + "=>" + str;
			display(path.getParentPath(), str);
		}else {
			System.out.println(path.getName() + "=>" + str);
		}
	}
}
