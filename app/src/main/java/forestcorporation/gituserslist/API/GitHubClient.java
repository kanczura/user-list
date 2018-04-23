package forestcorporation.gituserslist.API;

import java.util.List;

import forestcorporation.gituserslist.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Magda on 2018-03-22.
 */

public interface GitHubClient {
    @GET("/users")
    Call<List<User>> reposForUser(
    );
}
