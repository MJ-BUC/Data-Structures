package CSCE210.Phone_Book;

public class Hash {
    
    private DoublyLinkedList mylist = null;
    private DoublyLinkedList[] hashArray;
    private DoublyLinkedList[] hashArray2;

    public Hash(int size) {
        hashArray = new DoublyLinkedList[size];
    }

    public int HashKey(String key) {
        int size = Capacity();
        int position;
        int character = key.charAt(0);
        position = character % size;
        return position;
    }

    public void insert(String key, int value) {
        int index = HashKey(key);
        MyNode newnode = new MyNode(key, value);
        hashArray[index].add(newnode);
        if (LoadFactor() > 0.7) {
            Resize();
        }
    }

    public int NumKeys() {
        int counter = 0;
        for (DoublyLinkedList element: hashArray) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }

    public void delete(String key) {
        mylist.remove(key);
    }

    public int Capacity() {
        int arraySize = hashArray.length;
        return arraySize;
    }

    public double LoadFactor(){
        int size = Capacity();
        int usedSpaces = NumKeys();
        double load = usedSpaces / size;

        return load;
    }

    public void Resize() {
        int size = Capacity();
        DoublyLinkedList[] tempHashArray2 = new DoublyLinkedList[size * 2];
        
        
    }
}
