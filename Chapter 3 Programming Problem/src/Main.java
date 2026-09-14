public class Main {

    public static void main(String[] args) {

        // Create folders
        Folder root = new Folder("Root");
        Folder documents = new Folder("Documents");
        Folder pictures = new Folder("Pictures");
        Folder vacations = new Folder("Vacations");
        Folder beach = new Folder("Beach");

        // Create random files
        FileItem resume = new FileItem("ImportantResume.pdf", 100);
        FileItem homework = new FileItem("BoringHomework.docx", 999);

        FileItem photo1 = new FileItem("SelfiePicture.jpg", 500);
        FileItem photo2 = new FileItem("FunnyPicture.jpg", 600);

        FileItem beachPhoto1 = new FileItem("BeachPic.jpg", 700);
        FileItem beachPhoto2 = new FileItem("Beach&Ocean.jpg", 800);

        // Add files to Documents
        documents.addItem(resume);
        documents.addItem(homework);

        // Add files to Vacations
        vacations.addItem(photo1);
        vacations.addItem(photo2);

        // Add files to Beach
        beach.addItem(beachPhoto1);
        beach.addItem(beachPhoto2);

        // Create nested folders
        vacations.addItem(beach);
        pictures.addItem(vacations);
        root.addItem(documents);
        root.addItem(pictures);

        // Phase 1: Count all files recursively
        int recursiveCount = FileSystemAnalyzer.countFilesRecursive(root);

        System.out.println("Recursive file count: " + recursiveCount);

        // Phase 2: Calculate total storage
        int totalSize = FileSystemAnalyzer.calculateTotalSizeRecursive(root);

        System.out.println("Total storage: " + totalSize + " KB");

        // Phase 2: Find largest file
        FileItem largestFile =
                FileSystemAnalyzer.findLargestFileRecursive(root);

        if (largestFile != null) {
            System.out.println("Largest file: " + largestFile.getName());
            System.out.println("Largest file size: "
                    + largestFile.getSizeInKB() + " KB");
        } else {
            System.out.println("No files found.");
        }

        // Phase 3: Count all files iteratively
        int iterativeCount = FileSystemAnalyzer.countFilesIterative(root);

        System.out.println("Iterative file count: " + iterativeCount);

        // Compare recursive and iterative results
        if (recursiveCount == iterativeCount) {
            System.out.println("PASS: Both methods returned the same file count.");
        } else {
            System.out.println("FAIL: The methods returned different file counts.");
        }

        // Assert that both methods return the same result
        assert recursiveCount == iterativeCount;
    }
}
