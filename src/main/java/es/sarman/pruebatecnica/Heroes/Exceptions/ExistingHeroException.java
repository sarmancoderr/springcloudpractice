package es.sarman.pruebatecnica.Heroes.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ExistingHeroException extends RuntimeException {
}
