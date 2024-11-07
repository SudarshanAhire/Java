import java.util.*;

class assemblerpass1 {
    static int locationCounter = 0;
    static Map<String, Integer> symbolTable = new LinkedHashMap<>();
    static List<String> literalTable = new ArrayList<>();
    static List<Integer> literalAddress = new ArrayList<>();
    static List<Integer> poolTable = new ArrayList<>();

    public static void main(String[] args) {
        String[] code = {
            "START 100", "A DS 3", "L1 MOVER AREG, B", "ADD AREG, C",
            "MOVEM AREG, ='2'", "MOVEM AREG, ='3'", "D EQU A+1", "LTORG",
            "L2 PRINT D", "MOVEM AREG, ='4'", "MOVEM AREG, ='5'", "ORIGIN L2+1",
            "LTORG", "B DC '19'", "C DC '17'", "END"
        };
        
        processCode(code);
        displayTables();
    }

    static void processCode(String[] code) {
        for (String line : code) {
            String[] parts = line.split(" ");
            switch (parts[0]) {
                case "START":
                    locationCounter = Integer.parseInt(parts[1]);
                    break;

                case "DS":
                    symbolTable.put(parts[0], locationCounter);
                    locationCounter += Integer.parseInt(parts[2]);
                    break;

                case "DC":
                    symbolTable.put(parts[0], locationCounter);
                    locationCounter++;
                    break;

                case "EQU":
                    int address = symbolTable.get(parts[2].split("\\+")[0]) + Integer.parseInt(parts[2].split("\\+")[1]);
                    symbolTable.put(parts[0], address);
                    break;

                case "LTORG":
                    handleLTORG();
                    break;

                case "END":
                    handleLTORG();
                    break;

                case "ORIGIN":
                    locationCounter = symbolTable.get(parts[1].split("\\+")[0]) + Integer.parseInt(parts[1].split("\\+")[1]);
                    break;

                default:
                    if (line.contains("='")) {  // Handling literals
                        String literal = parts[2];
                        if (!literalTable.contains(literal)) {
                            literalTable.add(literal);
                            literalAddress.add(-1); // Address will be assigned on LTORG
                        }
                    } else {  // Handling symbols
                        if (!symbolTable.containsKey(parts[0])) {
                            symbolTable.put(parts[0], locationCounter);
                        }
                        locationCounter++;
                    }
                    break;
            }
        }
    }

    static void handleLTORG() {
        poolTable.add(literalTable.size());
        for (int i = 0; i < literalTable.size(); i++) {
            if (literalAddress.get(i) == -1) {  // If address not assigned
                literalAddress.set(i, locationCounter);
                locationCounter++;
            }
        }
    }

    static void displayTables() {
        System.out.println("Symbol Table:");
        symbolTable.forEach((key, value) -> System.out.println(key + " : " + value));
        
        System.out.println("\nLiteral Table:");
        for (int i = 0; i < literalTable.size(); i++) {
            System.out.println(literalTable.get(i) + " : " + literalAddress.get(i));
        }

        System.out.println("\nPool Table:");
        for (Integer pool : poolTable) {
            System.out.println(pool);
        }
    }
}