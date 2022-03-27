package org.resfa.service;



import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MapService {

    @Location("map_template.html")
    private Template template;


    public void sendLetterForInsurer() {
        /*TemplateInstance templateInstance = template.data("message", worker.textMessage);
        sendSimpleEmailRequest.setEmailHtml(templateInstance.render());
        sendSimpleEmailRequest.setEmailSubject("Информация о платеже");
        sendSimpleEmailRequest.setRecipientEmail(recipientEmail);
        coreMailerService.sendSimpleHtmlEmail(sendSimpleEmailRequest);*/
    }

}
