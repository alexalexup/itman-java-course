package collections;
import entities.Event;

public class EventList {
    public Event[] events;
    public int size;
    public int id;

    public EventList() {
        this.events = new Event[12];
    }

    public void addEvent(Event event){
        event.setId(++this.id);
        if (this.size >= this.events.length) {
            Event[] newEvents = new Event[this.events.length * 2];
            System.arraycopy(this.events, 0, newEvents, 0, this.events.length);
            this.events = newEvents;
        }
        this.size++;
        this.events[this.size -1] = event;
    }

    public void remove(int id) {
        for (int i = 0; i < size; i ++) {
            if (this.events[i].getId() == id) {
                this.size--;
                for (int j = i; j < size; j++) {
                    this.events[j] = this.events[j+1];
                }
                return;
            }
        }
    }

    public void edit(int id, Event event) {
        for (int i = 0; i < size; i++) {
            if (this.events[i].getId() == id) {
                this.events[i] = new Event(id, event.getYear(), event.getMonth(), event.getDay(), event.getName());
                return;
            }
        }
    }

    public Event getEvent(int id) {
        for (int i = 0; i < this.size; i ++) {
            if (this.events[i].getId() == id) {
                return this.events[i];
            }
        }
        return null;
    }

    public Event[] getAllEvents() {
        Event[] logicalEvents = new Event[this.size];
        System.arraycopy(this.events, 0, logicalEvents, 0, this.size);
        return logicalEvents;
    }
}
