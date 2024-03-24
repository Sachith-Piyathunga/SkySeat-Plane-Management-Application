//w2053013 - Sachintha chamod

import java.io.IOException;//add this class for handling input-output exceptions
import java.util.InputMismatchException;//add this class to check input provided by the user does not match the expected type
import java.util.Scanner;//add this class to be used for obtaining user input from the keyboard


//main class for manage for seat reservation on a plane
public class w2053013_PlaneManagement
{

    //define a 2D array to represent the seating plan in the plane
    private static final Seat[][] seatingPlan = {
            {new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat()},
            {new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat()},
            {new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat()},
            {new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat()}
    };
    private static final Ticket[] tickets = new Ticket[52]; //an array for store all the sold tickets during the process
    private static final Scanner scanner = new Scanner(System.in); //scanner object to get user inputs

    public static void main(String[] args)  //main method to start the program
    {
        //display the welcome message
        System.out.println("\n" + "*".repeat(50) + "".repeat(16));
        System.out.println("\n" + "*".repeat(5) + " Welcome to the Plane Management System " + "*".repeat(5));

        int choice; //variable to store user choice
        do //loop until the user choose quit
        {
            System.out.println("\n" + "*".repeat(50) + " ".repeat(16));
            System.out.println("\n1. Buy a seat");

            System.out.println("2. Cancel a seat");
            System.out.println("3. Find first available seat");
            System.out.println("4. Show seating plan");
            System.out.println("5. Print tickets information and total sales");
            System.out.println("6. Search ticket");
            System.out.println("0. Quit");
            System.out.println("\n" + "*".repeat(50));
            System.out.print("Please enter your choice: ");
            //get user choice
            choice = acquireChoice();
        } while (choice > 0); //continue the loop  until user choose to quit

        scanner.close(); //close the scanner object
    }

    private static int acquireChoice() //method to get user choice
    {
        int choice = 0;
        try
        {
            //try to get user input
            choice = scanner.nextInt(); //Consume newline character
            scanner.nextLine();
            //process for user choice
            switch (choice)
            {
                case 1:
                    buySeat();
                    break;
                case 2:
                    cancelSeat();
                    break;
                case 3:
                    findFirstAvailable();
                    break;
                case 4:
                    showSeatingPlan();
                    break;
                case 5:
                    printTicketsInfo();
                    break;
                case 6:
                    searchTicket();
                    break;
                case 0:
                    System.out.println("Quiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e)
        {
            //handling invalid inputs exception
            System.out.println("Invalid choice. Please try again.");
            scanner.nextLine();
            choice = 1; //set default choice to buy a seat
        }
        return choice;
    }

    //method to add a ticket to the  array of tickets
    private static void addTicket(Ticket ticket)
    {
        for (int i = 0; i < tickets.length; i++)
        {
            if (tickets[i] == null)
            {
                tickets[i] = ticket;
                break;
            }
        }
    }

    //method tho remove a ticket from the array of tickets
    private static void removeTicket(char row, int seatNumber)
    {
        for (int i = 0; i < tickets.length; i++)
        {
            if (tickets[i].getRow() == row && tickets[i].getSeat() == seatNumber)
            {
                tickets[i] = null;
                break;
            }
        }
    }

    //method to check if a string contains only non-integer characters
    private static boolean nonIntegerStringCorrect(String str)
    {
        if (str.isEmpty())
        {
            return false;
        } else return str.matches("[a-zA-Z]+");
    }

    //method to check if roe character is correct
    private static boolean rowCorrect(char row)
    {
        return switch (row)
        {
            case 'A', 'C', 'B', 'D' -> true;
            default -> false;
        };
    }

    //method to get row index based on the roe character
    private static int getRowIndex(char row)
    {
        return switch (row)
        {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            default -> -1;
        };
    }

    //method to check if a seat number is correct for a given roe
    private static boolean seatNumberCorrect(char row, int seatNumber)
    {
        if (row == 'A' || row == 'B')
        {
            return seatNumber >= 1 && seatNumber <= 14;
        } else
        {
            return seatNumber >= 1 && seatNumber <= 12;
        }
    }

    //method to get the row from the user
    private static char acquireRow()
    {
        System.out.print("Enter row (A-D): ");
        String rowStr = scanner.nextLine().toUpperCase();
        if (!nonIntegerStringCorrect(rowStr))
        {
            System.out.println("row cannot be empty or have numbers");
            return 0;
        }
        char row = rowStr.charAt(0);
        if (!rowCorrect(row))
        {
            System.out.println("row cannot be identified");
            return 0;
        }
        return row;
    }

    //method to get the seat number from user
    private static int acquireSeat(char row)
    {
        try
        {
            System.out.print("Enter seat number: ");
            int seat = scanner.nextInt();
            if (!seatNumberCorrect(row, seat))
            {
                System.out.println("seat cannot be identified");
                return -1;
            }
            scanner.nextLine();
            return seat;
        } catch (Exception e)
        {
            scanner.nextLine();
            return -1;
        }
    }

    //method to get a string input from the user for various purposes
    private static String acquireStr(String enterWhat)
    {
        System.out.print("Enter your " + enterWhat + " : ");
        String str = scanner.nextLine();
        if (!nonIntegerStringCorrect(str))
        {
            System.out.println(enterWhat + " cannot be empty or have numbers");
            return null;
        }
        return str;
    }

    //method to get an email from user (email format)
    private static String acquireEmail()
    {
        System.out.print("Enter your email : ");
        String str = scanner.nextLine();
        if (!str.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zAZ]{2,6}$"))
        {
            System.out.println("email cannot be identified");
            return null;
        }
        return str;
    }

    //method to handle the process of buying seat
    private static void buySeat()
    {
        char row = acquireRow();
        if (row == 0)
        {
            return;
        }
        int rowIndex = getRowIndex(row);
        int seat = acquireSeat(row);
        if (seat == -1)
        {
            return;
        }

        Seat chosenSeat = seatingPlan[rowIndex][seat - 1];
        if (chosenSeat.isAvailable())
        {
            String name = acquireStr("name");
            if (name == null)
            {
                return;
            }
            String surname = acquireStr("surname");
            if (surname == null)
            {
                return;
            }
            String email = acquireEmail();
            if (email == null)
            {
                return;
            }

            Person person = new Person(name, surname, email);
            chosenSeat.sellSeat();

            Ticket ticket = new Ticket(row, seat, person);
            try
            {
                addTicket(ticket);
                ticket.saveTicketInfoToFile();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println("Ticket bought successfully!");
        } else {
            System.out.println("Seat already sold or invalid seat.");
        }
    }

    //method to handle the process of  canceling a seat
    private static void cancelSeat()
    {
        char row = acquireRow();
        if (row == 0)
        {
            return;
        }
        int rowIndex = getRowIndex(row);
        int seat = acquireSeat(row);
        if (seat == -1)
        {
            return;
        }

        if (!seatingPlan[rowIndex][seat - 1].isAvailable())
        {
            removeTicket(row, seat);
            seatingPlan[rowIndex][seat - 1].freeSeat();
            System.out.println("Seat cancelled successfully!");
        } else
        {
            System.out.println("Seat already available or invalid seat.");
        }
    }

    //method to find first available seat
    private static void findFirstAvailable()
    {
        for (int row = 0; row < seatingPlan.length; row++)
        {
            for (int seat = 0; seat < seatingPlan[row].length; seat++)
            {
                if (seatingPlan[row][seat].isAvailable())
                {
                    System.out.println("First available seat: Row " + (char) ('A' + row) + ", Seat " + (seat + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    //method to display the seating plan
    private static void showSeatingPlan()
    {
        System.out.println("\nSeating Plan:");
        System.out.print("  ");
        for (int i = 1; i <= seatingPlan[1].length; i++)
        {
            System.out.printf("%-3d", i);
        }
        System.out.println();
        for (int row = 0; row < seatingPlan.length; row++)
        {
            System.out.print((char) ('A' + row) + " ");
            for (Seat seat : seatingPlan[row])
            {
                System.out.printf("%-3s", seat.value == 0 ? "O" : "X");
            }
            System.out.println();
        }
    }

    //method to print ticket information
    private static void printTicketsInfo()
    {
        // This method is already implemented in Part B
        int totalAcquiredTicketPrices = 0;
        for (Ticket ticket: tickets){
            if (ticket == null)
            {
                continue;
            }
            ticket.printTicketInfo();
            System.out.println();
            totalAcquiredTicketPrices += ticket.getPrice();
        }
        System.out.println("Total acquired ticket prices : " + totalAcquiredTicketPrices);
    }

    //method to search for a ticket
    private static void searchTicket()
    {
        // This method is already implemented in Part B
        char row = acquireRow();
        if (row == 0)
        {
            return;
        }
        int rowIndex = getRowIndex(row);
        int seat = acquireSeat(row);
        if (seat == -1)
        {
            return;
        }

        if (seatingPlan[rowIndex][seat - 1].isAvailable())
        {
            System.out.println("Seat available");
            return;
        }

        for (Ticket ticket: tickets)
        {
            if (ticket == null)
            {
                continue;
            }
            if (ticket.getRow() == row && ticket.getSeat() == seat)
            {
                ticket.printTicketInfo();
                break;
            }
        }
    }

}