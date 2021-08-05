package edu.cnm.deepdive.pickyeater.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

@Entity
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private Long id;

  @Expose
  @SerializedName("id")
  @ColumnInfo(name = "service_key")
  @NonNull
  private String serviceKey;

  @Expose
  @ColumnInfo(index = true)
  @NonNull
  private Date created;

  @Expose
  @NonNull
  private String displayName;

  private String oauthKey;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @NonNull
  public Date getCreated() { return created;}

  public void setCreated(Date created) {this.created = created;}

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getOauthKey() {
    return oauthKey;
  }

  public void setOauthKey(String oauthKey) {
    this.oauthKey = oauthKey;
  }

  @NonNull
  public String getServiceKey() {
    return serviceKey;
  }

  public void setServiceKey(@NonNull String serviceKey) {
    this.serviceKey = serviceKey;
  }

}
