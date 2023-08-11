package br.com.rodrigofreund.framesystem.view;

@FunctionalInterface
public interface EventListener<T extends EventParam<?>> {

	void update(T data);

}
