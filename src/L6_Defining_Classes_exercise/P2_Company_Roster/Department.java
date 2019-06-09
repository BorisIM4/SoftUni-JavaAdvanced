package L6_Defining_Classes_exercise.P2_Company_Roster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;

    public Department(){
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);

    }

    public double getAverageSalary() {
            return this.employees
                    .stream()
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .getAsDouble();
    }
}
