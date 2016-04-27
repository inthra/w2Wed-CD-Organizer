import java.util.ArrayList;
import java.time.LocalDateTime;

public class CD {
  private String mName;
  private LocalDateTime mCreatedAt;
  private static ArrayList<CD> instances = new ArrayList<CD>();
  private int mId;

  public CD(String name){
    mName = name;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }

  public String getName(){
    return mName;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<CD> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }
  public static CD find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

}
