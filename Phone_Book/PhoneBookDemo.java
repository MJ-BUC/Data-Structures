package CSCE210.Phone_Book;

public class PhoneBookDemo {
    
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook(1);       //sets the starting size of the hash table to 1 

        myPhoneBook.Insert("David", 123);
        myPhoneBook.Insert("Kyle", 321);
        myPhoneBook.Insert("Caden", 213);
        myPhoneBook.Insert("Mark", 312);
        myPhoneBook.Insert("George", 630);

        myPhoneBook.Print();
        myPhoneBook.Retrieve("Caden");

        myPhoneBook.Delete("George");
    }
}
