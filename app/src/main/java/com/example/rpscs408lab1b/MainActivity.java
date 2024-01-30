package com.example.rpscs408lab1b;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import com.example.rpscs408lab1b.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Weapon playerWeapon, computerWeapon;
    private int comp_wins = 0, player_wins = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.RockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerWeapon = Weapon.ROCK;
                process();
            }
        });
        binding.PaperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerWeapon = Weapon.PAPER;
                process();

            }
        });
        binding.ScissorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerWeapon = Weapon.SCISSORS;
                process();

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void process() {

        int choice = (int)(Math.random() * Weapon.values().length);
        computerWeapon = Weapon.values()[choice];

        TextView t = binding.outputLabel;

        StringBuilder s = new StringBuilder();

        s.append("Player: ").append(player_wins).append('\n');
        s.append("Computer: ").append(comp_wins).append('\n');

        s.append("Player's Choice: ").append(playerWeapon).append('\n');
        s.append("Computer's Choice: ").append(computerWeapon).append('\n');

        // Evaluate Winner

        if (playerWeapon == computerWeapon) {
            s.append(getResources().getString(R.string.tie));
        }
        if (playerWeapon == Weapon.ROCK && computerWeapon == Weapon.PAPER){
            comp_wins++;
            s.append(getResources().getString(R.string.R_P));
        }
        else if (playerWeapon == Weapon.ROCK && computerWeapon == Weapon.SCISSORS){
            player_wins++;
            s.append(getResources().getString(R.string.R_S));
        }

        if (playerWeapon == Weapon.PAPER && computerWeapon == Weapon.SCISSORS){
            comp_wins++;
            s.append(getResources().getString(R.string.P_S));
        }
        else if (playerWeapon == Weapon.PAPER && computerWeapon == Weapon.ROCK){
            player_wins++;
            s.append(getResources().getString(R.string.P_R));
        }
        if (playerWeapon == Weapon.SCISSORS && computerWeapon == Weapon.ROCK){
            comp_wins++;
            s.append(getResources().getString(R.string.S_R));
        }
        else if (playerWeapon == Weapon.SCISSORS && computerWeapon == Weapon.PAPER){
            player_wins++;
            s.append(getResources().getString(R.string.S_P));
        }
       t.setText(s.toString());

    }

}