package com.rocpjunior.germanywolrdcup.domain;

import com.google.gson.annotations.SerializedName;

public class ObjectElement {
    @SerializedName("Player")
    private Player player;

    public Player getPlayer() { return player; }
    public void setPlayer(Player value) { this.player = value; }
}
