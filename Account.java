public class Account {
    public String name;
    private String PIN;
    private String question;
    private String answer;

    private double balance = 0;
    private double interestRate = 0;

    public Account(String Name, String pin, String Question, String Answer){
        name = Name;
        PIN = pin;
        question = Question;
        answer = Answer;

    }

    public void diposit(double money){
        balance += money;
        return;
    }

    public void withdraw(double money){
        balance -= money;
        return;
    }

    public void setInterestRate(double rate){
        interestRate = rate;
        return;
    }

    public void collectInterest(){
        balance *= (1.0 + interestRate);
    }

    public double getBalance(){
        return (double) Math.round(balance*100) / 100.0;
    }

    public boolean checkPin(String pin){
        return pin.equals(PIN);
    }
}
