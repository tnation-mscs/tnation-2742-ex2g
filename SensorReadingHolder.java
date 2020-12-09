package com.example.tnation2742ex2g1;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SensorReadingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView sensorReadingIdTextView;
    private final TextView dateTimeTextView;
    private final TextView valueTextView;

    private SensorReading sensorReading;
    Context context;


    public SensorReadingHolder( Context context, View itemView) {
        super(itemView);
        this.context = context;

        this.sensorReadingIdTextView = (TextView) itemView.findViewById(R.id.sensorReadingIdTextView);
        this.dateTimeTextView = (TextView) itemView.findViewById(R.id.dateTimeTextView);
        this.valueTextView = (TextView) itemView.findViewById(R.id.valueTextView);

        itemView.setOnClickListener(this);
    }

    public void bindSensorReading(SensorReading sensorReading) {
        this.sensorReading = sensorReading;

        this.sensorReadingIdTextView.setText(Integer.toString(sensorReading.getSensorReadingId()));
        LocalDateTime dt = sensorReading.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateTimeTextView.setText(dt.format(formatter));
        this.valueTextView.setText(Float.toString(sensorReading.getValue()));
    }

    @Override
    public void onClick(View v) {
        if (this.sensorReading != null)
            Toast.makeText(this.context,
                    "Clicked on " + this.sensorReading.getSensorId(),
                    Toast.LENGTH_SHORT).show();
    }
}
