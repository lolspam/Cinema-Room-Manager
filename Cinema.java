package cinema;
import java.util.Scanner;
public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static int rows = 0, c = 0, nop = 0, inc = 0;
    public static void main(String[] args) {
        // Write your code here
        
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        c = sc.nextInt();
        char[][] seats = new char[rows][c];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < c; j++){
                seats[i][j] = 'S';
            }
        }
        menu(seats);
    }
    public static void pf(char[][] seats){
        //print seats function
        System.out.print("Cinema: \n ");
        for (int i = 0; i < rows; i++){
            if (i == 0) for (int k = 0; k < c; k++) System.out.print(" " + (k + 1));
            System.out.println();
            System.out.print(i + 1);
            for (int j = 0; j < c; j++){
                System.out.print(" " + seats[i][j]);
            }
        }
        System.out.println();
    }
    public static void bf(char[][] seats){
        System.out.println("Enter a row number:");
        int buyr = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int buyc = sc.nextInt();
        if (buyr > rows || buyr <= 0 || buyc > c || buyc <= 0) {
            System.out.println("Wrong input!");
            bf(seats);
        }
        else if (seats[buyr - 1][buyc - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            bf(seats);
        } else {
            System.out.print("\nTicket price: $");
            int total = rows * c;
            if (total <= 60) {
                System.out.print(10);
                inc += 10;
            } else {
                if (rows % 2 == 0) {
                    System.out.print((buyr <= (rows / 2)) ? 10 : 8 );
                    inc += (buyr <= (rows / 2)) ? 10 : 8;
                }
                else {
                    System.out.print((buyr <= (rows / 2)) ? 10 : 8 );
                    inc += (buyr <= (rows / 2)) ? 10 : 8;
                }
            }
            seats[buyr - 1][buyc - 1] = 'B';
            nop ++;
            System.out.println();
        }
    }
    public static void stats(char[][] seats) {
        int total = rows * c;
        int totalInc = 0;
        if (total <= 60) {
                totalInc = 10 * total;
            } else {
                if (rows % 2 == 0) {
                    totalInc = 9 * total;
                }
                else {
                    totalInc = rows / 2 * c * 10 + (rows / 2 + 1) * c * 8;
                }
            }
        System.out.printf("Number of purchased tickets: %d%nPercentage: %.2f%%%nCurrent income: $%d%nTotal income: $%d%n",
        nop, (nop / (double)total * 100.0), inc, totalInc
        );
    }
    public static void menu(char[][] seats) {
        int in1 = 10;
        while (in1 != 0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            in1 = sc.nextInt();
            if (in1 == 1) {
                pf(seats);
            } else if (in1 == 2) {
                bf(seats);
            } else if (in1 == 3) {
                stats(seats);
            }
        }
    }
}
