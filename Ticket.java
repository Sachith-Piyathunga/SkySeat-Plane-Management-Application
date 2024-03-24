//w2053013 - Sachintha chamod
//import necessary classes for file writing and handling exceptions.
import java.io.FileWriter;
import java.io.IOException;

//define a class as Ticket to represent a Ticket for a seat
class Ticket
{
    //declare variables to store the ticket information
    private char row; //row of the seat
    private int seat; //get seat number
    private int price; //price of the ticket
    private Person person; //person that get the ticket

    //method for initializing ticket information
    Ticket(char row, int seat, Person person)
    {
        this.row = row;
        this.seat = seat;
        this.person = person;
        //decide the price of the ticket based on the seat number
        if (seat == 1 || seat == 2 || seat == 3 || seat == 4 || seat == 5)
        {
            this.price = 200;
        } else if (seat == 6 || seat == 7 || seat == 8 || seat == 9)
        {
            this.price = 150;
        } else
        {
            this.price = 180;
        }
    }

    //add method to access private member variable
    public char getRow() {
        return row;
    }

    public int getPrice() {
        return price;
    }

    public int getSeat() {
        return seat;
    }

    public Person getPerson() {
        return person;
    }
    //set method to modify private member variable

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    //method for print ticket information
    void printTicketInfo()
    {
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
        person.printPersonInfo();
    }

    //method to save ticket information in the file
    void saveTicketInfoToFile() throws IOException
    {
        //create fileWriter object to write a file
        FileWriter fileWriter = new FileWriter(row + "" + seat + ".txt");

        //write the ticket information in the file
        fileWriter.write("Row: " + row + "\n");
        fileWriter.write("Seat: " + seat + "\n");
        fileWriter.write("Price: " + price + "\n");
        fileWriter.write("Name: " + person.getName() + "\n");
        fileWriter.write("Surname: " + person.getSurname() + "\n");
        fileWriter.write("Email: " + person.getEmail() + "\n");
        //close the file writer object
        fileWriter.close();
    }
}