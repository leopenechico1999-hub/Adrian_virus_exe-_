package com.example.leo_adrian;
import android.app.*; import android.os.*; import android.view.*; import android.widget.*;

public class MainActivity extends Activity {
 TextView story; Button yes,no; int step=0;
 public void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_main);
  story=findViewById(R.id.story); yes=findViewById(R.id.yes); no=findViewById(R.id.no);
  yes.setOnClickListener(v->next()); no.setOnClickListener(v->finishGame());
 }
 void next(){ step++;
  if(step==1){story.setText("📱 Adrián: “¿Un FF? 🎮🔥”\n\nLeo acepta y comienza la partida.");}
  else if(step==2){story.setText("🎮 PARTIDA DE FREE FIRE\n\n💥 ¡Adrián ha sido tumbado!\n\nAdrián: “¡Leo, ayúdame!”");}
  else if(step==3){story.setText("💥 ¡LEO TAMBIÉN FUE TUMBADO!\n\nLeo: “¡Adrián…!”");}
  else if(step==4){story.setText("🌆 Después de la partida, se encuentran en persona.\n\nSe miran a los ojos, nerviosos...");}
  else if(step==5){story.setText("❤️ Leo y Adrián, al mismo tiempo:\n\n“Me... gustas.”");}
  else {story.setText("❤️ Se acercan tímidamente y se dan un pequeño beso.\n\n✨ FIN DEL JUEGO ✨"); yes.setVisibility(View.GONE); no.setVisibility(View.GONE);}
 }
 void finishGame(){ story.setText("❌ Leo dijo que no.\n\nFIN DEL JUEGO."); yes.setVisibility(View.GONE); no.setVisibility(View.GONE); }
}
