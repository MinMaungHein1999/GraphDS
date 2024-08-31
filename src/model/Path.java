package model;

public class Path {
	private String name;
	private Path parentPath;
	private Path childPath;
		
	public Path() {
		
	}
	
	public Path(Path childPath) {
		this.childPath = childPath;
	}
	
	public Path(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Path getChildPath() {
		return childPath;
	}

	public void setChildPath(Path childPath) {
		this.childPath = childPath;
		childPath.setParentPath(this);
	}

	public Path getParentPath() {
		return parentPath;
	}
	
	public boolean equals(Path path) {
		System.out.println("Name : " + this.name + "Path : "+ path);
		
		return this.name.equals(path.getName());
	}

	private void setParentPath(Path parent) {
		this.parentPath = parent;
	}
}
