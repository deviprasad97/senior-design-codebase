package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;
import com.softmoore.android.graphlib.*;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;


public class ProfilePage extends AppCompatActivity {

    private TextView fullname;
    private TextView email;
    private TextView phone;
    private TextView street;
    private TextView city;
    private TextView zip;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        //displays user name
        fullname=findViewById(R.id.fullname);
        User user=SharedPrefManager.getInstance(this).getUser();
        fullname.setText(user.getFname()+" "+user.getLname());

        //displays email
        email = findViewById(R.id.email);
        String etext = getString(R.string.email);
        email.setText(etext + " " + user.getEmail());
        //...phone
        phone = findViewById(R.id.phone);
        String ptext = getString(R.string.phone);
        phone.setText(ptext + " " + user.getPhone());
        //...street
        street = findViewById(R.id.street);
        String stext = getString(R.string.street);
        street.setText(stext + " " + user.getAddress());
        //...city
        city = findViewById(R.id.city);
        String ctext = getString(R.string.city);
        city.setText(ctext + " " + user.getCity());
        //...zip
        zip = findViewById(R.id.zip);
        String ztext = getString(R.string.zip);
        zip.setText(ztext + " " + user.getZipcode());


        //weight log graph
        LineChartView lineChartView = findViewById(R.id.showGraph);

        String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
                "Oct", "Nov", "Dec"};
        int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#121493"));
        ;
        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }
        List lines = new ArrayList();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);
        Axis axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);

        axis.setTextSize(15);
        axis.setTextColor(Color.parseColor("#03A9F4"));


        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
        /*
        int i = 1;
        //badges
        if (i == 1) {
            VectorMasterView badgeVector = (VectorMasterView) findViewById(R.id.imageView9);

            // find the correct path using name
            PathModel rectangle = badgeVector.getPathModelByName("rectangle");

            // set the stroke color
            rectangle.setStrokeColor(Color.parseColor("#03A9F4"));

            // set the fill color (if fill color is not set or is TRANSPARENT, then no fill is drawn)
            //outline.setFillColor(Color.parseColor("#ED4337"));

        }

         */

    }
}
