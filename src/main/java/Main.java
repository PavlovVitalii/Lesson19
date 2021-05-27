import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.Google();
        System.out.println();
        System.out.println();
        main.GitHub();
        System.out.println();
        System.out.println();
        main.Tiny();

    }

    private void Google() {
        GoogleWebServise servise = new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(GoogleWebServise.class);

        Response<String> response = null;

        try {
            response = servise.home().execute();

            if (response != null && response.isSuccessful()) {
                System.out.println(response.body());
            } else if (response != null) {
                System.out.println(response.errorBody().string());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void GitHub() {

        GitHubServise gitHubServise = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(GitHubServise.class);

        Response<String> response = null;
        try {
            response = gitHubServise
                    .listRepos("octocat")
                    .execute();

            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                System.out.println(response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void Tiny() {
        final TrinyServise servise = new Retrofit.Builder()
                .baseUrl("http://tiny-url.info/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TrinyServise.class);

        Response<TinyUrlResponse> response;

        try {
            response = servise.random("json", "http://tiny-url.info/open_api.html").execute();
            if (response != null && response.isSuccessful()) {
                System.out.println(response.body().shortUrl);
            } else if (response != null) {
                System.out.println(response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
