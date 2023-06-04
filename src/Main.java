import Controller.Controller;
import GUI.JFrameWEMConsole;

public class Main {
    public static void main(String[] args) {
        //Init objects
        JFrameWEMConsole mainWindow = new JFrameWEMConsole();
        Controller controller = Controller.getInstance(mainWindow);
        //Setup mainWindow
        mainWindow.setController(controller);
        mainWindow.setVisible(true);
    }
}