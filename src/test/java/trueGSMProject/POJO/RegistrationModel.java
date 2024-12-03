package trueGSMProject.POJO;

public class RegistrationModel {
    private AccountModel account;
    private String registrationMessage;

    public RegistrationModel() {
    }

    public RegistrationModel(String username, String registrationMessage) {
        this.account = new AccountModel();
        this.registrationMessage = registrationMessage;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public String getRegistrationMessage() {
        return registrationMessage;
    }

    public void setRegistrationMessage(String registrationMessage) {
        this.registrationMessage = registrationMessage;
    }

    @Override
    public String toString() {
        return "RegistrationModel value: {\n" +
                "account:{\n username=" + account.getUsername() +
                "\n}, \n registrationMessage=" + registrationMessage + '\n' +
                '}';
    }
}

