package spring.boot.demo.api.demo.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DemoResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String result) {
        this.message = result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
