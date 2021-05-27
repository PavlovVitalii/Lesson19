import jdk.nashorn.internal.codegen.CompilerConstants;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GoogleWebServise {

    @GET("/")
    Call<String> home();
}
