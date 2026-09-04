package com.example.leo_adrian;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView story;
    Button yes, no;
    int step = 0;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        story = findViewById(R.id.story);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        yes.setOnClickListener(v -> next());
        no.setOnClickListener(v -> next());

        story.setText("🎮 Leo y Adrián\n\nUna historia que comenzó en una partida...");
    }

    void next() {
        step++;

        if (step == 1) {
            story.setText("🔥 Leo y Adrián caen juntos en la partida.");
        } else if (step == 2) {
            story.setText("⚔️ De repente, tumban a Adrián.\n\nLeo grita: \"¡Amor, ayúdame!\"");
        } else if (step == 3) {
            story.setText("💥 Leo corre para ayudarlo...");
        } else if (step == 4) {
            story.setText("💀 Pero también tumban a Leo.\n\nLa partida termina.");
        } else if (step == 5) {
            story.setText("❤️ Después se encuentran en persona.\n\nSe miran a la cara...");
        } else {
            story.setText("💋 Leo y Adrián se dan un beso.\n\n❤️ FIN ❤️");
            yes.setVisibility(Button.GONE);
            no.setVisibility(Button.GONE);
        }
    }
}
