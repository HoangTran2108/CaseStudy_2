package controller.command;

import model.Employee;

public interface CommandAddEmployee {
    void execute(Employee employee);
}
