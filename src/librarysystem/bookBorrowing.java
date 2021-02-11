
package librarysystem;

public class bookBorrowing {
     private String name;
    private int date;
    private int month;
    private int year;
    
     public bookBorrowing(String name, int date, int month, int year) {
        this.name = name;
        this.date = date;
        this.month = month;
        this.year = year;

    }

    public String toString() {
        return name + ", " + date + "/" + month + "/" + year;

    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    } 
    
}

