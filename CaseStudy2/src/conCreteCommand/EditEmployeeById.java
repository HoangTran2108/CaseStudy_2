package conCreteCommand;

import command.CommandEdit;
import command.CommandVoidWithParameters;
import controller.LibraryManager;
import model.Employee;

public class EditEmployeeById implements CommandEdit {
    LibraryManager libraryManager;

    public EditEmployeeById() {
    }

    public EditEmployeeById(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public void execute(String inputID, Employee employee) {
        libraryManager.editEmployeeById(inputID, employee);
    }
}
