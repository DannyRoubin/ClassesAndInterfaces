/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Classes and Interfaces assignment

Purpose of this file/class is to be an extension of an arrayList class to be able to store and clone lists of orders
*/
public class PurchaseOrderAccount extends ArrayList implements Cloneable{

    // Clone method that allows me to clone another PurchaseOrderAccount
    public PurchaseOrderAccount clone() throws CloneNotSupportedException {
        try {
            PurchaseOrderAccount copy = (PurchaseOrderAccount) super.clone();
            copy.numElements = numElements;
            copy.arrayLength = arrayLength;
            copy.obj = obj.clone();
            return copy;
          
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
