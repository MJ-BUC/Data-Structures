package CSCE210.Phone_Book;

public class PhoneBookDemo {
    
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook(1);

        myPhoneBook.Insert("David", 123);
        myPhoneBook.Insert("Kyle", 321);
        myPhoneBook.Insert("Caden", 213);
        myPhoneBook.Insert("Mark", 312);
        myPhoneBook.Insert("Bill", 630);
        // myPhoneBook.Insert("Bob", 546);
        // myPhoneBook.Insert("Jack", 872);
        // myPhoneBook.Insert("James", 311);
    }
}
