package org.resfa.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ExceptionMapper() {
    }

    public Response toResponse(Exception exception) {
        this.logger.error("Ошибка работы сервиса", exception);
        return Response.status(400).type("application/json").entity("Внутренняя ошибка сервиса").build();
    }
}
