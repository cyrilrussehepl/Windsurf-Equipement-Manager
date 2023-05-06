import Controller.Controller;
import GUI.JFrameWEMConsole;
import Model.Model;

public class Main {
    public static void main(String[] args) {
        //Init objects
        JFrameWEMConsole mainWindow = new JFrameWEMConsole();
        Controller controller = Controller.getInstance();
        //Setup mainWindow
        mainWindow.setController(controller);
        mainWindow.setVisible(true);
    }
}