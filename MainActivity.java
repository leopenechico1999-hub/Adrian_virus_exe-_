package com.leo.adrian;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.*;
import android.graphics.drawable.ColorDrawable;
import android.view.*;
import android.content.Context;
import java.util.*;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new GameView(this));
    }

    static class GameView extends View {
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        int scene = 0;
        boolean finished = false;
        RectF button = new RectF();
        Random rnd = new Random(7);

        GameView(Context c) { super(c); p.setTypeface(Typeface.create("sans", Typeface.NORMAL)); setBackground(new ColorDrawable(Color.rgb(12,16,28))); }

        @Override protected void onDraw(Canvas c) {
            super.onDraw(c);
            float w=getWidth(), h=getHeight();
            drawBackground(c,w,h);
            if(scene==0) school(c,w,h);
            else if(scene==1) lobby(c,w,h);
            else if(scene==2) downAdrian(c,w,h);
            else if(scene==3) downLeo(c,w,h);
            else if(scene==4) meet(c,w,h);
            else if(scene==5) confession(c,w,h);
            else kiss(c,w,h);
            drawButton(c,w,h, scene<6 ? "CONTINUAR  ▶" : "JUGAR DE NUEVO  ↻");
        }

        void drawBackground(Canvas c,float w,float h){
            p.setStyle(Paint.Style.FILL); p.setColor(Color.rgb(15,21,38)); c.drawRect(0,0,w,h,p);
            // decorative stars / particles
            p.setColor(Color.argb(80,255,255,255));
            for(int i=0;i<35;i++){ float x=(i*83)%Math.max(1,(int)w); float y=(i*47)%Math.max(1,(int)(h*.78f)); c.drawCircle(x,y,2+(i%3),p); }
        }
        void title(Canvas c,String s,float y){
            p.setTextAlign(Paint.Align.CENTER); p.setTypeface(Typeface.create("sans",Typeface.BOLD)); p.setTextSize(30); p.setColor(Color.WHITE); c.drawText(s,getWidth()/2f,y,p);
            p.setTypeface(Typeface.create("sans",Typeface.NORMAL));
        }
        void text(Canvas c,String s,float y,float size){
            p.setTextAlign(Paint.Align.CENTER); p.setTextSize(size); p.setColor(Color.rgb(235,239,248));
            String[] lines=s.split("\\n"); float yy=y;
            for(String line:lines){c.drawText(line,getWidth()/2f,yy,p); yy+=size*1.35f;}
        }
        void bubble(Canvas c,float x,float y,float ww,float hh,String s){
            p.setColor(Color.argb(235,250,250,255)); p.setStyle(Paint.Style.FILL); c.drawRoundRect(new RectF(x-ww/2,y-hh/2,x+ww/2,y+hh/2),28,28,p);
            p.setColor(Color.rgb(20,24,38)); p.setTextAlign(Paint.Align.CENTER); p.setTextSize(20); p.setTypeface(Typeface.DEFAULT_BOLD);
            c.drawText(s,x,y+7,p); p.setTypeface(Typeface.DEFAULT);
        }
        void person(Canvas c,float x,float y,float scale,int shirt){
            p.setStyle(Paint.Style.FILL); p.setColor(Color.rgb(235,190,155)); c.drawCircle(x,y-95*scale,32*scale,p);
            p.setColor(Color.rgb(55,35,25)); c.drawCircle(x-9*scale,y-105*scale,8*scale,p); c.drawCircle(x+10*scale,y-105*scale,8*scale,p);
            p.setColor(shirt==0?Color.rgb(70,110,230):Color.rgb(220,70,110));
            c.drawRoundRect(new RectF(x-48*scale,y-65*scale,x+48*scale,y+45*scale),25*scale,25*scale,p);
            p.setColor(Color.rgb(35,40,55)); c.drawRect(x-36*scale,y+40*scale,x-5*scale,y+110*scale,p); c.drawRect(x+5*scale,y+40*scale,x+36*scale,y+110*scale,p);
            p.setColor(Color.rgb(235,190,155)); c.drawRect(x-65*scale,y-48*scale,x-42*scale,y+20*scale,p); c.drawRect(x+42*scale,y-48*scale,x+65*scale,y+20*scale,p);
        }
        void school(Canvas c,float w,float h){
            title(c,"LEO Y ADRIÁN",55); text(c,"Una historia de amistad, partida y amor ❤️",100,19);
            p.setColor(Color.rgb(45,58,88)); c.drawRect(0,h*.58f,w,h,p);
            person(c,w*.35f,h*.66f,1,0); person(c,w*.65f,h*.66f,1,1);
            bubble(c,w*.65f,h*.30f,300,70,"¿Un FF? 🎮🔥");
            text(c,"Leo recibe un mensaje de Adrián y acepta jugar.",h*.84f,20);
        }
        void lobby(Canvas c,float w,float h){
            title(c,"🎮 PARTIDA DE FREE FIRE",55); text(c,"La partida comienza...",105,22);
            p.setColor(Color.rgb(34,95,70)); c.drawRect(0,h*.35f,w,h*.82f,p);
            // simple game arena
            p.setColor(Color.rgb(95,130,65)); c.drawCircle(w*.25f,h*.55f,70,p); c.drawCircle(w*.75f,h*.57f,85,p);
            person(c,w*.28f,h*.65f,.75f,0); person(c,w*.72f,h*.65f,.75f,1);
            text(c,"Leo y Adrián están en el mismo equipo.",h*.88f,20);
        }
        void downAdrian(Canvas c,float w,float h){
            title(c,"💥 ¡ADRIÁN HA SIDO TUMBADO!",55); person(c,w*.62f,h*.68f,.85f,1); person(c,w*.30f,h*.62f,.85f,0);
            bubble(c,w*.58f,h*.28f,360,75,"¡Leo, ayúdame!"); text(c,"Leo corre hacia Adrián...",h*.86f,22);
        }
        void downLeo(Canvas c,float w,float h){
            title(c,"💥 ¡LEO TAMBIÉN FUE TUMBADO!",55); person(c,w*.38f,h*.68f,.85f,0); person(c,w*.68f,h*.68f,.85f,1);
            bubble(c,w*.50f,h*.28f,300,75,"¡Adrián...!"); text(c,"La partida termina, pero su historia apenas comienza.",h*.86f,20);
        }
        void meet(Canvas c,float w,float h){
            title(c,"🌆 DESPUÉS DE LA PARTIDA",55); p.setColor(Color.rgb(35,40,70)); c.drawRect(0,h*.52f,w,h,p);
            p.setColor(Color.rgb(245,180,110)); c.drawCircle(w*.5f,h*.23f,110,p);
            person(c,w*.40f,h*.70f,.9f,0); person(c,w*.60f,h*.70f,.9f,1);
            text(c,"Se encuentran en persona y se miran a los ojos...",h*.88f,20);
        }
        void confession(Canvas c,float w,float h){
            title(c,"❤️ UN MOMENTO ESPECIAL",55); person(c,w*.40f,h*.70f,.9f,0); person(c,w*.60f,h*.70f,.9f,1);
            bubble(c,w*.50f,h*.24f,400,85,"Me... gustas."); text(c,"Los dos lo dicen al mismo tiempo.",h*.88f,22);
        }
        void kiss(Canvas c,float w,float h){
            title(c,"💋 FINAL",55); person(c,w*.44f,h*.70f,.95f,0); person(c,w*.56f,h*.70f,.95f,1);
            p.setColor(Color.rgb(255,90,130)); p.setTextSize(55); p.setTextAlign(Paint.Align.CENTER); c.drawText("♥",w*.50f,h*.45f,p);
            text(c,"Se acercan tímidamente y se dan un pequeño beso.",h*.83f,21); text(c,"✨ FIN DE LA HISTORIA ✨",h*.92f,25);
        }
        void drawButton(Canvas c,float w,float h,String label){
            float bw=Math.min(420,w*.78f), bh=62, x=w/2f, y=h-55;
            button.set(x-bw/2,y-bh/2,x+bw/2,y+bh/2); p.setColor(Color.rgb(108,82,220)); p.setStyle(Paint.Style.FILL); c.drawRoundRect(button,28,28,p);
            p.setColor(Color.WHITE); p.setTextAlign(Paint.Align.CENTER); p.setTypeface(Typeface.DEFAULT_BOLD); p.setTextSize(20); c.drawText(label,x,y+7,p); p.setTypeface(Typeface.DEFAULT);
        }
        @Override public boolean onTouchEvent(android.view.MotionEvent e){
            if(e.getAction()==MotionEvent.ACTION_UP && button.contains(e.getX(),e.getY())){
                if(scene>=6) scene=0; else scene++;
                invalidate(); return true;
            }
            return true;
        }
    }
}
