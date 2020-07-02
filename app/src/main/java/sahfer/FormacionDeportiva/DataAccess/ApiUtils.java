package sahfer.FormacionDeportiva.DataAccess;

import sahfer.FormacionDeportiva.statics.statics;

public class ApiUtils {

    private ApiUtils() {}

    //private static final String BASE_URL = "https://cayal-dot-carnescayal-2018.appspot.com/";
    private static final String BASE_URL = statics.SERVICIO_WEB;

    public static APIRetroClientService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIRetroClientService.class);
    }

}
