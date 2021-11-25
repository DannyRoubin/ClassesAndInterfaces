/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Classes and Interfaces assignment

Purpose of this file/class is to be an array list 
that is capable of taking in any object
*/
public class ArrayList {
    protected int numElements = 0;
    protected int arrayLength;
    protected Object[] obj;

// adding in getters to aid us with the subclass
    public int getNumElements() {
        return this.numElements;
    }

    public Object[] getObj() {
        return this.obj;
    }



    // constructor which sets the size of the object
    ArrayList(int size) {
        arrayLength = size;
        obj = new Object[size];
    }

    // constructor that auto sets the size of the 
    // array list to 10 as the default value
    ArrayList() {
        arrayLength = 10;
        obj = new Object[arrayLength];
    }

    // inserts a value at the specified index and shifts existing values as needed.
    public void insert(Object nObj, int index) {
        if(index + 1 >obj.length) {
           System.out.println("Index is out of bounds");
        } else if(index < 0) {
            System.out.println("Index cannot be negative");
        } else {
        lengthCheck();
        numElements++;
        for (int i = numElements - 1; i > index; i--) {
            if (obj[i-1] == null) {

            } else {
            obj[i] = obj[i - 1];
            }
        }
        obj[index] = nObj;
    }
    }


    // append method to add a new object to the end of the list
    public void append(Object nObj) {
        obj[numElements++] = nObj;
    }

    // removes a specified index and shifts values over appropriately
    public Object remove(int index) {
        if(index + 1 >obj.length) {
            System.out.println("Index is out of bounds");
            return -1;
         } else if(index < 0) {
             System.out.println("Index cannot be negative");
             return -1;
         } else {
        Object holder = obj[index];
        obj[index] = null;
        numElements--;
        return holder;
        }
    }

    // get method to return the object at the given index
    public Object get(int index) {
        // return obj[index];
        if(index > obj.length) {
            System.out.println("Index out of bounds");
            return null; 
        } else {
            return obj[index];
        }
    }


    // toString method to print out the entire ArrayList
    @Override
    public String toString() {
        String retVal = "";
        for(int i = 0; i < numElements; i++) {
            retVal += obj[i];
            retVal += " ";
            
        }
        return retVal;
    }

    // method to check if list is almost out of space
    public void lengthCheck() {
        if (obj[obj.length -1] != null) {
            Object[] newObj = new Object[(obj.length * 2)];
            for (int i = 0; i < numElements; i++) {
                newObj[i] = obj[i];
            }
            this.obj = newObj; 
        } else {
        }

    }

    // method to force increase the size of the array, most likely will not be needed, but can be helpful
    public void forceIncrease() {
        Object[] newObj = new Object[(obj.length * 2)];
            for (int i = 0; i < numElements; i++) {
                newObj[i] = obj[i];
            }
            this.obj = newObj; 
    }
    
// checks if the arraylist is empty
    public boolean isEmpty() {
        if (numElements < 1) {
            return true;
        } else {
            return false;
        }
    }

    // finds the first occurrence of an object in the array, returns -1 if not found, if found returns
    // returns the index at which the first occurrence was found
    public int getIndexOf(Object nObj) {
        int tracker = -1;
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] == nObj) {
                tracker = i;
                return tracker;
            }
        }
        return tracker;
    }

    // checks if two arraylists are equal to each other, returns boolean value
    public boolean equals(ArrayList that) {
        Object[] nObj = that.obj;
        if (obj.length == nObj.length) {
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != nObj[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // simplified version of getIndexOf() where this one checks if the specified object
    // lives in the array, and if yes, return boolean value
    public boolean contains(Object nObj) {
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] == nObj) {
                return true;
            } 
        }
        return false;
    }

    // gets numElements
    public int size() {
        return this.numElements;
    }
    
    // gets ArrayLength
    public int getArrayLength() {
        return this.arrayLength = obj.length;
    }
}
