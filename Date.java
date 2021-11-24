/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Classes and Interfaces assignment

Purpose of this file/class is to be a date class

Assumptions for this file:
All days are between 1-31
Each month is between 1-12
each month has 31 days
years will be between 2016-2026
printing an invalid date will return an error message and continue
*/
public class Date implements Comparable, Cloneable {
    private int month;
    private int day;
    private int year;

 // clone method that allows me to clone a new date object
 public Date clone() throws CloneNotSupportedException {
    try {
        Date copy = (Date) super.clone();
        copy.month = month;
        copy.day = day;
        copy.year = year;
        return copy;
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
        return null;
    }
}


    // CompareTo method which allows me to compare two dates.
    @Override
    public int compareTo(Object o) throws ClassCastException {
        // first making sure that o is an instance of date
        if (o instanceof Date) {
            // if it comes out true it is safe to cast it to a date
            Date otherDate = (Date) o;
            // we first check if they are equal
            if(this.equals(otherDate)) {
                return 0;
                // else we check if the "this" date is before the "o" date
            } else if (this.isAfter(otherDate)) {
                return -1;
                // if both other cases failed and we know that it is an instance of date
                // the only possibility left is that the this date is after the o date
            } else {
                return 1;
            }
        }
        throw new ClassCastException("You may only pass in objects of type date");
    }


    // empty constructor which displays an error message
    public Date() {
        System.out.println("Please only provide a valid date");
    }

    // intended constructor which checks if all the date is valid prior to inserting any data anywhere
    public Date(int month, int day, int year) {
        if (month > 0 && month < 13) {
            if (day > 0 && day < 32) {
                if (year > 2015 && year < 2027) {
                    this.month = month;
                    this.day = day;
                    this.year = year;
                } else {
                    System.out.println("Invalid year");
                }
            } else {
                System.out.println("Invalid day");
            }
        } else {
            System.out.println("Invalid month");
        }
    }

    // copy constructor which may be overkill but it makes sure that the data being passed in is also all valid prior
    // to inserting that new data anywhere
    public Date(Date other) {
        if (other.month > 0 && other.month < 13) {
            if (other.day > 0 && other.day < 32) {
                if (other.year > 2015 && other.year < 2027) {
                    this.month = other.month;
                    this.day = other.day;
                    this.year = other.year;
                } else {
                    System.out.println("Invalid year");
                }
            } else {
                System.out.println("Invalid day");
            }
        } else {
            System.out.println("Invalid month");
        }
    }

    // simple getter which gets the year
    public int getYear() {
        return this.year;
    }

    // Simple getter which gets the month
    public int getMonth() {
        return this.month;
        
    }

    // Simple getter which gets the day
    public int getDay() {
        return this.day;
        
    }

    // setter which first makes sure that the year is valid prior to setting it
    public void setYear(int year) {
        if (year > 2015 && year < 2027) {
            this.year = year;
        } else {
            System.out.println("Invalid year");
        }
    }

    // setter which first makes sure that the month is valid prior to setting it
    public void setMonth(int month) {
        if (month > 0 && month < 13) {
            this.month = month;
        } else {
            System.out.println("Invalid month");
        }
    }

    // setter which first makes sure that the day is valid prior to setting it
    public void setDay(int day) {
        if (day > 0 && day < 32) {
            this.day = day;
        } else {
            System.out.println("Invalid day");
        }
    }

    // setter which first makes sure that all the data is valid prior to setting any of it
    public void setAll(int month, int day, int year) {
        if (month > 0 && month < 13) {
            if (day > 0 && day < 32) {
                if (year > 2015 && year < 2027) {
                    this.month = month;
                    this.day = day;
                    this.year = year;
                } else {
                    System.out.println("Invalid year");
                }
            } else {
                System.out.println("Invalid day");
            }
        } else {
            System.out.println("Invalid month");
        }
    }

    // checks to see if the compareTo date is after the date this was called on
    public boolean isAfter(Date compareTo) {
        if (compareTo.year >= this.year) {
            if (compareTo.year > this.year) {
                return true;
            } else {
                if (compareTo.month >= this.month) {
                    if (compareTo.month > this.month) {
                        return true;
                    } else {
                        if (compareTo.day > this.day) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    // checks to see if two dates are equal in content 
    public boolean equals(Object date) {
        if (date instanceof Date) {
            Date other = (Date) date;
            if (this.month == other.month && this.year == other.year && this.day == other.day) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // simple to string method that formats the month and day depending on if they're a single or double digit value
    public String toString() {
        if (this.month < 10) {
            if (this.day < 10) {
                String res = ("0" + this.month + "/0" + this.day + "/" + this.year);
                return res;
            } else {
                String res = ("0" + this.month + "/" + this.day + "/" + this.year);
                return res;
            }
        } else {
            if (this.day < 10) {
                String res = (this.month + "/0" + this.day + "/" + this.year);
                return res;
            } else {
                String res = (this.month + "/" + this.day + "/" + this.year);
                return res;
            }
        }
    }

}
