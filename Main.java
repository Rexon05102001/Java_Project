import java.util.*;

class Reservation {
    private String guestName;
    private int roomNumber;
    private boolean isReserved;

    public Reservation(String guestName, int roomNumber) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.isReserved = true;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

public class Main {
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Make Reservation");
            System.out.println("2. View Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    viewReservation();
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();

        for (Reservation reservation : reservations) {
            if (reservation.getRoomNumber() == roomNumber && reservation.isReserved()) {
                System.out.println("Sorry, this room is already reserved.");
                return;
            }
        }

        Reservation reservation = new Reservation(guestName, roomNumber);
        reservations.add(reservation);
        System.out.println("Reservation successful!");
    }

    private static void viewReservation() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("Reservations:");
            for (Reservation reservation : reservations) {
                System.out.println("Room: " + reservation.getRoomNumber() + ", Guest: " + reservation.getGuestName());
            }
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter room number to cancel reservation: ");
        int roomNumber = scanner.nextInt();

        for (Reservation reservation : reservations) {
            if (reservation.getRoomNumber() == roomNumber && reservation.isReserved()) {
                reservation.cancelReservation();
                System.out.println("Reservation for room " + roomNumber + " cancelled.");
                return;
            }
        }

        System.out.println("No reservation found for room " + roomNumber);
    }
}