public class gufu {
    public static void main(String[] args) {
        int n = 5;  // Number of rows

        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            // Print stars
            for (int k = 0; k < (n - i) * 2 - 1; k++) {
                System.out.print("* ");
            }

            // Move to the next line
            System.out.println();
        }
    }
}
