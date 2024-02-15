package karate;

import com.example.springapiexample.SpringApiExampleApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {SpringApiExampleApplication.class})
public class KarateTest {

        @Karate.Test
        Karate userServiceTest() {
//            return Karate.run("classpath:karate/api/user-service.feature");
            return Karate.run("user-service.feature").relativeTo(getClass());
        }
}
