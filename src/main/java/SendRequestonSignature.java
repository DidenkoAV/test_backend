import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class SendRequestonSignature {

void test(){

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(
                    "http://10.2.53.102:2848/digital_signature/soap_v3/element/sign");
            StringEntity input = new StringEntity("");
            //String message = {"elementToSign":"<ns:SenderProvidedRequestData xmlns:ns=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.2\" xmlns:ns1=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.2\" Id=\"SIGNED_BY_CALLER\"><ns:MessageID>bf9c074c-ac23-11e8-98d0-529269fb1459</ns:MessageID><ns1:MessagePrimaryContent><ns5:ImportUserRequest xmlns:ns5=\"http://erl.russianpost.ru/smev-geps/import-user/1.0.2\"                       xmlns:ns6=\"http://erl.russianpost.ru/smev-geps/import-user-types/1.0.2\"                       xmlns:ns7=\"http://erl.russianpost.ru/smev-geps/address-type/1.0.2\"                       xmlns:ns8=\"http://erl.russianpost.ru/smev-geps/common-types/1.0.2\"><ns6:esiaId>999000999</ns6:esiaId><ns6:snils>00000000010</ns6:snils><ns6:inn>999000999000</ns6:inn><ns6:name>Иван</ns6:name><ns6:patronymic>Иванович</ns6:patronymic><ns6:surname>Иванов</ns6:surname><ns6:gender>MALE</ns6:gender><ns6:birthDate>1990-09-17</ns6:birthDate><ns6:mobilePhone>+79900990099</ns6:mobilePhone><ns6:email>ivan_ivanov@mail.ru</ns6:email><ns6:address><ns7:rawSource>Россия, г. Москва, Красная площадь, 1</ns7:rawSource></ns6:address><ns6:address><ns7:rawSource>Россия, г. Тольятти, Южное шоссе, 36</ns7:rawSource></ns6:address><ns6:identityDocument><ns8:series>9900</ns8:series><ns8:number>990099</ns8:number><ns8:date>2010-10-02</ns8:date><ns8:location>Комсомольским РУВД г. Тольятти Самарской обл.</ns8:location><ns8:departmentCode>632040</ns8:departmentCode></ns6:identityDocument><ns6:drivingLicense><ns8:series>9900</ns8:series><ns8:number>990099</ns8:number></ns6:drivingLicense><ns6:vehicleRegistrationCertificate><ns8:series>9900</ns8:series><ns8:number>990099</ns8:number><ns8:carNumber>С999УА163</ns8:carNumber></ns6:vehicleRegistrationCertificate></ns5:ImportUserRequest></ns1:MessagePrimaryContent><ns:TestMessage/></ns:SenderProvidedRequestData>"});
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server Sign: \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}