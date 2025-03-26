import java.util.LinkedList;

public class Directory extends ElementFileSystem{
    LinkedList<ElementFileSystem> listofElements;

    public Directory(String name, Directory parentDirectory) {
        super(name, parentDirectory);
        listofElements = new LinkedList<ElementFileSystem>();
    }

    public void addElementFileSystem(ElementFileSystem e) {
        listofElements.add(e);
    }

    @Override
    Integer getSize() {
        Integer totalSize = 0;
        for (ElementFileSystem efs : this.listofElements) {
            totalSize += efs.getSize();
        }
        return totalSize;
    }

    @Override
    public String toString() {
        String ret=this.name+"\n";
        for (ElementFileSystem efs : this.listofElements) {
            ret += efs;
        }
        return ret; 
    }
}
