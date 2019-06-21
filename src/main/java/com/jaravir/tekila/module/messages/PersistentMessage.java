package com.jaravir.tekila.module.messages;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by kmaharov on 20.09.2017.
 */
public class PersistentMessage extends BaseEntity {
    private String properties;
    private MessageStatus status;
    private MessageType messageType;
    private Map<String, String> keyToValue; //transient
    private Long paymentId;


    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public void addProperty(String key, String value) {
        if (keyToValue == null) {
            keyToValue = new HashMap<>();
        }
        keyToValue.put(key, value);
    }

    public String getProperty(String searchKey) {
        if (keyToValue == null) {
            keyToValue = new HashMap<>();
            for (String keyValue : properties.split(",")) {
                String[] propArray = keyValue.split("=");
                String key = (propArray[0].startsWith("[") ? propArray[0].substring(1) : propArray[0]);
                String value = (propArray[1].endsWith("]") ?
                                propArray[1].substring(0, propArray[1].length()-1) : propArray[1]);
                keyToValue.put(key, value);
            }
        }
        return keyToValue.get(searchKey);
    }

    public String serializeProperties() {
        StringBuilder builder = new StringBuilder();
        if (keyToValue != null) {
            builder.append("[");
            for (Map.Entry<String, String> entries : keyToValue.entrySet()) {
                if (builder.length() > 1) {
                    builder.append(",");
                }
                builder.append(entries.getKey());
                builder.append("=");
                builder.append(entries.getValue());
            }
            builder.append("]");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "Message[id=%d,properties=%s,status=%d,messageType=%d]",
                id,
                properties,
                status.ordinal(),
                messageType.ordinal());
    }
}
