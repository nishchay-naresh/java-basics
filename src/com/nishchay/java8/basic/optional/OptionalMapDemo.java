package com.nishchay.java8.basic.optional;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;

public class OptionalMapDemo {

    private static final String USER_MAP_KEY = "userMapKey";

    public static void main(String[] args) {

        AppContext context = new AppContext();

//         issueReproduce(context);
        // Exception in thread "main" java.lang.UnsupportedOperationException

        issueFixJava8Way(context);
    }

    public static void issueReproduce(AppContext context) {

        Map<String, String> pathVariables = (Map<String, String>) context.getAttribute(USER_MAP_KEY);
        if (pathVariables != null) {
            pathVariables.forEach((k, v) -> {
                pathVariables.put(k, v.replace("2", "upd2").replace("5", "upd5"));
            });
        }
    }

    public static void issueFixJava8Way(AppContext context) {

        /*
        *  1. taking the unmodifiable map from request.getAttribute()
        *  2. if this unmodifiable map is not null, then doing this mapping
        *  	  unmodifiable map -> new hashMap(doing the value substitution)
        *  3. if there exit any map from last step, do
        *     map -> request.setAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, map)
        * */
        Optional.ofNullable((Map<String, String>) context.getAttribute(USER_MAP_KEY))
                .map(m -> m.entrySet().stream()
                        .collect(toMap(
                                Map.Entry::getKey,
                                e -> e.getValue().replace("%2F", "/").replace("%5C", "\\"))))
                .ifPresent(map -> context.setAttribute(USER_MAP_KEY, map));

        System.out.println("No - UnsupportedOperationException this time");
        Map<String, String> attribute = (Map<String, String>) context.getAttribute(USER_MAP_KEY);
        String oldVal = attribute.put("kay6", "val6") == null ? "true" : "false";
        System.out.println("validating map update again : add new - " + oldVal);
        System.out.println("validating map update again : update existing - " + "val1".equals(attribute.put("kay1", "upd value")));

    }

    static class AppContext {

        private final Map<String, Object> context;

        public AppContext() {

            Map<String, String> userMap = new HashMap<>();
            userMap.put("kay1", "val1");
            userMap.put("kay2", "val2");
            userMap.put("kay3", "val3");
            userMap.put("kay4", "val4");
            userMap.put("kay5", "val5");

            context = new HashMap<>();
            context.put(USER_MAP_KEY, Collections.unmodifiableMap(userMap));
        }

        public void setAttribute(String key, Map<String, String> map) {
            context.put(USER_MAP_KEY, Collections.unmodifiableMap(map));
        }

        public Object getAttribute(String key) {
            return context.get(key);
        }

    }
}
