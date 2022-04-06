package com.rocpjunior.germanywolrdcup.domain;

import com.google.gson.annotations.SerializedName;

public class ProgressBar {

    @SerializedName("Copas_do_Mundo_Vencidas")
    private WorldCups copasDoMundoVencidas;
    @SerializedName("Copas_do_Mundo_Disputadas")
    private WorldCups copasDoMundoDisputadas;

    public WorldCups getCopasDoMundoVencidas() {return copasDoMundoVencidas;}
    public void setCopasDoMundoVencidas(WorldCups value) { this.copasDoMundoVencidas = value;}

    public WorldCups getCopasDoMundoDisputadas() {return copasDoMundoDisputadas;}
    public void setCopasDoMundoDisputadas(WorldCups value) {this.copasDoMundoDisputadas = value;}
}
