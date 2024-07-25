# Car Wash Reservation System

## Project Overview
This project is a Java-based Object-Oriented Programming (OOP) system for managing car wash reservations. The system allows users to create, cancel, and manage car wash reservations. It also includes functionality for washing center staff to confirm and perform washing tasks.

## Use Cases and Alternate Paths

### Use Case 1: Create Washing Reservation
1. **User Login and Enter System**
   - The user logs in to the system. (req 1)
2. **User Registration**
   - If the user is not registered, they select the register option. (req 1)
   - The user enters their name, surname, and phone number. (req 1)
   - The user returns to the main menu. (No requirement)
3. **Select Washing Type**
   - The user selects how they want their car washed (inner, outer, or both). (req 2)
4. **Select Washing Center**
   - The user selects the washing center. (req 3)
5. **Book Time Slot**
   - The user books an available time slot. (req 4)
6. **System Termination**
   - The system terminates. (req 9)

### Use Case 2: Cancel Reservation
1. **User Login and Enter System**
   - The user logs in to the system. (req 1)
2. **User Registration**
   - If the user is not registered, they select the register option. (req 1)
   - The user enters their name, surname, and phone number. (req 1)
   - The user returns to the main menu. (No requirement)
3. **Cancel Reservation**
   - The user cancels their reservation. (req 5)
   - The car wash center cancels the reservation. (req 6)
   - The user is notified that their reservation has been canceled by the car wash center. (req 8)
4. **System Termination**
   - The system terminates. (req 9)

### Use Case 3: Washing Process
1. **User Login and Enter System**
   - The user logs in to the system. (req 1)
2. **User Registration**
   - If the user is not registered, they select the register option. (req 1)
   - The user enters their name, surname, and phone number. (req 1)
   - The user returns to the main menu. (No requirement)
3. **Reservation Confirmation**
   - The washing center staff confirm the reservation. (req 6)
4. **Car Washing**
   - The washing center staff clean the user's car. (req 7)
5. **System Termination**
   - The system terminates. (req 9)

## Installation and Setup
To run this project, you need to have Java Development Kit (JDK) installed. You can download the JDK from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

1. **Clone the Repository**
   ```sh
   git clone https://github.com/yourusername/car-wash-reservation-system.git
   cd car-wash-reservation-system
