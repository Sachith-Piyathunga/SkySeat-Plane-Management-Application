# ✈️ SkySeat Plane Management System - Java Console Application

This is a console-based **Plane Seat Reservation System** developed in Java. The application allows users to reserve, cancel, search, and manage plane seating. It demonstrates fundamental Object-Oriented Programming concepts, including encapsulation, modularity, and file handling.

---

## 📌 Project Overview

The application simulates seat reservations for a plane. Users can:
- View the seat map
- Buy or cancel a seat
- Search for ticket information
- Print all sold ticket details and total sales
- Save ticket information to a `.txt` file

---

## 🧑‍💻 Developed By

- **Name:** Sachintha Chamod  
- **ID:** w2053013

---

## 🛠️ Features

- Seat reservation with real-time status updates
- Ticket cancellation and re-availability of seats
- Ticket details storage in external `.txt` files
- Input validation for names, email, seat numbers, and row letters
- Pricing based on seat location
- Robust exception handling for user input

---

## 🧩 Project File Structure

- PlaneManagementSystem/
- │
- ├── w2053013_PlaneManagement.java # Main class with UI and all menu logic
- ├── Person.java # Class to handle passenger details
- ├── Seat.java # Class to represent a single seat's status
- └── Ticket.java # Class to manage ticket info, pricing, and file writing

---

## ✅ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/plane-management-system.git
   cd plane-management-system

2. **Compile all Java files**

   ```bash
   javac *.java

3. **Run the main class**

   ```bash
   java w2053013_PlaneManagement

---

## 📷 Sample Output

1.  **Main Screen**

![image alt](https://github.com/Sachith-Piyathunga/SkySeat-Plane-Management-Application/blob/b5967fb9b71e33d0b30a70ac05632cb8c7777774/Image/Screenshot_20250616_060036.png)

2. **Seating Plan Screen**

![image alt](https://github.com/Sachith-Piyathunga/SkySeat-Plane-Management-Application/blob/a111cd45596b1dc13c40afd9b94d4babf62c1a11/Image/Screenshot_20250616_060103.png)

---

## 💡 Technologies Used

- Java 17+
- Console-based UI
- File I/O for ticket persistence

---

## 🧠 Object-Oriented Concepts Applied

- Encapsulation: Each class manages its own data.
- Abstraction: Clear interfaces for different operations (seat, ticket, user).
- Separation of Concerns: Logic is divided into separate, manageable classes.
- Exception Handling: Handles input errors gracefully.

---

## 🗂️ Ticket Storage

- Every sold ticket is saved as a text file.
- Files are named like: A5.txt, B3.txt, etc.
- Example contents:

   ```
   Row: A
   Seat: 5
   Price: 180
   Name: John
   Surname: Doe
   Email: john.doe@example.com
