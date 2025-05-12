package chapter7._livecode;

import java.io.*;

public class FileIO {
    public static void main(String[] args) {

        try (FileOutputStream fos = new FileOutputStream("chapter7/_livecode/test.txt")) {
            fos.write("Hello world!!! 안녕하세요!!".getBytes());
        } catch (IOException e) {

        }

        try (FileInputStream fis = new FileInputStream("chapter7/_livecode/test.txt")) {
            int data;

            while ((data = fis.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (IOException e) {

        }

        System.out.println();
        try (FileReader fileReader = new FileReader("chapter7/_livecode/test.txt")) {
            int data;
            while((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {

        }

    }
}
