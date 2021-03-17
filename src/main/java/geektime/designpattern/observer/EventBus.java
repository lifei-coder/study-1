package geektime.designpattern.observer;

import java.util.List;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/17 19:57
 */
public class EventBus {

    private ObserverRegistry registry = new ObserverRegistry();


    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            observerAction.execute(event);
        }
    }

}
