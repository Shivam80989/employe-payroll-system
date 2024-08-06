import java.util.ArrayList;

abstract class Employee
{
    private String name;
    private int id;
    public Employee(String name ,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;

    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();

@Override
    public String toString(){
        return "Employee [name="+name+",salary="+calculateSalary()+"]";
    }
}
 class FullTimeEmploye extends Employee{
    private double monthlySalary;
    public FullTimeEmploye(String name,int id,double monthlySalary){
        // construtor se le rhe hai to super keyword use krna pd rh hai 
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

@Override
public double calculateSalary(){
    return monthlySalary;
}

}


 class PartTimeEmploye extends Employee{
    private int houseWorked;
    private double houseRate;

    public PartTimeEmploye(String name,int id,int houseWorked,double houseRate){
        super(name,id);
        this.houseWorked=houseWorked;
        this.houseRate=houseRate;
    }
    @Override
    public double calculateSalary(){
        return houseWorked*houseRate;
    }

}
 class PayrollSystem{
    private ArrayList<Employee> employeeList;


public PayrollSystem(){
    employeeList=new ArrayList<>();
}

public void addEmployee(Employee employee){
    employeeList.add(employee);

}
public void removeEmployee(int id){
    Employee employeetoremove=null;
    for(Employee employee:employeeList){
        if(employee.getId()==id){
            employeetoremove=employee;
            break;
        }
    }
    if(employeetoremove!=null){
        employeeList.remove(employeetoremove);
    }
}
    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);

    }
}

}



public class Main{
    public static void main(String[] args) {
        PayrollSystem payrollsystem=new PayrollSystem();
        FullTimeEmploye emp1=new FullTimeEmploye("vikas",1,40000);
        PartTimeEmploye emp2=new PartTimeEmploye("alexander",2 ,48,100);
        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        System.out.println("initializing employe detail");
        payrollsystem.displayEmployees();
        System.out.println("removing employe");
        // payrollsystem.removeEmployee(emp2);
        System.out.println("remaining employe");


        
        payrollsystem.displayEmployees();

        
    }
}