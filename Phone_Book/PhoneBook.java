package CSCE210.Phone_Book;

public class PhoneBook {

    private Hash myHash;
    
    public PhoneBook(int size) {                       //constructor for the phonebook passes the starting size of the phone book/hash table
        myHash = new Hash(size);
    }

    public void Insert(String name, int number) {       //inserts a number into the phonebook, into the hash table, and into a linked list by hashing
        myHash.Insert(name, number);
    }

    public void Retrieve(String key) {                  //retrieves the a singular name and phone number from the phone book... searches by name
        MyNode node;                                            //stores the node that will be found in the linked list
        int size = myHash.Capacity();                           //retrieves the size of the current hash array
        int index = 0;                                          //will hold the indexing
                                                                
        while (index < size) {                                  //loop over each index of the hash array
            if (myHash.hashArray[index] != null) {              //if the index of the hash is not equal to null the loop will procede
                node = myHash.hashArray[index].getHead();       //retrieves the node at the indexed location of the hash array

                String name = node.getKey();                    //retrieves the name from the node
                int number = node.getValue();                   //retrieves the phone number from the node
                
                if (key == name) {                              //if the key is equal to the name, the name and number of requested person will be printed
                    System.out.println(name + " " + number);    
                }
            }
            index++;
        }
    }

    public void Delete(String name) {               //deletes a name and cooresponding number from the hash table by passing a key
        myHash.Delete(name);
    }

    public void Print() {                                       
        MyNode node;                                            //stores the node that will be found in the linked list
        int size = myHash.Capacity();                           //retrieves the size of the current hash array
        int index = 0;                                          //will hold the indexing
                                                                                                                                
        while (index < size) {                                  //loop over each index of the hash array
            if (myHash.hashArray[index] != null) {              //if the index of the hash is not equal to null the loop will procede
                node = myHash.hashArray[index].getHead();       //retrieves the node at the indexed location of the hash array
                                                                                                                                
                String name = node.getKey();                    //retrieves the name from the node
                int number = node.getValue();                   //retrieves the phone number from the node
                System.out.println(name + " " + number);        
            }
            index++;
        }
        System.out.println("Phone Book Load Factor: " + myHash.LoadFactor());           //prints the load factor of the hash table
    }
}
