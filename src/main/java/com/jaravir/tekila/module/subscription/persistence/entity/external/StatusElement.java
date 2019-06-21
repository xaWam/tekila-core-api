package com.jaravir.tekila.module.subscription.persistence.entity.external;

/**
 * Created by sajabrayilov on 1/8/2015.
 */
public class StatusElement<T> {
    private StatusElementType type;
    private T value;

    public StatusElement() {}

    public StatusElement(StatusElementType type, T value) {
        this.type = type;
        this.value = value;
    }

    public StatusElementType getType() {
        return type;
    }

    public void setType(StatusElementType type) {
        this.type = type;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusElement{");
        sb.append("type=").append(type);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
