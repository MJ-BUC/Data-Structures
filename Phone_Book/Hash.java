package CSCE210.Phone_Book;

public class Hash {
    
    private DoublyLinkedList mylist = null;
    private DoublyLinkedList[] hashArray;

    public Hash(int size) {
        hashArray = new DoublyLinkedList[size];
    }

    public int HashKey(String key) {
        int size = Capacity();
        int position;
        int charAscii = key.charAt(0);
        int charLength = key.length();
        position = (charAscii * charLength + size) % size;
        return position;
    }

    public void Insert(String key, int value) {
        int index = HashKey(key);
        MyNode newnode = new MyNode(key, value);
        hashArray[index] = new DoublyLinkedList(null);
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

    public void Delete(String key) {
        mylist.remove(key);
    }

    public int Capacity() {
        int arraySize = hashArray.length;
        return arraySize;
    }

    public double LoadFactor(){
        double size = Capacity();
        double usedSpaces = NumKeys();
        double load = usedSpaces / size;

        return load;
    }

    public void Resize() {
        MyNode node;
        int size = Capacity();
        int index = 0;
        DoublyLinkedList[] tempHashArray = hashArray;
        hashArray = new DoublyLinkedList[size * 2];

        while (index < size) {
            node = tempHashArray[index].getHead();
            if (node != null) {
                String key = node.getKey();
                int value = node.getValue();
                Insert(key, value);
            }
            index++;
        }
    }
}
