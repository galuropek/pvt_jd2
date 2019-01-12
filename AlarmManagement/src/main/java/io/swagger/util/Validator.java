package io.swagger.util;

import java.util.List;
import java.util.Map;

public class Validator {

    private Map<String, List<Validatable>> rules = Map.of(
            "alarm.ackUserId", List.of(
                    new ValidationRule(),
                    new ValidationRuleMaxLength()
            )
    );

    public boolean validate(String fieldName, Object fieldValue) {
        boolean result = true;
        for (Validatable valRule : rules.get(fieldName)) {
            result &= valRule.validate(fieldValue);
        }
        return result;
    }

    interface Validatable {
        boolean validate(Object obj);
    }

    class ValidationRule implements Validatable {

        public boolean validate(Object obj) {
            return ((String) obj).length() > 0;
        }
    }

    class ValidationRuleMaxLength implements Validatable {

        public boolean validate(Object obj) {
            return ((String) obj).length() < 500;
        }
    }
}
