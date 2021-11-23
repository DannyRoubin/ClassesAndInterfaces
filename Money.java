/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Classes and Interfaces assignment

Purpose of this file/class is to be a money class where a user is able to add in a dollar and cent amount, 
then is able to add to it, set dollar and cent amounts, compare it to other money objects, and print the value out
*/
public class Money {
    private int dollars;
    private int cents;

    // blank constructor which sets the dollar and cent amounts to 0 each
    public Money() {
        dollars = 0;
        cents = 0;
    }

    // constructor which takes just a dollar amount, and setting the cent value to 0
    // but checks to make sure value is positive
    public Money(int dol) {
        if (dol < 0) {
            System.out.println("You cannot have negative dollars");
        } else {
            dollars = dol;
            cents = 0;
        }
    }

    // constructor which takes both a dollar and cent value but checks to make sure
    // values are positive
    public Money(int dol, int cent) {
        if (cent < 0 || dol < 0) {
            System.out.println("You cannot have negative dollars or cents");
        } else {
            dollars = dol;
            cents = cent;
            centCheck();
        }
    }

    // Copy constructor but checks to make sure values are positive
    public Money(Money other) {
        if (other.cents < 0 || other.dollars < 0) {
            System.out.println("You cannot add negative dollars or cents");
        } else {
            this.dollars = other.dollars;
            this.cents = other.cents;
            centCheck();
        }
    }

    // gets the dollar value in int form
    public int getDollars() {
        return this.dollars;
    }

    // gets the cent value in int form
    public int getCents() {
        centCheck();
        return this.cents;
    }

    // sets the dollar value but checks to make sure value is positive
    public void setDollars(int dollars) {
        if (dollars < 0) {
            System.out.println("You cannot have negative dollars");
        } else {
            this.dollars = dollars;
        }
    }

    // Sets cent value but checks to make sure value is positive
    public void setCents(int cents) {
        if (cents < 0) {
            System.out.println("You cannot have negative cents");
        } else {
            this.cents = cents;
            centCheck();
        }
    }

    // sets dollar and cent valuyes but checks to make sure values are positive
    public void setMoney(int dollars, int cents) {
        if (cents < 0 || dollars < 0) {
            System.out.println("You cannot have negative dollars or cents");
        } else {
            this.dollars = dollars;
            this.cents = cents;
            centCheck();
        }
    }

    // returns the value as dollar.cents as a double
    public double getMoney() {
        centCheck();
        double res = 0.0;
        String strVal = this.getMonToString();
        res = Double.parseDouble(strVal);

        return res;
    }

    // adds the dollar value but checks to make sure value is positive
    public void add(int dollars) {
        if (dollars < 0) {
            System.out.println("You cannot add negative dollars");
        } else {
            this.dollars += dollars;
        }
    }

    // adds dollar and cent values but checks to make sure values are positive
    public void add(int dollars, int cents) {
        if (cents < 0 || dollars < 0) {
            System.out.println("You cannot add negative dollars or cents");
        } else {
            this.dollars += dollars;
            this.cents += cents;
            centCheck();
        }
    }

    // adds values from another money object but checks to make sure values are
    // positive
    public void add(Money other) {
        if (other.cents < 0 || other.dollars < 0) {
            System.out.println("You cannot add negative dollars or cents");
        } else {
            this.dollars += other.dollars;
            this.cents += other.cents;
            centCheck();
        }
    }

    // checks to make sure that two money objects are equal in value
    public boolean equals(Object o) {
        if (o instanceof Money) {
            centCheck();
            Money other = (Money) o;
            if (this.dollars == other.dollars && this.cents == other.cents) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // toString method, contains if statement for proper printing if the number is
    // under 10
    public String toString() {
        if (this.cents < 10) {
            String res = ("$" + this.dollars + ".0" + this.cents);
            return res;
        } else {
            String res = ("$" + this.dollars + "." + this.cents);
            return res;
        }
    }

    // Helper method that returned a string version of the value but without the
    // dollar sign
    // This was set up so I would be able to do a parseDouble() on this string for
    // the getMoney() method
    public String getMonToString() {
        if (this.cents < 10) {
            String res = (this.dollars + ".0" + this.cents);
            return res;
        } else {
            String res = (this.dollars + "." + this.cents);
            return res;
        }
    }

    // Helper method that checks to see if the cent value is over 99 and if it is
    // then I add a dollar and subtract 100
    public void centCheck() {
        while (this.cents > 99) {
            this.cents -= 100;
            this.dollars++;
        }
    }

}
