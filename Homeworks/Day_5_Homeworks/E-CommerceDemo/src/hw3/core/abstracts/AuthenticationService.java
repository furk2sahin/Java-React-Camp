package hw3.core.abstracts;

public interface AuthenticationService {
    boolean register(String email);
    public boolean activate(String activationCode, String otherActivationCode);
}
