public class FileSystemAnalyzer {

    public static int countFilesRecursive(FileSystemItem item) {

        // Base Case
        if (item instanceof FileItem) {
            return 1;
        }

        // General Case
        if (item instanceof Folder) {
            Folder folder = (Folder) item;
            int counter = 0;

            for (FileSystemItem child : folder.getItems()) {
                counter += countFilesRecursive(child);
            }

            return counter;
        }

        return 0;
    }
}