package model;

public class Node {
	private String name;
	public Node(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Node obj) {
		 if(obj==null) {
			 return false;
		 }
		return this.name.equals(obj.getName());
	}
	
	
}
