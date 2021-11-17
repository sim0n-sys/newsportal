package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DepartmentsTest {
    public Departments newDepartment(){
        return new Departments("Cleaning", "we aim to clean", 2);
    }
    @Test
    public void departmentNewsInstantiatesCorrectly() {
        Departments departments = newDepartment();
        assertTrue(departments instanceof Departments);
    }

    @Test
    public void getCorrectName(){
        Departments departments = newDepartment();
        assertTrue("Cleaning".equals(departments.getName()) );
    }

    @Test
    public void getCorrectNoEmployees(){
        Departments departments = newDepartment();
        assertEquals(2, departments.getNumberOfEmployees());
    }

    @Test
    public void getCorrectDescription(){
        Departments departments = newDepartment();
        assertEquals("we aim to clean", departments.getDescription());
    }

}