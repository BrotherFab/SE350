package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ShiftManager shiftManager = new ShiftManager();

    public static void main(String[] args) {
        System.out.println("Nursing Shift Manager");
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addPatient();
                    break;
                case "2":
                    addTask();
                    break;
                case "3":
                    recordVitals();
                    break;
                case "4":
                    viewTasks();
                    break;
                case "5":
                    updateTaskStatus();
                    break;
                case "6":
                    printSummary();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("End of shift. Goodbye.");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Add patient");
        System.out.println("2. Add care task");
        System.out.println("3. Record vitals");
        System.out.println("4. View tasks");
        System.out.println("5. Update task status");
        System.out.println("6. End-of-shift summary");
        System.out.println("0. Quit");
        System.out.print("Choose an option: ");
    }

    private static void addPatient() {
        System.out.print("Patient name: ");
        String name = scanner.nextLine().trim();
        shiftManager.addPatient(new Patient(name));
        System.out.println("Added patient: " + name);
    }

    private static void addTask() {
        System.out.print("Task description: ");
        String description = scanner.nextLine().trim();
        TaskPriority priority = readPriority();
        shiftManager.addTask(new CareTask(description, priority));
        System.out.println("Added task: " + description);
    }

    private static void recordVitals() {
        Patient patient = selectPatient();
        if (patient == null) {
            return;
        }
        double temperature = readDouble("Temperature: ");
        int heartRate = readInt("Heart rate: ");
        patient.recordVitals(new VitalSigns(temperature, heartRate));
        System.out.println("Recorded vitals for " + patient.getName());
    }

    private static void viewTasks() {
        ArrayList<CareTask> tasks = shiftManager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }

    private static void updateTaskStatus() {
        CareTask task = selectTask();
        if (task == null) {
            return;
        }
        TaskStatus status = readStatus();
        task.setStatus(status);
        System.out.println("Updated: " + task);
    }

    private static void printSummary() {
        System.out.println();
        System.out.println("=== End of Shift Summary ===");
        System.out.println("Patients:");
        for (Patient patient : shiftManager.getPatients()) {
            VitalSigns vitals = patient.getLatestVitals();
            String vitalsText = vitals == null ? "no vitals recorded" : vitals.toString();
            System.out.println("  " + patient.getName() + " - " + vitalsText);
        }
        System.out.println("Tasks:");
        for (CareTask task : shiftManager.getTasks()) {
            System.out.println("  " + task);
        }
    }

    private static Patient selectPatient() {
        ArrayList<Patient> patients = shiftManager.getPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients.");
            return null;
        }
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(i + ". " + patients.get(i).getName());
        }
        int index = readInt("Select patient number: ");
        if (index < 0 || index >= patients.size()) {
            System.out.println("Invalid patient.");
            return null;
        }
        return patients.get(index);
    }

    private static CareTask selectTask() {
        ArrayList<CareTask> tasks = shiftManager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return null;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
        int index = readInt("Select task number: ");
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task.");
            return null;
        }
        return tasks.get(index);
    }

    private static TaskPriority readPriority() {
        while (true) {
            System.out.print("Priority (LOW, MEDIUM, HIGH): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return TaskPriority.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority.");
            }
        }
    }

    private static TaskStatus readStatus() {
        while (true) {
            System.out.print("Status (PENDING, IN_PROGRESS, COMPLETED): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return TaskStatus.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status.");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Enter a number.");
            }
        }
    }
}
