package sahfer.FormacionDeportiva.service;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import sahfer.FormacionDeportiva.R;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    String CHANNEL_NAME = "CanalGeneral";
    String CHANNEL_DESCRIPTION = "Canal de notificaciones generales";
    String CHANNEL_ID = "1";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getData().size() > 0) {

            boolean hayCodigoAccion = remoteMessage.getData().containsKey("codigo_accion");

            if (hayCodigoAccion) {
                String codigoAccion = remoteMessage.getData().get("codigo_accion");
                try {
                    flujoCodigo_Accion(remoteMessage, codigoAccion);
                } catch (Exception e) {
                    System.out.print("error");
                }
            }

        }

        if (remoteMessage.getNotification() != null) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, createNotificationChannel())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Llego notificacion")
                    .setContentText("prueba de llegada")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(NotificationCompat.DEFAULT_SOUND) //*Sonido!
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                    .setAutoCancel(true);
            /*.setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);*/

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());
        }

    }
    private String createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = CHANNEL_NAME;
            String description = CHANNEL_DESCRIPTION;
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setLightColor(Color.GRAY);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            return channel.getId();
        }
        return null;
    }

    private void flujoCodigo_Accion(@NonNull RemoteMessage remoteMessage, String codigoAccion) {
        System.out.println("El codigo fue: " + codigoAccion);
    }

    /*@Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token);
    }
    private void sendRegistrationToServer(String token){

        APIRetroClientService mAPIService = ApiUtils.getAPIService();
        String idSesion = retrieveString(getApplicationContext(), PreferencesStatic.idSesion, "-1");

        mAPIService.changetoken(token, idSesion).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                if(response.body() != null){
                    logError("Token Cambiado con exito!!!");
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                logError("Ocurrio un error al cambiar el token");
            }
        });
    }*/
}
