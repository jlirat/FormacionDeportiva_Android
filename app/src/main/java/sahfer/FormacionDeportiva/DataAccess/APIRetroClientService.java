package sahfer.FormacionDeportiva.DataAccess;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import sahfer.FormacionDeportiva.Domain.LoginUser;
import sahfer.FormacionDeportiva.Domain.UserToken;

public interface APIRetroClientService {

    /**
     @POST("cadenas/listdata")
     Call<Object> listData(@Header("Cookie") String userCookie, @Query("title") String title,
     @Query("body") String body);
    **/
    

    @POST("api/2/login/authenticate")
    Call<UserToken> loginServer(@Body LoginUser User);

    @GET
    Call<Object> postGeneral(@Url String url);

}
