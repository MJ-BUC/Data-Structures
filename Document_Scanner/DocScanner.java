package CSCE210.Document_Scanner;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DocScanner {

    BinarySearchTree myBST;
    
    public DocScanner(String key) {
        myBST = new BinarySearchTree(key);
    }

    public DocScanner() {
        myBST = new BinarySearchTree();
    }

    public void ScanDocument(String filename) throws FileNotFoundException {
        File file = new File(filename);
        try {
        Scanner text = new Scanner(file).useDelimiter("[;\r\n ]+");
        while (text.hasNext()) {
            String word = text.next();
            // System.out.print(word + " ");
            myBST.Insert(word);
        }
        text.close();
        } 
        catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void Search(String word) {

    }

    public void Delete(String word) {

    }

    public void PrintMaxWord() {

    }

    public void PrintPreorder() {
        myBST.Print_Preorder();
    }

    public void PrintInorder() {
        myBST.Print_Inorder();
    }

    public void PrintPostorder() {
        myBST.Print_Postorder();
    }
}
