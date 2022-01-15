package org.resfa.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class NotAllowedMapper implements javax.ws.rs.ext.ExceptionMapper<NotAllowedException> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Response toResponse(NotAllowedException exception) {
        this.logger.error("Ошибка работы сервиса", exception);
        return Response.status(403).type("application/json").entity("Ошибка ввода: ресурс с данным методом не найден").build();
    }


}
