

public abstract class ElementFileSystem {
    protected String name;
    protected Directory parentDirectory; 

    public ElementFileSystem(String name, Directory parentDirectory) {
        this.name = name;
        this.parentDirectory = parentDirectory;
        if (this.parentDirectory != null) this.parentDirectory.addElementFileSystem(this);
    }

    abstract Integer getSize();
    
    void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public String getPath() {
        String path = this.name;
        if (this.parentDirectory != null) {
            path = this.parentDirectory.getPath() + "/" + path;
        }
        return path;
    }
}