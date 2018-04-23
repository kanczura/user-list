
package forestcorporation.gituserslist;

        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;

        import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    public TextView userName;
    public ImageView userAvatar;
    public Context context;
    public List<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("user");
        userAvatar = findViewById(R.id.iv_avatarDetails);
        userName = findViewById(R.id.tv_userName);
        userName.setText(user.getLogin());
        Glide.with(this).load(user.getAvatar_url()).into(userAvatar);



    }
}