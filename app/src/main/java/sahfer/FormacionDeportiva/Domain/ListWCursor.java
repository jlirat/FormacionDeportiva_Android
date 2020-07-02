package sahfer.FormacionDeportiva.Domain;

import java.util.List;

public class ListWCursor<T> {
  private List<T> entities;
  private String cursor;

  public List<T> getEntities() {
    return entities;
  }

  public void setEntities(List<T> entities) {
    this.entities = entities;
  }

  public String getCursor() {
    return cursor;
  }

  public void setCursor(String cursor) {
    this.cursor = cursor;
  }
}