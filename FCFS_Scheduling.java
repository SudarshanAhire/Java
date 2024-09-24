import java.util.*;

// this is one of the scheduling algoritham  fcfs used inn operating system

class Process {
    int id, burstTime, arrivalTime;
    int waitingTime = 0, turnaroundTime = 0;

    Process(int id, int burstTime, int arrivalTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }
}

public class FCFS_Scheduling {

    // FCFS Algorithm
    public void fcfs(List<Process> processes) {
        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;  // Wait for the process to arrive
            }
            p.waitingTime = currentTime - p.arrivalTime;  // Time the process has to wait
            currentTime += p.burstTime;  // Update the current time
            p.turnaroundTime = p.waitingTime + p.burstTime;  // Turnaround time = Waiting time + Burst time
        }
    }

    // Function to display the results
    public void display(List<Process> processes) {
        System.out.println("\nID\tBurst Time\tArrival Time\tWaiting Time\tTurnaround Time");
        for (Process p : processes) {
            System.out.println(p.id + "\t" + p.burstTime + "\t\t" + p.arrivalTime + "\t\t" + p.waitingTime + "\t\t" + p.turnaroundTime);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Input for Number of Processes
        System.out.println("Enter the number of processes: ");
        int numProcesses = sc.nextInt();

        // List to store all the processes
        List<Process> processes = new ArrayList<>();

        // Taking user input for each process's burst time and arrival time
        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter details for Process " + (i + 1));
            System.out.print("Burst Time: ");
            int burstTime = sc.nextInt();
            System.out.print("Arrival Time: ");
            int arrivalTime = sc.nextInt();

            // Adding the process to the list
            processes.add(new Process(i + 1, burstTime, arrivalTime));
        }

        // Sort processes by arrival time to implement FCFS
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        // Creating an object of FCFS_Scheduling to call the methods
        FCFS_Scheduling scheduler = new FCFS_Scheduling();
        scheduler.fcfs(processes);  // Call FCFS Algorithm
        scheduler.display(processes);  // Display the results
    }
}
