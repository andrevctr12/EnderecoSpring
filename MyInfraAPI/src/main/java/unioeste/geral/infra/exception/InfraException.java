package unioeste.geral.infra.exception;

import org.hibernate.HibernateException;

public class InfraException extends HibernateException {

    public InfraException(String message) {
        super(message);
    }

    public InfraException(Throwable cause) {
        super(cause);
    }

    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }
}
