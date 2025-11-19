package baseNoStates;

import baseNoStates.DoorStates.DoorUnlocked;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Door {
  private static final Logger logger = LoggerFactory.getLogger(Door.class);
  
  private final String id;
  private boolean closed;
  private DoorState state;
  private String fromSpace;
  private String toSpace;

  public Door(String id, String fromSpace, String toSpace) {
    this.id = id;
    closed = true;
    state = new DoorUnlocked(this);
    this.fromSpace = fromSpace;
    this.toSpace = toSpace;
  }

  public void setState(DoorState dS) {
    state = dS;
  }

  public void processRequest(RequestReader request) {
    // The door processes the request because it knows its state
    if (request.isAuthorized()) {
      doAction(request.getAction());
    } else {
      System.out.println("Not authorized");
    }

    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        state.open();
        break;

      case Actions.CLOSE:
        state.close();
        break;

      case Actions.LOCK:
        state.lock();
        break;

      case Actions.UNLOCK:
        state.unlock();
        break;

      case Actions.UNLOCK_SHORTLY:
        state.unlock_shortly();
        break;

      default:
        throw new IllegalArgumentException("Unknown action: " + action);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public void open() {
    closed = false;
  }

  public void close() {
    closed = true;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return state.getStateName();
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\'' 
        + ", closed=" + closed
        + ", state=" + getStateName()
        + '}';
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }

  public Object getFromSpace() {
    return fromSpace;
  }

  public Object getToSpace() {
    return toSpace;
  }
}
