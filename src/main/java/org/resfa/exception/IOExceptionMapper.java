package org.resfa.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class IOExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<IOException> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public IOExceptionMapper() {
    }

    public Response toResponse(IOException exception) {
        this.logger.error("Ошибка работы сервиса", exception);
        return Response.status(403).type("application/json").entity("Ошибка ввода").build();
    }


}
