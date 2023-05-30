package generator;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserForm userForm = new UserForm();
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new UserForm().getMainPanel());



    }
}