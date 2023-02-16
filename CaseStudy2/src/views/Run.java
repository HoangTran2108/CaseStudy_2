package views;

import controller.LoginManager;

public class Run {
    public static void main(String[] args) {
        View view = new View();
        LoginManager loginManager = new LoginManager();
        loginManager.login();
        view.menu();
    }
}
