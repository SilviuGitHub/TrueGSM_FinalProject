package trueGSMProject.POJO;

public class LoginModel {
    private AccountModel account;
    private String loginMessage;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String loginMessage) {
        this.account = new AccountModel(username, password);
        this.loginMessage = loginMessage;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    @Override
    public String toString() {
        return "LoginModel value: {\n" +
                "account:{\n username=" + account.getUsername() + ",\n password=" + account.getPassword() +
                "\n}, \n loginMessage=" + loginMessage + '\n' +
                '}';
    }
}

