package com.nishchay.util.pojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class CSVReader {


   private final AtomicInteger employeeID = new AtomicInteger(0);

   public static void main(String[] args) {

      readEmpListFromCSV().forEach(System.out::println);

   }

   public static List<Employee> readEmpListFromCSV() {
      CSVReader csvReader = new CSVReader();
      return csvReader.read();
   }

   public List<Employee> read() {
      String csvFile = "src/resources/employee.csv";
      List<Employee> empList = new ArrayList<>(50);

      try {
         File file = new File(csvFile);
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         // skipping first line for columns
         String line = br.readLine();

         while((line = br.readLine()) != null) {
            empList.add(parseLine(line));
         }
         br.close();
         } catch(IOException ioe) {
            ioe.printStackTrace();
         }
      return empList;
   }

   public int generateUniqueEmpID() {
      return employeeID.incrementAndGet();
   }


   public Employee parseLine(String line){

      String[] fields = line.split(",");
      int i = 0;
      String name = fields[i++];
      char gender = fields[i++].charAt(0);
      long telephone = Long.parseLong(fields[i++]);
      boolean current = Boolean.parseBoolean(fields[i++]);
      int ssn = Integer.parseInt(fields[i++]);
      double salary = Double.parseDouble(fields[i++]);
      int birthDay = Integer.parseInt(fields[i++]);
      int birthMonth = Integer.parseInt(fields[i++]);
      int birthYear = Integer.parseInt(fields[i++]);
      int houseNumber = Integer.parseInt(fields[i++]);
      String streetAddress = fields[i++];
      String cityAddress = fields[i++];
      String countryAddress = fields[i++];
      double bonus = Double.parseDouble(fields[i++]);
      long cellNUmber = Long.parseLong(fields[i++]);

      return new Employee(generateUniqueEmpID(),
              name,
              gender,
              telephone,
              current,
              ssn,
              salary,
              birthDay,
              birthMonth,
              birthYear,
              houseNumber,
              streetAddress,
              cityAddress,
              countryAddress,
              bonus,
              cellNUmber);

   }

}