package com.example.ruleta;

import android.widget.ImageButton;

public class Vaso {
    private ImageButton imgButton;
    private boolean veneno;

    public ImageButton getImgButton(){ return imgButton; }
    public void setImgButton(ImageButton value){ imgButton = value;}
    public boolean getVeneno(){ return veneno; }
    public void setVeneno(boolean value){ veneno = value;}

    public Vaso(boolean veneno, ImageButton imgButton){
        this.imgButton = imgButton;
        this.veneno = veneno;
        asignarImagen();
    }
    private void asignarImagen(){
        imgButton.setBackgroundResource((veneno)
                ?R.drawable.ic_launcher_background
                :R.drawable.ic_launcher_foreground
        );
    }
}
