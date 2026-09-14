import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

        // Keep program running until user chooses Option 6
        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("===== FILE SYSTEM INSPECTOR =====");
            System.out.println("1. Display File System Structure");
            System.out.println("2. Add File to a Folder");
            System.out.println("3. Add Subfolder");
            System.out.println("4. Run Recursive Audit");
            System.out.println("5. Run Iterative Audit & Verification");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {

                // Option 1
                case 1:

                    System.out.println();
                    System.out.println("===== FILE SYSTEM STRUCTURE =====");

                    FileSystemAnalyzer.printHierarchy(root, "");

                    break;

                // Option 2
                case 2:

                    System.out.println();
                    System.out.println("===== ADD FILE =====");

                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine().trim();

                    if (fileName.isEmpty()) {
                        System.out.println("File name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter file size in KB: ");

                    int fileSize;

                    try {
                        fileSize = Integer.parseInt(
                                scanner.nextLine().trim()
                        );
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid file size.");
                        break;
                    }

                    if (fileSize < 0) {
                        System.out.println("File size cannot be negative.");
                        break;
                    }

                    System.out.print("Enter target folder name: ");
                    String targetFolderName = scanner.nextLine().trim();

                    Folder targetFolder =
                            FileSystemAnalyzer.findFolder(
                                    root,
                                    targetFolderName
                            );

                    if (targetFolder == null) {
                        System.out.println(
                                "Folder '" + targetFolderName
                                        + "' was not found."
                        );
                    } else {
                        FileItem newFile =
                                new FileItem(fileName, fileSize);

                        targetFolder.addItem(newFile);

                        System.out.println(
                                "File added to "
                                        + targetFolder.getName() + "."
                        );
                    }

                    break;

                // Option 3
                case 3:

                    System.out.println();
                    System.out.println("===== ADD SUBFOLDER =====");

                    System.out.print("Enter new folder name: ");
                    String newFolderName =
                            scanner.nextLine().trim();

                    if (newFolderName.isEmpty()) {
                        System.out.println("Folder name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter parent folder name: ");
                    String parentFolderName =
                            scanner.nextLine().trim();

                    Folder parentFolder =
                            FileSystemAnalyzer.findFolder(
                                    root,
                                    parentFolderName
                            );

                    if (parentFolder == null) {

                        System.out.println(
                                "Folder '" + parentFolderName
                                        + "' was not found."
                        );

                    } else {

                        Folder newFolder =
                                new Folder(newFolderName);

                        parentFolder.addItem(newFolder);

                        System.out.println(
                                "Folder added to "
                                        + parentFolder.getName() + "."
                        );
                    }

                    break;

                // Option 4
                case 4:

                    System.out.println();
                    System.out.println("===== RECURSIVE AUDIT =====");

                    int totalFiles =
                            FileSystemAnalyzer.countFilesRecursive(root);

                    int totalSize =
                            FileSystemAnalyzer.calculateTotalSizeRecursive(root);

                    FileItem largestFile =
                            FileSystemAnalyzer.findLargestFileRecursive(root);

                    System.out.println(
                            "Total files: " + totalFiles
                    );

                    System.out.println(
                            "Total storage: " + totalSize + " KB"
                    );

                    if (largestFile != null) {

                        System.out.println(
                                "Largest file: "
                                        + largestFile.getName()
                        );

                        System.out.println(
                                "Largest file size: "
                                        + largestFile.getSizeInKB()
                                        + " KB"
                        );

                    } else {
                        System.out.println("No files exist.");
                    }

                    break;

                // Option 5
                case 5:

                    System.out.println();
                    System.out.println("===== ITERATIVE AUDIT & VERIFICATION =====");

                    int recursiveCount =
                            FileSystemAnalyzer.countFilesRecursive(root);

                    int iterativeCount =
                            FileSystemAnalyzer.countFilesIterative(root);

                    System.out.println(
                            "Recursive file count: "
                                    + recursiveCount
                    );

                    System.out.println(
                            "Iterative file count: "
                                    + iterativeCount
                    );

                    if (recursiveCount == iterativeCount) {

                        System.out.println(
                                "PASS: Both methods returned the same count."
                        );

                    } else {

                        System.out.println(
                                "FAIL: The methods returned different counts."
                        );
                    }

                    break;

                // Option 6
                case 6:

                    System.out.println("Exiting program. Goodbye!");

                    running = false;

                    break;

                // Invalid option
                default:

                    System.out.println(
                            "Invalid choice. Please choose 1-6."
                    );
            }
        }

        scanner.close();
    }
}
