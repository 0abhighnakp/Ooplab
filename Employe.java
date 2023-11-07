import java.util.Scanner;

class Employee {
    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    public void printSalary() {
        System.out.println("Salary: " + salary);
    }

    public void setEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        System.out.print("Phone Number: ");
        phoneNumber = scanner.next();
        scanner.nextLine(); // Consume newline character
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
    }
}

class Officer extends Employee {
    String specialization;

    public void setOfficerDetails() {
        setEmployeeDetails(); // Reuse the base class method
        Scanner scanner = new Scanner(System.in);
        System.out.print("Specialization: ");
        specialization = scanner.nextLine();
    }

    public void printOfficerDetails() {
        System.out.println("\nOfficer Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Salary: " + salary);
        System.out.println("Specialization: " + specialization);
        printSalary();
    }
}

class Manager extends Employee {
    String department;

    public void setManagerDetails() {
        setEmployeeDetails(); // Reuse the base class method
        Scanner scanner = new Scanner(System.in);
        System.out.print("Department: ");
        department = scanner.nextLine();
    }

    public void printManagerDetails() {
        System.out.println("\nManager Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        printSalary();
    }
}

public class EmployeeProgram {
    public static void main(String[] args) {
        Officer officer = new Officer();
        Manager manager = new Manager();

        System.out.println("Enter Officer Details:");
        officer.setOfficerDetails();

        System.out.println("\nEnter Manager Details:");
        manager.setManagerDetails();

        officer.printOfficerDetails();
        manager.printManagerDetails();
    }
}
