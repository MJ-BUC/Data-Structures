package CSCE210.Document_Scanner;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DocScanner {

    BinarySearchTree myBST;
    
    public DocScanner(String key) {                 //constructor for the docscanner passes the key
        myBST = new BinarySearchTree(key);          //create BST using the key
    }

    public DocScanner() {
        myBST = new BinarySearchTree();
    }

    public void ScanDocument(String filename) throws FileNotFoundException {        //scans the documeent text file and insterts each word into the BST also hands file errors
        File file = new File(filename);                                             //holds the text file
        try {
        Scanner text = new Scanner(file).useDelimiter("[.\r\n ]+");                 //scans the text file and seperates using the delimiter
        while (text.hasNext()) {                                                //loops through the words in the text and inserts theminto the BST
            String word = text.next();
            myBST.Insert(word);
        }
        text.close();                                                   //closes the text file
        } 
        catch(FileNotFoundException e) {                            //file error handling
            System.out.println("File not found!");
        }
    }

    public int Search(String word) {                         //searches for a word in the BST by passing the word to the search method
        return myBST.SearchForWord(word);
    }

    public void delete(String word) {           //deletes an the first occurrence of a word from the BST
        myBST.Delete(word);
    }

    public void PrintMaxWord() {                //prints the max word aka the word with the highest occurrence
        myBST.Max_Helper();
        myBST.MaxWordCounter();
    }

    public void PrintPreorder() {               //prints the BST in a peorder fasion
        myBST.Preorder_Helper();
    }

    public void PrintInorder() {                //prints the BST in an inorder fasion
        myBST.Inorder_Helper();
    }

    public void PrintPostorder() {              //prints the BST in a preorder fasion
        myBST.Postorder_Helper();
    }
}
