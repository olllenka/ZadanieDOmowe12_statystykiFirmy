public class Company {
    private Employee[] employees;
    private int companySize;
    private static final String IT_DEPARTMENT_NAME = "it";
    private static final String MANAGEMENT_DEPARTMENT_NAME = "Management";
    private static final String SUPPORT_DEPARTMENT_NAME = "Support";


    public Company(int companySize) {
        employees = new Employee[companySize];
    }

    void addEmployee(Employee employee) {
        if(companySize <  employees.length) {
            employees[companySize] = employee;
            companySize++;
        } else {
            System.out.println("Nie m wolnych etatów");
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public double avgSalary(){
        double sumOfSalary = 0;
        for (Employee employee:employees) {
            sumOfSalary+=employee.getSalary();
        }
        return sumOfSalary/employees.length;
    }

    public double lowestSalary(){
        double lowestSalary = employees[0].getSalary();
        for (Employee employee:employees) {
            if(employee.getSalary()<lowestSalary){
                lowestSalary=employee.getSalary();
            }
        }
        return lowestSalary;
    }

    public double highestSalary(){
        double highestSalary = employees[0].getSalary();
        for (Employee employee:employees) {
            if(employee.getSalary()>highestSalary){
                highestSalary=employee.getSalary();
            }
        }
        return highestSalary;
    }

    public double countDepartmentEmployees(String departmentName){
        if(departmentName.equals(IT_DEPARTMENT_NAME))
            return countITDepartment();
        else if(departmentName.equals(MANAGEMENT_DEPARTMENT_NAME))
            return countManagementDepartment();
        else if(departmentName.equals(SUPPORT_DEPARTMENT_NAME))
            return countSupportDepartment();
        return 0;
    }

    public double countITDepartment(){
        int ITSize=0;
        for (Employee employee:employees) {
            if(employee.getDepartment().equals(IT_DEPARTMENT_NAME)){
                ITSize++;
            }
        }
        return ITSize;
    }

    public double countManagementDepartment(){
        int managementSize=0;
        for (Employee employee:employees) {
            if(employee.getDepartment().equals(MANAGEMENT_DEPARTMENT_NAME)){
                managementSize++;
            }
        }
        return managementSize;
    }

    public double countSupportDepartment(){
        int supportSize=0;
        for (Employee employee:employees) {
            if(employee.getDepartment().equals(SUPPORT_DEPARTMENT_NAME)){
                supportSize++;
            }
        }
        return supportSize;
    }

    public String showAvgSalary(){
        double avgSalary = avgSalary();
        return "Srednina wypłata: " + avgSalary;
    }

    public String showLowestSalary(){
        double lowestSalary = lowestSalary();
        return "Najmniejsza wypłata: " + lowestSalary;
    }

    public String showHighestSalary(){
        double highestSalary = highestSalary();
        return "Największa wypłata: " + highestSalary;
    }

    public String showITDepartmentSize(){
        double departmentSize = countDepartmentEmployees(IT_DEPARTMENT_NAME);
        return "Liczba pracowników w dziale IT: " + departmentSize;
    }

    public String showManagementDepartmentSize(){
        double departmentSize = countDepartmentEmployees(MANAGEMENT_DEPARTMENT_NAME);
        return "Liczba pracowników w dziale Management: " + departmentSize;
    }

    public String showSupportDepartmentSize(){
        double departmentSize = countDepartmentEmployees(SUPPORT_DEPARTMENT_NAME);
        return "Liczba pracowników w dziale Support: " + departmentSize;
    }

    public String showCompanySize(){
        return "Łączna liczba pracowników: " + companySize;
    }
}
