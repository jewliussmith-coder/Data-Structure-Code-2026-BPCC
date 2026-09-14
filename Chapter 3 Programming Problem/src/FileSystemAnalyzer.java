public class FileSystemAnalyzer {

    // Phase 1: Count all files
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
}
