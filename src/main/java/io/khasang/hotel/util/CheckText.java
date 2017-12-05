package io.khasang.hotel.util;

import net.yandex.speller.services.spellservice.CheckTextRequest;
import net.yandex.speller.services.spellservice.SpellServiceSoap;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class CheckText {
    private static final String ADDRES = "http://speller.yandex.net/services/spellservice?WSDL";

    public String chechWord(String text) throws MalformedURLException {
        URL url = new URL(ADDRES);
        QName qName = new QName("http://speller.yandex.net/services/spellservice", "SpellService");

        Service service = Service.create(url, qName);

        SpellServiceSoap hello = service.getPort(SpellServiceSoap.class);

        CheckTextRequest checkTextRequest = new CheckTextRequest();
        checkTextRequest.setText(text);
        checkTextRequest.setFormat("plain");
        checkTextRequest.setLang("en");

        if (hello.checkText(checkTextRequest).getSpellResult().getError().size() != 0) {
            return hello.checkText(checkTextRequest).getSpellResult().getError().get(0).getS().toString();
        } else {
            return "Word correct";
        }
    }


}
