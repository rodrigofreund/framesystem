package br.com.rodrigofreund.framesystem.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class EventManager {

    private Map<EventType, List<EventListener<EventParam<?>>>> eventListeners;

    private static EventManager instance;

    private EventManager() {
        eventListeners = new TreeMap<>();
    }

    public static EventManager instance() {
        if (instance == null)
            instance = new EventManager();
        return instance;
    }

    public void subscribe(EventType eventType, EventListener<EventParam<?>> eventListener) {
        
        if(eventListeners.containsKey(eventType)) {
           eventListeners.get(eventType).add(eventListener);
        } else {
            List<EventListener<EventParam<?>>> listeners = new ArrayList<>();
            listeners.add(eventListener);
            eventListeners.put(eventType, listeners);
        }
    }

    public <T> void notify(EventType eventType, EventParam<T> arg) {
        if(eventListeners.get(eventType) == null)
            return;
        eventListeners.get(eventType).forEach(i -> i.update(arg));
    }
    
    public <T> void notify(EventType eventType) {
        if(eventListeners.get(eventType) == null)
            return;
        eventListeners.get(eventType).forEach(i -> i.update(null));
    }
}
