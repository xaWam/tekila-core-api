package com.jaravir.tekila.module.subscription.persistence.entity.external;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 1/8/2015.
 */
public class TechnicalStatus {
    private List<StatusElement> elements;

    public TechnicalStatus() {
        elements = new ArrayList<>();
    }

    public List<StatusElement> getElements() {
        return elements;
    }

    public void setElements(List<StatusElement> elements) {
        this.elements = elements;
    }

    public <T> void addElement(StatusElementType type, T element) {
        elements.add(new StatusElement(type, element));
    }

    public StatusElement getElement (StatusElementType type) {
        for (StatusElement element : elements)
            if (element.getType() == type)
                return element;

        return null;
    }

    public <T> T getValue(String elementType) {
        return getValue(StatusElementType.valueOf(elementType));
    }

    public <T> T getValue(StatusElementType elementType) {
        StatusElement<T> element = getElement(elementType);

        return element != null ? element.getValue() : null;
    }

    public <T> String getBroadbandActive() {
        T value = getValue(StatusElementType.BROADBAND_ACTIVE);
        if (value != null) {
            return value.toString();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TechnicalStatus{");
        sb.append("elements=").append(elements);
        sb.append('}');
        return sb.toString();
    }
}
