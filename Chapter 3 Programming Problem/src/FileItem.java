public class FileItem implements FileSystemItem{
    private String name;
    private int sizeInKB;

    //contructor
    public FileItem(String name, int sizeInKB) {
        this.name = name;
        this.sizeInKB = sizeInKB;

    }

    //Implements
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getSizeInKB(){
        return this.sizeInKB;
    }
}
