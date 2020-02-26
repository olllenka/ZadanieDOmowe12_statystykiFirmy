import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String readFileName = "employeeList.txt";
        Company company = null;

        try {
            company = FileUtils.createCompanyFromFile(readFileName);
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku!");
        }

        String writeFileName = "CompanyStatistics.txt";
        try {
            FileUtils.writeCompanyStatsToFile(company, writeFileName);
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + writeFileName);
        }
    }
}

