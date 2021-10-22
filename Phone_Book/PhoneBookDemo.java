package CSCE210.Phone_Book;

public class PhoneBookDemo {
    
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook(10);

        myPhoneBook.Insert("David", 123);
        myPhoneBook.Insert("Kyle", 321);
        myPhoneBook.Insert("Caden", 213);
        myPhoneBook.Insert("Mark", 312);
    }
}
