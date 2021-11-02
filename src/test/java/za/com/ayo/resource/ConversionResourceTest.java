package za.com.ayo.resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversionResourceTest {
    private final HttpHeaders httpHeaders = new HttpHeaders();
    private final TestRestTemplate testRestTemplate = new TestRestTemplate();
    @LocalServerPort
    private int port;
    @Test
    public void test_when_gallonValue_is_converted_to_litreValue() {
        double gallonValue = 65.8;
        double litreValue = 299.13;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/volume/metric/" + gallonValue), HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(litreValue), responseEntity.getBody());
    }

    @Test
    public void test_when_litreValue_is_converted_to_gallonValue() {
        double gallonValue = 1.21;
        double litreValue = 5.5;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/volume/imperial/" + litreValue), HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(gallonValue), responseEntity.getBody());
    }

    @Test
    public void test_when_poundValue_is_converted_to_kilogramValue() {
        double poundValue = 65.8;
        double kilogramValue = 29.84;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/weight/metric/" + poundValue),HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(kilogramValue), responseEntity.getBody());
    }

    @Test
    public void test_when_kilogramValue_converted_to_poundValue() {
        double poundValue = 15.88;
        double kilogramValue = 7.2;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/weight/imperial/" + kilogramValue),HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(poundValue), responseEntity.getBody());
    }

    @Test
    public void test_when_fahrenheitValue_is_converted_to_celsiusValue() {
        double fahrenheitValue = 65.8;
        double celsiusValue = 18.78;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/temperature/metric/" + fahrenheitValue), HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(celsiusValue), responseEntity.getBody());
    }

    @Test
    public void test_when_celsiusValue_is_converted_to_fahrenheitValue() {
        double celsiusValue = 65.8;
        double fahrenheitValue = 150.44;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/temperature/imperial/" + celsiusValue), HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(fahrenheitValue), responseEntity.getBody());
    }


    @Test
    public void test_when_acreValue_is_converted_to_hectareValue() {
        double acreValue = 65.8;
        double hectareValue = 26.63;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/area/metric/" + acreValue),HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(hectareValue), responseEntity.getBody());
    }

    @Test
    public void test_when_hectareValue_is_converted_to_acreValue() {
        double hectareValue = 65.8;
        double acreValue = 162.59;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/area/imperial/" + hectareValue), HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(acreValue), responseEntity.getBody());
    }

    @Test
    public void test_when_mileValue_is_converted_to_kilometerValue() {
        double mileValue = 65.8;
        double kilometerValue = 105.87;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/length/metric/" + mileValue),HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(kilometerValue), responseEntity.getBody());
    }

    @Test
    public void test_when_kilometerValue_is_converted_to_mileValue() {
        double mileValue = 38.4;
        double kilometerValue = 61.78;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(endpointUrl("/length/imperial/" + kilometerValue),HttpMethod.GET, entity, String.class);
        assertEquals(String.valueOf(mileValue), responseEntity.getBody());
    }

    private String endpointUrl(final String uri) {
        return "http://localhost:" + port + "/v1" + uri;
    }
}
