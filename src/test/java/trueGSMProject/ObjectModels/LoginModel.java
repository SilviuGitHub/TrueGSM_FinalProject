package trueGSMProject.ObjectModels;

public class LoginModel {
    private AccountModel account;
    private String loginErr;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String loginErr) {
        this.account = new AccountModel(username, password);
        this.loginErr = loginErr;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public String getLoginErr() {
        return loginErr;
    }

    public void setLoginErr(String loginErr) {
        this.loginErr = loginErr;
    }

    @Override
    public String toString() {
        return "LoginModel value: {\n" +
                "account:{\n username=" + account.getUsername() + ",\n password=" + account.getPassword() +
                "\n}, \n loginErr='" + loginErr + '\n' +
                '}';
    }
}

