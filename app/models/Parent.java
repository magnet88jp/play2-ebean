package models;
 
import java.util.Date;
import java.util.*;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
 
import play.db.ebean.Model;
 
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.validation.NotNull;
 
@Entity
public class Parent extends Model {
 
  @Id
  public Long id;
 
  @NotNull
  public String name;
 
  @CreatedTimestamp
  public Date createDate;
 
  @Version
  public Date updateDate;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
  public List<Child> children = new ArrayList<Child>();

  public String toString() {
    return "Parent [id=" + id + ", name=" + name + ", createDate="
      + createDate + ", updateDate=" + updateDate + "]";
  }

}