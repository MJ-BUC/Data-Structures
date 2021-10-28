public class DocScannerDemo {

	public DocScannerDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//testing an empty document scanner
		System.out.print("Creating an empty Document Scanner\n");
		DocScanner myScanner = new DocScanner();
		System.out.print("Printing Document Scanner items inorder:\n");
		myScanner.PrintInorder();
		System.out.print("Printing Max Word:\n");
		myScanner.PrintMaxWord();
		System.out.print("\n");

		//testing document scanner with a short test file
		System.out.print("Scanning document 'test.txt' into document scanner.\n");
		myScanner.ScanDocument("test.txt");
		System.out.print("Printing Document Scanner items inorder: ");
		myScanner.PrintInorder();
		System.out.print("\n");
		System.out.print("Printing Document Scanner items preorder: ");
		myScanner.PrintPreorder();
		System.out.print("\n");
		System.out.print("Printing Document Scanner items postorder: ");
		myScanner.PrintPostorder();
		System.out.println("\n");

		//testing PrintMaxWord and deletions
		System.out.print("Printing Max Word:\n");
		myScanner.PrintMaxWord();
		System.out.print("Deleting 'alice'\n");
		myScanner.delete("alice");
		System.out.print("Printing Max Word:\n");
		myScanner.PrintMaxWord();
		System.out.print("Printing Document Scanner items preorder: ");
		myScanner.PrintPreorder();
		System.out.print("\n");
		System.out.print("Deleting 'filled' and 'she'.\n");
		myScanner.delete("filled");
		myScanner.delete("she");
		System.out.print("Printing Document Scanner items postorder: ");
		myScanner.PrintPostorder();
		System.out.println("\n");
		System.out.print("Deleting 'filled' and 'she' again.\n");
		myScanner.delete("filled");
		myScanner.delete("she");
		System.out.print("Printing Document Scanner items inorder: ");
		myScanner.PrintInorder();
		System.out.println("\n");

		//emptying document scanner
		System.out.print("Deleting everything from the document scanner.\n");
		myScanner.delete("alice");
		myScanner.delete("alice");
		myScanner.delete("reading");

		System.out.print("Searching for 'alice' in the document scanner.\n");
		System.out.print("'alice' appears " + myScanner.Search("reading") + " times.\n");

		//running with long text file
		System.out.print("Scanning document 'alice.txt' into document scanner.\n");
		myScanner.ScanDocument("alice.txt");
		System.out.print("Printing Document Scanner items inorder: ");
		myScanner.PrintInorder();
		System.out.print("\n");
		System.out.print("Printing Document Scanner items preorder: ");
		myScanner.PrintPreorder();
		System.out.print("\n");
		System.out.print("Printing Document Scanner items postorder: ");
		myScanner.PrintPostorder();
		System.out.println("\n");

		System.out.print("Printing Max Word:\n");
		myScanner.PrintMaxWord();

		//testint searching
		System.out.print("Searching for 'alice' in the document scanner.\n");
		System.out.print("'alice' appears " + myScanner.Search("alice") + " times.\n");
		System.out.print("Searching for 'moment' in the document scanner.\n");
		System.out.print("'moment' appears " + myScanner.Search("moment") + " times.\n");
		System.out.print("Searching for 'CSCE' in the document scanner.\n");
		System.out.print("'CSCE' appears " + myScanner.Search("CSCE") + " times.\n");
		System.out.print("Deleting 'alice' 6 times.\n");
		for (int i=0; i<6; i++)
			myScanner.delete("alice");
		System.out.print("Searching for 'alice' in the document scanner.\n");
		System.out.print("'alice' appears " + myScanner.Search("alice") + " times.\n");
		System.out.print("\n");

		System.out.print("Printing Document Scanner items preorder: ");
		myScanner.PrintPreorder();
		System.out.print("\n\nDocument Scanner Demo done :)\n");
	}
}
