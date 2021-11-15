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
        Scanner text = new Scanner(file).useDelimiter("[.\r\n ]+");
        while (text.hasNext()) {
            String word = text.next();
            myBST.Insert(word);
        }
        text.close();
        } 
        catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public String Search(String word) {
        String foundWord = myBST.Search(word).getValue();
        return foundWord;
    }

    public void delete(String word) {
        myBST.Delete(word);
    }

    public void PrintMaxWord() {
        myBST.Max_Helper();
        myBST.MaxWordCounter();
    }

    public void PrintPreorder() {
        myBST.Preorder_Helper();
    }

    public void PrintInorder() {
        myBST.Inorder_Helper();
    }

    public void PrintPostorder() {
        myBST.Postorder_Helper();
    }
}
