package org.resfa.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.NoSuchElementException;

@Provider
public class NoSuchElementExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<NoSuchElementException> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Response toResponse(NoSuchElementException exception) {
        this.logger.error("Ошибка работы сервиса", exception);
        return Response.status(403).type("application/json")
                .entity("Ошибка ввода: данный район несуществует. Проверьте список доступных районов в /districts")
                .build();
    }


}
