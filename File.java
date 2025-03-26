public class File extends ElementFileSystem {
    protected Integer fileSize;

    @Override
    Integer getSize() {
        return fileSize;
    }

    public File(String name, Directory parentDirectory, int size) {
        super(name, parentDirectory);
        this.fileSize = size;
    }

    @Override
    public String toString() {
        return "File name: " + this.name + " File size: " + fileSize + "\n";
    }
}
