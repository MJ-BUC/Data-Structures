package CSCE210.Phone_Book;

public class PhoneBook {

    private Hash myHash;
    
    public PhoneBook(int size) {
        myHash = new Hash(size);
    }

    public void Insert(String name, int number) {
        myHash.Insert(name, number);
    }

    public void Retrieve(String name) {

    }

    public void Delete(String name) {

    }

    public void Print() {

    }
}
