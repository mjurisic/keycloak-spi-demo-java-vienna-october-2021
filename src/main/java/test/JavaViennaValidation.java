package test;

import org.keycloak.authentication.ValidationContext;
import org.keycloak.authentication.forms.RegistrationProfile;
import org.keycloak.models.utils.FormMessage;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class JavaViennaValidation extends RegistrationProfile {

    public static final String PROVIDER_ID = "java-vienna-registration";

    public String getId() {
        return PROVIDER_ID;
    }

    public String getDisplayType() {
        return "Java Vienna Profile Validation";
    }

    public void validate(ValidationContext context) {
        System.out.println("marko was here!");
        MultivaluedMap<String, String> decodedFormParameters = context.getHttpRequest().getDecodedFormParameters();
        if (decodedFormParameters.getFirst("email") != null &&
                !decodedFormParameters.getFirst("email").endsWith("@willhaben.at")) {
            context.error("invalid email");
            context.validationError(decodedFormParameters, List.of(new FormMessage("email", "Invalid email, please enter a valid @willhaben.at email")));
            return;
        }
        super.validate(context);
    }
}
