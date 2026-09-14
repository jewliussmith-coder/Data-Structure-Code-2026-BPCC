import java.util.Stack;

public class FileSystemAnalyzer {

    // Phase 1: Count all files recursively
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

    // Phase 2: Calculate total storage size
    public static int calculateTotalSizeRecursive(FileSystemItem item) {

        // Base Case
        if (item instanceof FileItem) {
            return item.getSizeInKB();
        }

        // General Case
        if (item instanceof Folder) {
            Folder folder = (Folder) item;
            int sum = 0;

            for (FileSystemItem child : folder.getItems()) {
                sum += calculateTotalSizeRecursive(child);
            }

            return sum;
        }

        return 0;
    }

    // Phase 2: Find the largest file
    public static FileItem findLargestFileRecursive(FileSystemItem item) {

        // Base Case
        if (item instanceof FileItem) {
            return (FileItem) item;
        }

        // General Case
        if (item instanceof Folder) {
            Folder folder = (Folder) item;
            FileItem largest = null;

            for (FileSystemItem child : folder.getItems()) {
                FileItem childLargest = findLargestFileRecursive(child);

                if (childLargest != null &&
                        (largest == null ||
                                childLargest.getSizeInKB() > largest.getSizeInKB())) {

                    largest = childLargest;
                }
            }

            return largest;
        }

        return null;
    }

    // Phase 3: Count files using an explicit stack
    public static int countFilesIterative(Folder rootFolder) {

        Stack<FileSystemItem> stack = new Stack<>();

        stack.push(rootFolder);

        int fileCount = 0;

        while (!stack.isEmpty()) {

            FileSystemItem currentItem = stack.pop();

            if (currentItem instanceof FileItem) {
                fileCount++;
            }

            else if (currentItem instanceof Folder) {
                Folder folder = (Folder) currentItem;

                for (FileSystemItem child : folder.getItems()) {
                    stack.push(child);
                }
            }
        }

        return fileCount;
    }

    // Phase 4: Find a folder by name
    public static Folder findFolder(Folder current, String targetName) {

        // Check the current folder
        if (current.getName().equalsIgnoreCase(targetName)) {
            return current;
        }

        // Search through the current folder's items
        for (FileSystemItem item : current.getItems()) {

            if (item instanceof Folder) {
                Folder foundFolder =
                        findFolder((Folder) item, targetName);

                if (foundFolder != null) {
                    return foundFolder;
                }
            }
        }

        return null;
    }

    // Phase 4: Print the file system hierarchy
    public static void printHierarchy(FileSystemItem item, String indent) {

        if (item instanceof Folder) {

            Folder folder = (Folder) item;

            System.out.println(indent + folder.getName() + "/");

            for (FileSystemItem child : folder.getItems()) {
                printHierarchy(child, indent + "  ");
            }

        } else if (item instanceof FileItem) {

            FileItem file = (FileItem) item;

            System.out.println(
                    indent + file.getName()
                            + " (" + file.getSizeInKB() + " KB)"
            );
        }
    }
}
