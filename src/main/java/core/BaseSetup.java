package core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import configuration.Environment;
import restApi.RestConsumer;

public class BaseSetup {

    protected static RestConsumer restConsumer;

    static {
        Environment.getInstance();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        restConsumer = new RestConsumer();
    }

}
