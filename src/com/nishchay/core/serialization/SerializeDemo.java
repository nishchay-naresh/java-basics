package com.nishchay.core.serialization;

import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        serialize();
        deSerialize();


    }


    private static void serialize() {
        Employee e = new Employee(123, "Reyan Harris", "Street 10, South Block", 4000);
        try {
            FileOutputStream fileOut = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.print("\nSerialized data is saved in file.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static void deSerialize() {

        Employee emp = null;
        try {
            FileInputStream fileIn = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            emp = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found");
            e.printStackTrace();
        }
        System.out.print("\nDeserialized Employee = " + emp);
    }

}
