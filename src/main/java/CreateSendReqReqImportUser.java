
import java.io.*;



public class CreateSendReqReqImportUser {


   //void GetReq() {
        public static void main(String[]args) {
    //public static  void main(String[] args) {
        String messageID = MessageIdGenerator.generate();
        String XMLmessageID = "<ns:MessageID>"+messageID+"</ns:MessageID>";

        //Тело запроса
        StringBuilder sb = new StringBuilder();
        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.2\" xmlns:ns1=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.2\">\n");
        sb.append("<soap:Header/>\n");
        sb.append("<soap:Body>\n");
        sb.append("<ns:SendRequestRequest>\n");
        sb.append("<ns:SenderProvidedRequestData xmlns:ns=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.2\" xmlns:ns1=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.2\" Id=\"SIGNED_BY_CALLER\">\n");
        sb.append(XMLmessageID);
        sb.append("\n<ns1:MessagePrimaryContent>\n");
        sb.append("<ns5:ImportUserRequest xmlns:ns5=\"http://erl.russianpost.ru/smev-geps/import-user/1.0.1\"\n" +
                "                       xmlns:ns6=\"http://erl.russianpost.ru/smev-geps/import-user-types/1.0.1\"\n" +
                "                       xmlns:ns7=\"http://erl.russianpost.ru/smev-geps/address-type/1.0.1\"\n" +
                "                       xmlns:ns8=\"http://erl.russianpost.ru/smev-geps/common-types/1.0.1\">\n");
        sb.append("<ns6:esiaId>999000999</ns6:esiaId>\n");
        sb.append("<ns6:snils>00000000010</ns6:snils>\n");
        sb.append("<ns6:inn>999000999000</ns6:inn>\n");
        sb.append("<ns6:name>Иван</ns6:name>\n");
        sb.append("<ns6:patronymic>Иванович</ns6:patronymic>\n");
        sb.append("<ns6:surname>Иванов</ns6:surname>\n");
        sb.append("<ns6:gender>MALE</ns6:gender>\n");
        sb.append("<ns6:birthDate>1990-09-17</ns6:birthDate>\n");
        sb.append("<ns6:mobilePhone>+79900990099</ns6:mobilePhone>\n");
        sb.append("<ns6:email>ivan_ivanov@mail.ru</ns6:email>\n");
        sb.append("<ns6:address>\n");
        sb.append("<ns7:rawSource>Россия, г. Москва, Красная площадь, 1</ns7:rawSource>\n");
        sb.append("</ns6:address>\n");
        sb.append("<ns6:address>\n");
        sb.append("<ns7:rawSource>Россия, г. Тольятти, Южное шоссе, 36</ns7:rawSource>\n");
        sb.append("</ns6:address>\n");
        sb.append("<ns6:identityDocument>\n");
        sb.append("<ns8:series>9900</ns8:series>\n");
        sb.append("<ns8:number>990099</ns8:number>\n");
        sb.append("<ns8:date>2010-10-02</ns8:date>\n");
        sb.append("<ns8:location>Комсомольским РУВД г. Тольятти Самарской обл.</ns8:location>\n");
        sb.append("<ns8:departmentCode>632040</ns8:departmentCode>\n");
        sb.append("</ns6:identityDocument>\n");
        sb.append("<ns6:drivingLicense>\n");
        sb.append("<ns8:series>9900</ns8:series>\n");
        sb.append("<ns8:number>990099</ns8:number>\n");
        sb.append("</ns6:drivingLicense>\n");
        sb.append("<ns6:vehicleRegistrationCertificate>\n");
        sb.append("<ns8:series>9900</ns8:series>\n");
        sb.append("<ns8:number>990099</ns8:number>\n");
        sb.append("<ns8:carNumber>С999УА163</ns8:carNumber>\n");
        sb.append("</ns6:vehicleRegistrationCertificate>\n");
        sb.append("</ns5:ImportUserRequest>\n");
        sb.append("</ns1:MessagePrimaryContent>\n");
        sb.append("<ns:TestMessage/>\n");
        sb.append("</ns:SenderProvidedRequestData>\n");
        sb.append("<ns:CallerInformationSystemSignature>\n");
        //Signature below
        sb.append("<ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"><ds:SignedInfo><ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/><ds:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411\"/><ds:Reference URI=\"#SIGNED_BY_CALLER\"><ds:Transforms><ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/><ds:Transform Algorithm=\"urn://smev-gov-ru/xmldsig/transform\"/></ds:Transforms><ds:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#gostr3411\"/><ds:DigestValue>y58AVro2GjeKMXiDR5dxqFmVqE9PoWVd8ReKOVGCgu8=</ds:DigestValue></ds:Reference></ds:SignedInfo><ds:SignatureValue>V7fCKAOvRbVZlFDiXAkEFdzFG3/CLYoQDE9Gqeudp9Qmo/rhsV/YC+tOcs0WeunbEw9e/f/hLY7/MhTpN3GUoQ==</ds:SignatureValue><ds:KeyInfo><ds:X509Data><ds:X509Certificate>MIIH7jCCB52gAwIBAgIRAXILAVZQAHCj6BEcVP9pOtQwCAYGKoUDAgIDMIIBRjEYMBYGBSqFA2QBEg0xMjM0NTY3ODkwMTIzMRowGAYIKoUDA4EDAQESDDAwMTIzNDU2Nzg5MDEpMCcGA1UECQwg0KHRg9GJ0LXQstGB0LrQuNC5INCy0LDQuyDQtC4gMjYxFzAVBgkqhkiG9w0BCQEWCGNhQHJ0LnJ1MQswCQYDVQQGEwJSVTEYMBYGA1UECAwPNzcg0JzQvtGB0LrQstCwMRUwEwYDVQQHDAzQnNC+0YHQutCy0LAxJDAiBgNVBAoMG9Ce0JDQniDQoNC+0YHRgtC10LvQtdC60L7QvDEwMC4GA1UECwwn0KPQtNC+0YHRgtC+0LLQtdGA0Y/RjtGJ0LjQuSDRhtC10L3RgtGAMTQwMgYDVQQDDCvQotC10YHRgtC+0LLRi9C5INCj0KYg0KDQotCaICjQoNCi0JvQsNCx0YEpMB4XDTE4MDUxMDA2MjkwNFoXDTE5MDUxMDA2MzkwNFowggEhMVEwTwYJKoZIhvcNAQkCDELQmNChINCt0JfQnyAo0K3Qu9C10LrRgtGA0L7QvdC90YvQtSDQl9Cw0LrQsNC30L3Ri9C1INCf0LjRgdGM0LzQsCkxGjAYBggqhQMDgQMBARIMMDA3NzI0MjYxNjEwMRgwFgYFKoUDZAESDTEwMzc3MjQwMDcyNzYxKTAnBgNVBAoMINCk0JPQo9CfINCf0L7Rh9GC0LAg0KDQvtGB0YHQuNC4MRUwEwYDVQQHDAzQnNC+0YHQutCy0LAxHDAaBgNVBAgMEzc3INCzLiDQnNC+0YHQutCy0LAxCzAJBgNVBAYTAlJVMSkwJwYDVQQDDCDQpNCT0KPQnyDQn9C+0YfRgtCwINCg0L7RgdGB0LjQuDBjMBwGBiqFAwICEzASBgcqhQMCAiQABgcqhQMCAh4BA0MABEALHXas7fzTXVqa660mpmRyttGQ2UQN4XC0s2o1J6JEij6kmvXCRN4L42C0jzIZAT+mqC3QyVcH00wMPb8TSlNHo4IEgzCCBH8wDgYDVR0PAQH/BAQDAgTwMB0GA1UdDgQWBBT13cJaLpx//vkzXlun1YMrsjj/jjCCAYgGA1UdIwSCAX8wggF7gBQ+7xk/D7l5sPHmKSGj5LmVuaXukKGCAU6kggFKMIIBRjEYMBYGBSqFA2QBEg0xMjM0NTY3ODkwMTIzMRowGAYIKoUDA4EDAQESDDAwMTIzNDU2Nzg5MDEpMCcGA1UECQwg0KHRg9GJ0LXQstGB0LrQuNC5INCy0LDQuyDQtC4gMjYxFzAVBgkqhkiG9w0BCQEWCGNhQHJ0LnJ1MQswCQYDVQQGEwJSVTEYMBYGA1UECAwPNzcg0JzQvtGB0LrQstCwMRUwEwYDVQQHDAzQnNC+0YHQutCy0LAxJDAiBgNVBAoMG9Ce0JDQniDQoNC+0YHRgtC10LvQtdC60L7QvDEwMC4GA1UECwwn0KPQtNC+0YHRgtC+0LLQtdGA0Y/RjtGJ0LjQuSDRhtC10L3RgtGAMTQwMgYDVQQDDCvQotC10YHRgtC+0LLRi9C5INCj0KYg0KDQotCaICjQoNCi0JvQsNCx0YEpghEBcgsBVlAAubPnEc86vjR3oDAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwJwYJKwYBBAGCNxUKBBowGDAKBggrBgEFBQcDAjAKBggrBgEFBQcDBDAdBgNVHSAEFjAUMAgGBiqFA2RxATAIBgYqhQNkcQIwKwYDVR0QBCQwIoAPMjAxODA1MTAwNjI5MDRagQ8yMDE5MDUxMDA2MjkwNFowggE0BgUqhQNkcASCASkwggElDCsi0JrRgNC40L/RgtC+0J/RgNC+IENTUCIgKNCy0LXRgNGB0LjRjyAzLjkpDCwi0JrRgNC40L/RgtC+0J/RgNC+INCj0KYiICjQstC10YDRgdC40LggMi4wKQxj0KHQtdGA0YLQuNGE0LjQutCw0YIg0YHQvtC+0YLQstC10YLRgdGC0LLQuNGPINCk0KHQkSDQoNC+0YHRgdC40Lgg4oSWINCh0KQvMTI0LTI1Mzkg0L7RgiAxNS4wMS4yMDE1DGPQodC10YDRgtC40YTQuNC60LDRgiDRgdC+0L7RgtCy0LXRgtGB0YLQstC40Y8g0KTQodCRINCg0L7RgdGB0LjQuCDihJYg0KHQpC8xMjgtMjg4MSDQvtGCIDEyLjA0LjIwMTYwNgYFKoUDZG8ELQwrItCa0YDQuNC/0YLQvtCf0YDQviBDU1AiICjQstC10YDRgdC40Y8gMy45KTBlBgNVHR8EXjBcMFqgWKBWhlRodHRwOi8vY2VydGVucm9sbC50ZXN0Lmdvc3VzbHVnaS5ydS9jZHAvM2VlZjE5M2YwZmI5NzliMGYxZTYyOTIxYTNlNGI5OTViOWE1ZWU5MC5jcmwwVwYIKwYBBQUHAQEESzBJMEcGCCsGAQUFBzAChjtodHRwOi8vY2VydGVucm9sbC50ZXN0Lmdvc3VzbHVnaS5ydS9jZHAvdGVzdF9jYV9ydGxhYnMyLmNlcjAIBgYqhQMCAgMDQQBsGe20LU2haxIcVbKjtO0gbfDMt++VCbTfbmJP2P9aWLgchbJXZorlY5mC5kRHeJ+KViFExugwXDDsbaaX/SVq</ds:X509Certificate></ds:X509Data></ds:KeyInfo></ds:Signature>");
        sb.append("</ns:CallerInformationSystemSignature>\n");
        sb.append("</ns:SendRequestRequest>\n");
        sb.append("</soapenv:Body>\n");
        sb.append("</soapenv:Envelope>\n");
        System.out.println(sb);
        //Формируем запрос в кодировку
        String body = sb.toString();
        byte[] buffer = new byte[body.length()];
        try {
            buffer = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

    }
}