package org.resfa.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class HandledServiceExceptionMapper implements ExceptionMapper<HandledServiceException> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public HandledServiceExceptionMapper() {
    }

    public Response toResponse(HandledServiceException exception) {
        this.logger.error("Ошибка работы сервиса", exception);
        return Response.status(400).type("application/json").entity("Внутренняя ошибка сервиса").build();
    }
}
