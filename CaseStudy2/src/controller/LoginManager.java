package controller;

import model.Login;
import storage.ReadAndWrite;

import java.util.List;
import java.util.Scanner;

public class LoginManager {
    List<Login> logins = ReadAndWrite.getInstance().readFileLogin();
    List<Login> loginList = ReadAndWrite.getInstance().readFileLoginManager();
    Scanner scanner = new Scanner(System.in);

    public LoginManager() {
    }

    public LoginManager(List<Login> logins, List<Login> loginList) {
        this.logins = logins;
        this.loginList = loginList;
    }
    public void login(){
        while (true) {
            System.out.println("Tên đăng nhập:");
            String userName = scanner.nextLine();
            System.out.println("Mật khẩu:");
            String passWord = scanner.nextLine();
            if(userName.equals(logins.get(0).getUserName())
                    && passWord.equals(logins.get(0).getPassWord())){
                break;
            } else {
                System.out.println("Tên đăng nhập / Mật khẩu không đúng");
            }
        }
    }
    public void loginManager(){
        while (true) {
            System.out.println("Tên đăng nhập: ");
            String userName = scanner.nextLine();
            System.out.println("Mật khẩu: ");
            String passWord = scanner.nextLine();
            if(userName.equals(loginList.get(0).getUserName())
                    && passWord.equals(loginList.get(0).getPassWord())){
                break;
            } else {
                System.out.println("Tên đăng nhập / Mật khẩu không đúng");
            }
        }
    }
}
