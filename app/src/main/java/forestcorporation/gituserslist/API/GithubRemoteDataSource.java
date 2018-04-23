package forestcorporation.gituserslist.API;

import android.util.Log;

import java.util.List;

import forestcorporation.gituserslist.User;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Magda on 2018-04-23.
 */

public class GithubRemoteDataSource {

    private static final String API_BASE_URL = "https://api.github.com/";
    private Retrofit retrofit;

    public GithubRemoteDataSource() {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder().client(httpClient)
                .baseUrl(API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    public void loadClientList(Callback<List<User>> callback) {
        GitHubClient client = retrofit.create(GitHubClient.class);

        Call<List<User>> call = client.reposForUser();

        call.enqueue(callback);
    }

}
