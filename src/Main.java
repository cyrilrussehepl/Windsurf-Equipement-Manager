import Controller.Controller;
import GUI.JFrameWEMConsole;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        //Init objects
        JFrameWEMConsole mainWindow = new JFrameWEMConsole();
        Controller controller = new Controller();

        //Setup mainWindow
        mainWindow.setController(controller);
        mainWindow.setVisible(true);
    }
}