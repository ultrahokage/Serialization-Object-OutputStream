package ua.ultra;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();

    public static void main(String[] args) {

        profiles = (ArrayList<Profile>) deserData("profiles");
        Profile profile = new Profile();
        profile.setName(JOptionPane.showInputDialog(null, "Введите ваше Имя"));
        profile.setSurname(JOptionPane.showInputDialog(null, "Введите вашу Фамилию"));
        profiles.add(profile);
        for(Profile p : profiles) {
            System.out.println(p.getName()+" "+p.getSurname());
        }
        System.out.println(profiles.size());
        serData("profiles", profiles);
    }

    private static Object deserData(String file_name) {
        Object retObject = null;
        try {
            FileInputStream fileIn = new FileInputStream(file_name + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка вводла/вывода");
            System.exit(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
            System.exit(3);
        }
        return retObject;
    }

    private static void serData(String file_name, Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        }catch (IOException e){
            System.out.println("Ошибка вводла/вывода");
            System.exit(2);
        }
    }


}
