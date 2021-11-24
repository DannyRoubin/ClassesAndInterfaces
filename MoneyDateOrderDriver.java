/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Classes and Interfaces assignment

Purpose of this file/class is to be a driver for the money, date, and order classes
and to test every method with a proper and improper insertion of data
*/
public class MoneyDateOrderDriver {

    /*
     * ASK QUESTION ABOUT GETTERS RETURNING 01 OR 1
     */

    public static void main(String[] args) {
        // moneyClassDriver();
        dateClassDriver();
        // orderClassDriver();
    }

    // Driver method for testing money class
    public static void moneyClassDriver() {
        // testing constructors
        System.out.println("Testing constructors");
        System.out.println("---------------------------");
        Money money1 = new Money();
        System.out.println("Testing blank constructor, expecting '$0.00': " + money1.toString());
        Money money2 = new Money(6);
        System.out.println("Testing dollar only constructor, expecting '$6.00': " + money2.toString());
        Money money3 = new Money(5, 11);
        System.out.println("Testing dollar and cents constructor, expecting '$5.11': " + money3.toString());
        Money money4 = new Money(money3);
        System.out.println("Testing copy constructor, expecting '$5.11': " + money4.toString());
        System.out.println("");

        // testing getters
        System.out.println("Testing getters");
        System.out.println("----------------------------");
        System.out.println("Testing getDollars, expecting 6: " + money2.getDollars());
        System.out.println("Testing getCents, expecting 11: " + money4.getCents());
        System.out.println("Testing getMoney, expecting 5.11: " + money4.getMoney());
        System.out.println("");

        // testing Setters
        System.out.println("Testing Setters");
        System.out.println("----------------------------");
        System.out.println("Showing the value of money2 prior to any setters " + money2.toString());
        money2.setDollars(10);
        System.out.println("Testing setDollars, expecting $10.00: " + money2.toString());
        System.out.println("Testing SetDollars with a negative number, expecting error on the next line: ");
        money2.setDollars(-10);
        money2.setCents(49);
        System.out.println("Testing setCents, expecting $10.49: " + money2.toString());
        System.out.println("Testing setCents with a negative number, expecting error on the next line: ");
        money2.setCents(-49);
        money2.setCents(149);
        System.out.println("Testing setCents with a number over 99, expecting $11.49: " + money2.toString());
        money2.setMoney(5, 10);
        System.out.println("Testing setMoney, expecting $5.10: " + money2.toString());
        System.out.println("Testing setMoney with a negative dollar amount, expecting error on the next line: ");
        money2.setMoney(-2, 15);
        System.out.println("Testing setMoney with a negative cent amount, expecting error on the next line: ");
        money2.setMoney(98, -75);
        System.out.println("Testing setMoney with a negative cent and dollar amount, expecting error on the next line: ");
        money2.setMoney(-63, -150);
        money2.setMoney(30, 150);
        System.out.println("Testing setMoney with a cent value over 99, expecting $31.50: " + money2.toString());
        System.out.println("");

        // testing Adding
        System.out.println("Testing Adding");
        System.out.println("----------------------------");
        System.out.println("Showing the value of money1 prior to any setters " + money1.toString());
        money1.add(2);
        System.out.println("Testing add with just a dollar amount, expecting $2.00: " + money1.toString());
        System.out.println("Testing add with just a negative dollar amount, expecting error on next line: ");
        money1.add(-2);
        money1.add(1, 10);
        System.out.println("Testing add with a dollar and cent amount, expecting $3.10: " + money1.toString());
        System.out.println("Testing add with a negative dollar and positive cent amount, expecting error on next line: ");
        money1.add(-2, 40);
        System.out.println("Testing add with a positive dollar and negative cent amount, expecting error on next line: ");
        money1.add(5, -80);
        System.out.println("Testing add with a negative dollar and negative cent amount, expecting error on next line: ");
        money1.add(-990, -4);
        money1.add(money2);
        System.out.println("Testing adding another money object, expecting $34.60: " + money1.toString());
        System.out.println("");

        // testing Equals
        System.out.println("Testing Equals");
        System.out.println("----------------------------");
        System.out.println("money1 " + money1.toString());
        System.out.println("money2 " + money2.toString());
        System.out.println("money3 " + money3.toString());
        System.out.println("money4 " + money4.toString());
        System.out.println("Checking if money1 and money2 are equal, expected outcome, false: " + money1.equals(money2));
        System.out.println("Checking if money3 and money4 are equal, expected outcome, true: " + money3.equals(money4));
        System.out.println("");

        // testing Clone
        System.out.println("Testing Clone");
        System.out.println("----------------------------");
        System.out.println("money1 " + money1.toString());
        try {
            Money money1Clone = (Money) money1.clone();
            System.out.println("money1Clone has the value of: " + money1Clone.toString());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        } 
        System.out.println("");

        // testing Comparable
        System.out.println("Testing Comparable");
        System.out.println("----------------------------");
        Money money2Copy = new Money(money2);
        Date date2 = new Date(1, 2, 2016);
        System.out.println("Printing out money2 to show what it is prior to any changes: " + money2.toString());
        System.out.println("Printing out money2Copy to show what it is prior to any changes: " + money2Copy.toString());
        System.out.println("Printing out money3 to show what it is prior to any changes: " + money3.toString());
        System.out.println("Testing out compareTo with two money objects that are the same, expecting 0  : " + money2.compareTo(money2Copy));
        System.out.println("Testing out compareTo on money 3 and money 2, money 3 being the smaller value money and money 2 being the greater one, expecting -1  : " + money3.compareTo(money2));
        System.out.println("Testing out compareTo on money 2 and money 3, money 2 being the smaller value money and money 3 being the greater one, expecting 1  : " + money2.compareTo(money3));
        System.out.println("Testing out compareTo on money2 and date2, expecting error on next line" );
        money2.compareTo(date2);

    }

    public static void dateClassDriver() {
        // testing constructors and toString()
        System.out.println("Testing constructors");
        System.out.println("---------------------------");
        System.out.println("Testing blank constructor, expecting error on the next line: ");
        Date date1 = new Date();
        Date date2 = new Date(1, 2, 2016);
        System.out.println("Testing full input constructor, expecting '01/02/2016': " + date2.toString());
        Date date3 = new Date(12, 5, 2018);
        System.out.println("Testing full input constructor, expecting '12/05/2018': " + date3.toString());
        Date date4 = new Date(11, 15, 2026);
        System.out.println("Testing full input constructor, expecting '11/15/2026': " + date4.toString());
        Date date5 = new Date(2, 23, 2019);
        System.out.println("Testing full input constructor, expecting '02/23/2019': " + date5.toString());
        Date date6 = new Date(date5);
        System.out.println("Testing copy constructor, expecting '02/23/2019': " + date6.toString());
        System.out.println("Testing full input constructor but looking for error, expecting 'invalid month' on next line: ");
        Date date7 = new Date(0, 20, 2019);
        System.out.println("Testing full input constructor but looking for error, expecting 'invalid day' on next line: ");
        Date date8 = new Date(3, 56, 2021);
        System.out.println("Testing full input constructor but looking for error, expecting 'invalid year' on next line: ");
        Date date9 = new Date(3, 12, 11);
        System.out.println("");

        // testing getters
        System.out.println("Testing getters");
        System.out.println("----------------------------");
        System.out.println("Testing getYear, expecting 2016: " + date2.getYear());
        System.out.println("Testing getMonth, expecting 01: " + date2.getMonth());
        System.out.println("Testing getDay, expecting 02: " + date2.getDay());
        System.out.println("");

        // testing Setters
        System.out.println("Testing Setters");
        System.out.println("----------------------------");
        System.out.println("Showing the value of date1 prior to any setters: " + date1.toString());
        date1.setAll(1, 5, 2020);
        System.out.println("Testing setAll with all valid inputs, expecting 01/05/2020: " + date1.toString());
        System.out.println("Testing setAll with an invalid month input, expecting error on the next line: ");
        date1.setAll(13, 10, 2016);
        System.out.println("Testing setAll with an invalid day input, expecting error on the next line: ");
        date1.setAll(11, 54, 2017);
        System.out.println("Testing setAll with an invalid year input, expecting error on the next line: ");
        date1.setAll(9, 14, 2096);
        date1.setYear(2017);
        System.out.println("Testing setYear with a valid input, expecting 01/05/2017: " + date1.toString());
        System.out.println("Testing setYear with an invalid input, expecting error on the next line: ");
        date1.setYear(2751);
        date1.setMonth(12);
        System.out.println("Testing setMonth with a valid input, expecting 12/05/2017: " + date1.toString());
        System.out.println("Testing setMonth with an invalid input, expecting error on the next line: ");
        date1.setMonth(13);
        date1.setDay(31);
        System.out.println("Testing setDay with a valid input, expecting 12/31/2017: " + date1.toString());
        System.out.println("Testing setDay with an invalid input, expecting error on the next line: ");
        date1.setDay(32);
        System.out.println("");

        // testing isAfter
        System.out.println("Testing isAfter");
        System.out.println("----------------------------");
        System.out.println("Printing out date1 to show what it is prior to any changes: " + date1.toString());
        System.out.println("Printing out date2 to show what it is prior to any changes: " + date2.toString());
        System.out.println("Testing if date2 is after date1, expecting false: " + date1.isAfter(date2));
        System.out.println("Testing if date1 is after date2, expecting true: " + date2.isAfter(date1));
        date2.setYear(2017);
        System.out.println("Printing out date1 to show what it is : " + date1.toString());
        System.out.println("Printing out date2 to show what it is : " + date2.toString());
        System.out.println("Testing if date2 is after date1 now that the years are the same, expecting false: "+ date1.isAfter(date2));
        System.out.println("Testing if date1 is after date2 now that the years are the same, expecting true: "+ date2.isAfter(date1));
        date2.setMonth(12);
        System.out.println("Printing out date1 to show what it is : " + date1.toString());
        System.out.println("Printing out date2 to show what it is : " + date2.toString());
        System.out.println("Testing if date2 is after date1 now that the years and months are the same, expecting false: "+ date1.isAfter(date2));
        System.out.println("Testing if date1 is after date2 now that the years and months are the same, expecting true: "+ date2.isAfter(date1));
        System.out.println("");

        // testing Equals
        System.out.println("Testing Equals");
        System.out.println("----------------------------");
        System.out.println("Printing out date1 to show what it is prior to any changes: " + date1.toString());
        System.out.println("Printing out date2 to show what it is prior to any changes: " + date2.toString());
        System.out.println("Testing equals method, expecting false: " + date1.equals(date2));
        date2.setDay(31);
        System.out.println("Testing equals method, expecting true: " + date1.equals(date2));
        System.out.println("");

        // testing Clone
        System.out.println("Testing Clone");
        System.out.println("----------------------------");
        System.out.println("Printing out date1 to show what it is prior to any changes: " + date1.toString());
        try {
            Date date1Clone = (Date) date1.clone();
            System.out.println("date1Clone has the value of: " + date1Clone.toString());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        } 
        System.out.println("");

        // testing Comparable
        System.out.println("Testing Comparable");
        System.out.println("----------------------------");
        Date date1Copy = new Date(date1);
        Money amount1 = new Money(6, 50);
        System.out.println("Printing out date1 to show what it is prior to any changes: " + date1.toString());
        System.out.println("Printing out date1Copy to show what it is prior to any changes: " + date1Copy.toString());
        System.out.println("Printing out date3 to show what it is prior to any changes: " + date3.toString());
        System.out.println("Testing out compareTo with two dates that are the same, expecting 0  : " + date1.compareTo(date1Copy));
        System.out.println("Testing out compareTo on date 1 and date 3, date 1 being the earlier date and date 3 being the later one, expecting -1  : " + date1.compareTo(date3));
        System.out.println("Testing out compareTo on date 3 and date 1, date 3 being the earlier date and date 1 being the later one, expecting 1  : " + date3.compareTo(date1));
        System.out.println("Testing out compareTo on date 1 and amount1, expecting error on next line" );
        date3.compareTo(amount1);

    }

    public static void orderClassDriver() {
        // testing constructors
        System.out.println("Testing constructors");
        System.out.println("---------------------------");
        // first we need to make a new Money and Date object
        Money amount1 = new Money(6, 50);
        Date orderDate1 = new Date(6, 10, 2021);
        Order order1 = new Order(amount1, orderDate1, "Bill", "Charger");
        System.out.println("Testing constructor, expecting 'item= 'Charger' Customer name= 'Bill' amount= '$6.50'  orderDate= '06/10/2021' if sent= 'false'': "+ order1.toString());
        Order order2 = new Order(order1);
        System.out.println("Testing copy constructor, expecting 'item= 'Charger' Customer name= 'Bill' amount= '$6.50'  orderDate= '06/10/2021' if sent= 'false'': "+ order2.toString());
        Order order3 = new Order(order2);
        System.out.println("");

        // testing getters
        System.out.println("Testing getters");
        System.out.println("----------------------------");
        System.out.println("Testing getAmount, expecting $6.50: " + order1.getAmount());
        System.out.println("Testing getOrderDate, expecting 06/10/21: " + order1.getOrderDate());
        System.out.println("Testing getCustomer, expecting 'Bill': " + order1.getCustomer());
        System.out.println("Testing getItem, expecting 'Charger': " + order1.getItem());
        System.out.println("");

        // testing is and set fulfilled
        System.out.println("Testing is and set fulfilled");
        System.out.println("----------------------------");
        System.out.println("Testing is fulfilled on an unfulfilled order, expecting false: " + order1.isFulfilled());
        System.out.println("Testing set fulfilled with a date prior to the order date, expecting error on next line: ");
        Date fulfilledDate1 = new Date(6, 8, 2021);
        order1.setFulfilled(fulfilledDate1);
        fulfilledDate1.setDay(10);
        order1.setFulfilled(fulfilledDate1);
        System.out.println("Testing set fulfilled with the same date as the order date, expecting true: " + order1.isFulfilled());
        Date fulfilledDate2 = new Date(6, 11, 2021);
        System.out.println("Testing set fulfilled on an order that is already fulfilled, expecting error on next line: ");
        order1.setFulfilled(fulfilledDate2);
        order2.setFulfilled(fulfilledDate2);
        System.out.println("Testing set fulfilled with a date after the order date, expecting true: " + order2.isFulfilled());
        System.out.println("Testing is fulfilled on fulfilled order, expecting true: " + order2.isFulfilled());
        System.out.println("");

        // testing rest of setters
        System.out.println("Testing rest of setters");
        System.out.println("----------------------------");
        Date orderDate3 = new Date(7,11,2021);
        System.out.println("Testing set orderDate with an order which is already fulfilled, expecting error on the next line:");
        order1.setOrderDate(fulfilledDate2);
        System.out.println("Testing set orderDate with a new date that is null, expecting error on the next line:");
        order3.setOrderDate(null);
        System.out.println("Testing set orderDate with a valid date , expecting true: " + order3.setOrderDate(orderDate3));
        System.out.println("Showing the value of amount of order3 prior to using setter:" + order3.getAmount());
        Money amount3 = new Money(9,99);
        System.out.println("Testing set amount with an order which is already fulfilled, expecting error on the next line:");
        order1.setAmount(amount3);
        System.out.println("Testing set amount with a new amount that is null, expecting error on the next line:");
        order3.setAmount(null);
        System.out.println("Testing set amount with a valid amount , expecting true: " + order3.setAmount(amount3));
        System.out.println("Showing the value of amount of order3 post setter:" + order3.getAmount());
        System.out.println("Showing the value of the customer of order3 prior to using setter:" + order3.getCustomer());
        System.out.println("Testing set customer with a new customer that is null, expecting error on the next line:");
        order3.setCustomer(null);
        System.out.println("Testing set customer with an order which is already fulfilled, expecting error on the next line:");
        order1.setCustomer("BillyBob");
        order3.setCustomer("Heather");
        System.out.println("Testing set customer with a new customer that is valid, expecting 'Heather': " + order3.getCustomer());
        System.out.println("");

        // testing Equals
        System.out.println("Testing Equals");
        System.out.println("----------------------------");
        System.out.println("printing out all three orders to view what everything is prior to show equals is correct");
        System.out.println("Order 1: " + order1.toString());
        System.out.println("Order 2: " + order2.toString());
        System.out.println("Order 3: " + order3.toString());
        System.out.println("checking if order1 and order2 are equal, expecting true: " + order1.equals(order2));
        System.out.println("checking if order1 and order3 are equal, expecting false: " + order1.equals(order3));
        System.out.println("");

        // testing Comparable
        Date date2 = new Date(1, 2, 2016);
        System.out.println("Testing Comparable");
        System.out.println("----------------------------");
        System.out.println("printing out all three orders to view what everything is prior to show equals is correct");
        System.out.println("Order 1: " + order1.toString());
        System.out.println("Order 2: " + order2.toString());
        System.out.println("Order 3: " + order3.toString());
        System.out.println("Testing out compareTo with two orders that are the same, expecting 0  : " + order1.compareTo(order2));
        System.out.println("Testing out compareTo on order1 and order3, order1 being the cheaper one and order3 being the pricier one, expecting -1  : " + order1.compareTo(order3));
        System.out.println("Testing out compareTo on order3 and order1, order3 being the cheaper one and order1 being the pricier one, expecting 1  : " + order3.compareTo(order1));
        System.out.println("Testing out compareTo on order2 and date2, expecting error on next line" );
        order2.compareTo(date2);




    }

}
