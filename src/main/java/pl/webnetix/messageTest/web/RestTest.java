package pl.webnetix.messageTest.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.webnetix.messages.logic.MessageLoader;

import java.util.Locale;

@RestController
public class RestTest {

    @Autowired
    private MessageLoader messageLoader;

    private static final Logger LOGGER = Logger.getLogger(RestTest.class);

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResponseEntity getMessage(@RequestParam("defaultLang") String defaultLang,
                                     @RequestParam("localeCode") String localeCode,
                                     @RequestParam("langEnum") String langEnum,
                                     @RequestParam("portalName") String portalName) {

        messageLoader.loadSettings(defaultLang);
        Locale locale = new Locale(localeCode);
        LOGGER.info("TEST INFO");
        return new ResponseEntity(messageLoader.getMessage(langEnum, portalName, locale), HttpStatus.OK);
    }


}
