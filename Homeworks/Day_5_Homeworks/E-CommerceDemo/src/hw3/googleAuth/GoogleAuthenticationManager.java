package hw3.googleAuth;

import java.util.regex.Pattern;

public class GoogleAuthenticationManager {

    public boolean register(String email){
        if(!Pattern.matches("^[a-z0-9](\\.?[a-z0-9]){2,}@gmail\\.com$", email)){
            System.out.println("Wrong email format.");
            return false;
        } else{
            return true;
        }
    }

    public boolean activate(String activationCode, String otherActivationCode){
        if(activationCode.equals(otherActivationCode)){
            System.out.println("Thanks for activating your account!");
            return true;
        } else{
            System.out.println("Sorry! Activation code didn't match.");
            return false;
        }
    }
}
