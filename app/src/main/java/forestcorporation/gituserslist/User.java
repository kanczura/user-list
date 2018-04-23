package forestcorporation.gituserslist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Magda on 2018-03-22.
 */

public class User implements Parcelable {

    public int id;
    public String login;
    public String avatar_url;

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(id);
        parcel.writeString(login);
        parcel.writeString(avatar_url);

    }

    private User(Parcel in) {
        id = in.readInt();
        login = in.readString();
        avatar_url = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
