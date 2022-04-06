package com.rocpjunior.germanywolrdcup.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rocpjunior.germanywolrdcup.databinding.PlayergermanBinding;
import com.rocpjunior.germanywolrdcup.domain.Player;
import com.rocpjunior.germanywolrdcup.domain.Reply;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private Reply reply;
    private Player playergerman;

    public PlayerAdapter(Reply reply) {
        this.reply = reply;
        playergerman = reply.getObject().get(0).getPlayer();
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PlayergermanBinding binding = PlayergermanBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        Glide.with(context).asBitmap().load(playergerman.getImg()).circleCrop().into(holder.binding.ivImage);
        holder.binding.tvUser.setText(playergerman.getName());
        holder.binding.tvTeam.setText(playergerman.getCountry());
        holder.binding.tvPosition.setText(playergerman.getPos());
        holder.binding.tvRating.setText(String.format("%.3f", playergerman.getPercentual()));
        //Copas do Mundo Vencidas
        holder.binding.tvRankingTitulos.setText(playergerman.getBarras().getCopasDoMundoVencidas().getPos() + "º");
        holder.binding.pbCopasVencidas.setMax((int) playergerman.getBarras().getCopasDoMundoVencidas().getMax());
        holder.binding.pbCopasVencidas.setProgress((int) playergerman.getBarras().getCopasDoMundoVencidas().getPla());
        holder.binding.flTvTitulos.setText(String.format("%.1f", playergerman.getBarras().getCopasDoMundoVencidas().getPla()));
        //Copas do Mundo Disputadas
        holder.binding.tvRankingParticipacoes.setText(playergerman.getBarras().getCopasDoMundoDisputadas().getPos() + "º");
        holder.binding.pbCopasDisputadas.setMax((int) playergerman.getBarras().getCopasDoMundoDisputadas().getMax());
        holder.binding.pbCopasDisputadas.setProgress((int) playergerman.getBarras().getCopasDoMundoDisputadas().getPla());
        holder.binding.flTvParticipacoes.setText(String.format("%.1f", playergerman.getBarras().getCopasDoMundoDisputadas().getPla()));

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final PlayergermanBinding binding;

        public ViewHolder(PlayergermanBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
