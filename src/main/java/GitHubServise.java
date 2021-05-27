import jdk.nashorn.internal.codegen.CompilerConstants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubServise {

    @GET("users/{name_of_user}/repos")
    Call<String> listRepos (@Path("name_of_user")String aUser);
}
