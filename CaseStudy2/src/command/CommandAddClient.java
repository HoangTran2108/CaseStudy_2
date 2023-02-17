package command;

import model.Client;
import model.Employee;

public interface CommandAddClient {
    void execute(Client client);
}
