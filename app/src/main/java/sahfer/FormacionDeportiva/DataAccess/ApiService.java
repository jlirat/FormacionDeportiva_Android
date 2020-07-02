package sahfer.FormacionDeportiva.DataAccess;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import sahfer.FormacionDeportiva.DataAccess.RetrofitClient;
import sahfer.FormacionDeportiva.Domain.ListWCursor;

public interface ApiService<T> {

  @GET(".")
  Call<ListWCursor<T>> list(@QueryMap Map<String, String> params);
  
  @POST(".")
  Call<T> store(@Body T body);

  @GET("/{id}")
  Call<T> single(@Path("id") long id);

  @PUT("/{id}")
  Call<T> update(@Path("id") long id, @Body T body);

  @DELETE("/{id}")
  Call<T> destroy(@Path("id") long id);

}