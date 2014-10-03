/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class EmployeeDirectory {
    ArrayList<Employee> employeeDirectory;
    
    public EmployeeDirectory()
    {
        employeeDirectory = new ArrayList<Employee>(); 
    }

    public ArrayList<Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }
     public Employee newEmployee()
    {
        Employee employee = new Employee();
        employeeDirectory.add(employee);
        return employee;
    }
    
}
