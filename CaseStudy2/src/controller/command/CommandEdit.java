package controller.command;

import model.Employee;

public interface CommandEdit {
    void execute(String inputID, Employee employee);
}
