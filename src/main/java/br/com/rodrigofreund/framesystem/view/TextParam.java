package br.com.rodrigofreund.framesystem.view;

public class TextParam implements EventParam<String> {

    private String value;

    TextParam(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public EventParam<String> of(String value) {
        return new TextParam(value);
    }

}
