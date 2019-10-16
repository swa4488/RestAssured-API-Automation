package core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import configuration.Configuration;
import restApi.RestConsumer;

public class BaseSetup {

    protected static Configuration conf;
    protected static ObjectMapper mapper;
    protected static RestConsumer restConsumer;


    static {
        conf = new Configuration();
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        restConsumer = new RestConsumer();
    }

}
