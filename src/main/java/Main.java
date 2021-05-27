import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        GoogleWebServise servise = new Retrofit.Builder()
//                .baseUrl("https://google.com")
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build()
//                .create(GoogleWebServise.class);
//
//        Response<String> response = null;
//
//        try {
//            response = servise.home().execute();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        if (response != null && response.isSuccessful()){
//            System.out.println(response.body());
//        }else if (response != null){
//            System.out.println(response.errorBody().string());
//        }

        System.out.println();
        System.out.println();
        System.out.println();


        GitHubServise gitHubServise = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(GitHubServise.class);

        Response<String> response1 = null;
        try {
            response1 = gitHubServise
                    .listRepos("octocat")
                    .execute();

            if (response1.isSuccessful()){
                System.out.println(response1.body());
            }else {
                System.out.println(response1.errorBody().string());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
