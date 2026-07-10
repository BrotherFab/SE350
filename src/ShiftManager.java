package src;

import java.util.ArrayList;

public class ShiftManager {
    private ArrayList<Patient> patients;
    private ArrayList<CareTask> tasks;

    public ShiftManager() {
        patients = new ArrayList<Patient>();
        tasks = new ArrayList<CareTask>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addTask(CareTask task) {
        tasks.add(task);
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<CareTask> getTasks() {
        return tasks;
    }
}
