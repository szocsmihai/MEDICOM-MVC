package ro.iteahome.medicom.exception.business;

public class NotNhsRegisteredException extends RuntimeException {

    public NotNhsRegisteredException() {
        super("CNP DOES NOT CORRESPOND TO AN NHS-REGISTERED DOCTOR.");
    }
}
