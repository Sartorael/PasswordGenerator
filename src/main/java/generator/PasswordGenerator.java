package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordGenerator {


    public String generate(int lenght){

        String lowCases = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String upCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮ";
        String spec = "!@#$%^&*()_-+={}[]\\|;:'\",.<>/¿¡~";
        String numbers = "0123456789";
        String password = "";
        for (int i = 0; i < lenght; i++) {
            int randomType = (int) (Math.random() * 4);
            switch (randomType) {
                case 0:
                    password += lowCases.charAt((int) (Math.random() * lowCases.length()));
                    break;
                case 1:
                    password += upCases.charAt((int) (Math.random() * upCases.length()));
                    break;
                case 2:
                    password += spec.charAt((int) (Math.random() * spec.length()));
                    break;
                case 3:
                    password += numbers.charAt((int) (Math.random() * numbers.length()));
                    break;
            }
        }
        return password;
    }

    public void saveToCsv(String urlSite,String login, String password, String pathToSave) {
        String filename = "data.csv";
        String line = String.format("\"%s\",\"%s\",\"%s\"", urlSite, login, password) + ";";

        File file = new File(pathToSave + "/" + filename);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            if (file.exists()) {
                writer.newLine();
            }
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }
}
