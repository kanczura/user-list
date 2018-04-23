package forestcorporation.gituserslist;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;

        import java.util.List;

        import forestcorporation.gituserslist.API.GitHubClient;
        import forestcorporation.gituserslist.API.GithubRemoteDataSource;
        import okhttp3.OkHttpClient;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private RecyclerView usersList;
    private GithubRemoteDataSource githubRemoteDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersList = (RecyclerView) findViewById(R.id.rv_users);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        usersList.setLayoutManager(layoutManager);
        usersList.addItemDecoration(new DividerItemDecoration(MainActivity.this));

        adapter = new UserAdapter(new OnItemClickListener() {
            @Override
            public void onItemClick(User item) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("user", item);
                startActivity(intent);
            }
        });
        usersList.setAdapter(adapter);

        githubRemoteDataSource = new GithubRemoteDataSource();
        githubRemoteDataSource.loadClientList(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    adapter.updateAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
