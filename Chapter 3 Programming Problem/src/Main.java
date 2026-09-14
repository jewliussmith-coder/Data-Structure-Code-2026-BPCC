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

        // Phase 1: Count all files
        int totalFiles = FileSystemAnalyzer.countFilesRecursive(root);

        System.out.println("Total number of files: " + totalFiles);

        // Phase 2: Calculate total storage
        int totalSize = FileSystemAnalyzer.calculateTotalSizeRecursive(root);

        System.out.println("Total storage: " + totalSize + " KB");

        // Phase 2: Find the largest file
        FileItem largestFile = FileSystemAnalyzer.findLargestFileRecursive(root);

        if (largestFile != null) {
            System.out.println("Largest file: " + largestFile.getName());
            System.out.println("Largest file size: " + largestFile.getSizeInKB() + " KB");
        } else {
            System.out.println("No files found.");
        }
    }
}
