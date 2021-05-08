package hw3.core.concretes;

import hw3.core.abstracts.AuthenticationService;
import hw3.googleAuth.GoogleAuthenticationManager;

public class GoogleAuthenticationManagerAdapter implements AuthenticationService {

    @Override
    public boolean register(String email) {
        GoogleAuthenticationManager googleAuthenticationManager = new GoogleAuthenticationManager();
        return googleAuthenticationManager.register(email);
    }

    @Override
    public boolean activate(String activationCode, String otherActivationCode) {
        GoogleAuthenticationManager googleAuthenticationManager = new GoogleAuthenticationManager();
        return googleAuthenticationManager.activate(activationCode, otherActivationCode);
    }
}
