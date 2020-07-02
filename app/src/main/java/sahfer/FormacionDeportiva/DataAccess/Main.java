package sahfer.FormacionDeportiva.DataAccess;
import java.util.HashMap;
import retrofit2.Retrofit;
import sahfer.FormacionDeportiva.DataAccess.ApiService;
import sahfer.FormacionDeportiva.DataAccess.RetrofitClient;
import sahfer.FormacionDeportiva.Domain.User;

public class Main {

  public static void main(String[] args) {
    Retrofit client = RetrofitClient.getClient("users");

    ApiService<User> a = client.create(ApiService.class);
    a.list(new HashMap<String, String>());

  }
}