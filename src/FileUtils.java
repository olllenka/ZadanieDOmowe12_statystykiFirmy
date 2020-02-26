import java.io.*;
import java.util.Scanner;

public class FileUtils {

    public static Company createCompanyFromFile(String fileName) throws FileNotFoundException {
        int companySize = countCompanySize(fileName);
        Company company = new Company(companySize);
        addEmployeesToCompanyFromFile(fileName, company);
        return company;
    }

    private static void addEmployeesToCompanyFromFile(String fileName, Company company) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String employeeLine = sc.nextLine();
            String employeeInfo[] = employeeLine.split(";");
            Employee employee = createEmployee(employeeInfo);
            company.addEmployee(employee);
        }
        sc.close();
    }

    private static Employee createEmployee(String[] employeeInfo) {
        String firstName = employeeInfo[0];
        String lastName = employeeInfo[1];
        String pesel = employeeInfo[2];
        String department = employeeInfo[3];
        Double salaryD = Double.valueOf(employeeInfo[4]);
        double salary = salaryD;

        return new Employee(firstName, lastName, pesel, department, salary);
    }

    private static int countCompanySize(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        int companySize = 0;
        while (sc.hasNextLine()){
            sc.nextLine();
            companySize++;
        }
        sc.close();
        return companySize;
    }

    public static void writeCompanyStatsToFile(Company company, String writeFileName) throws IOException {
        FileWriter fileWriter = new FileWriter(writeFileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(company.showAvgSalary());
        writer.newLine();
        writer.write(company.showLowestSalary());
        writer.newLine();
        writer.write(company.showHighestSalary());
        writer.newLine();
        writer.write(company.showCompanySize());
        writer.newLine();
        writer.write(company.showITDepartmentSize());
        writer.newLine();
        writer.write(company.showManagementDepartmentSize());
        writer.newLine();
        writer.write(company.showSupportDepartmentSize());

        writer.close();
    }
}
