package sahfer.FormacionDeportiva.Views;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import sahfer.FormacionDeportiva.Adapters.ListAdapterSesion;
import sahfer.FormacionDeportiva.Domain.SesionList;
import sahfer.FormacionDeportiva.R;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.utils.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Calendar
    List<EventDay> events = new ArrayList<>();

    //listView
    private ListView listview;
    private ArrayList<SesionList> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        listview = (ListView) findViewById(R.id.listView);

        // Calendar
        Calendar calendar = Calendar.getInstance();
        events.add(new EventDay(calendar, R.drawable.common_google_signin_btn_icon_dark_focused));
        //or if you want to specify event label color
        calendarView.setEvents(events);

        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                Calendar clickedDayCalendar = eventDay.getCalendar();
                Toast.makeText(getApplicationContext(), clickedDayCalendar.getTime().toString() , Toast.LENGTH_SHORT).show();

                List<EventDay> eventss = new ArrayList<>();
                eventss.addAll(events);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(clickedDayCalendar.getTime());
                //or if you want to specify event label color
                eventss.add(new EventDay(calendar, R.drawable.ic_menu_gallery));
                events = eventss;
                calendarView.setEvents(eventss);
            }
        });

        // ListView
        names = new ArrayList<SesionList>();
        names.add(new SesionList("Veracruz", "training"));
        names.add(new SesionList("Tabasco"));
        names.add(new SesionList("Chiapas"));
        names.add(new SesionList("Campeche"));
        names.add(new SesionList("Quintana Roo"));
        ArrayAdapter<SesionList> adapter = new ArrayAdapter<SesionList>(this, android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);

        ListAdapterSesion myAdapter = new ListAdapterSesion(this, R.layout.list_item, names);
        listview.setAdapter(myAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has pulsado: "+ names.get(position).getEquipo(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
