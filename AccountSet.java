import java.util.ArrayList;

public class AccountSet {
    private ArrayList<Account> accounts = new  ArrayList();

    public AccountSet() {
    }

    public Account getAccount(String username){
        for (Account user : accounts){
            if (username.equals(user.name)){
                return user;
            }
        }

        return new Account("ERROR", "0000", "ERROR", "ERROR");
    }

    public String testLoinInfo(String username, String pin){
        for (Account user : accounts){
            if (username.equals(user.name)){
                if (user.checkPin(pin)){
                    return "Valid information";
                }

                else{
                    return "Incorrect PIN";
                }
            }
        }

        return "User does not exist";
    }

    public boolean userTaken(String username){
        boolean works = true;
        for (Account user : accounts){
            works = works && (!username.equals(user.name));
        }

        return !works;
    }

    public boolean pinValid(String pin){
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        boolean works = true;

        boolean temp = false;
        char num = '0';

        for (int i = 0; i < pin.length(); ++i){
            temp = false;
            num = pin.charAt(i);

            for (char number : nums){
                temp = temp || (num == number);
            }

            works = works && temp;
        }

        return works;
    }

    public void addAccount(Account user){
        accounts.add(user);
    }

    public String testAccountInfo(String user, String pin1, String pin2,
                                  String question, String answer1, String answer2){
        if (userTaken(user)){
            return "Username Taken";
        }

        else if (pin1.length() != 4 || !pin1.equals(pin2)){
            return "PIN must be a four digit number";
        }

        else if (!pinValid(pin1)){
            return "PINs do not match";
        }

        else if (!answer1.equals(answer2)){
            return "Answers do not match";
        }

        else{
            return "Account Created!";
        }
    }
}
