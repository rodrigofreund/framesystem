package br.com.rodrigofreund.framesystem.view;

public class EventParamFactory {

    public static EventParam<?> of(Object data) {
        if(data instanceof String) {
            return new TextParam((String)data);
        }
        return new EmptyParam();
    }
    
    public static EventParam<?> of() {
        return new EmptyParam();
    }
}
