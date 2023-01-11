package api.framework.spark.responseTransformers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {
    public static final JsonTransformer JSON = new JsonTransformer();

    @Override
    public String render(Object response) throws Exception {
        try {
            return (new ObjectMapper()).writeValueAsString(response);
        } catch (JsonProcessingException exception) {
            return null;
        }
    }
}
