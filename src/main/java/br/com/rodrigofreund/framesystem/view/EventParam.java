package br.com.rodrigofreund.framesystem.view;

public interface EventParam<T> {

    T getValue();

    EventParam<T> of(T value);

}
