package lab_11;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {
    private String channelName;
    private List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    public void uploadVideo(String title) {

        notifyObservers("{"+ channelName + "} uploaded a new video: " + title);

    }
    @Override
    public void subscribe(  Observer observer) {
        observers.add(observer);
    }
    @Override
    public void unsubscribe(  Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }

    }

}