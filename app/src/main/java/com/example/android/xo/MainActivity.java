package com.example.android.xo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean currentButtonValue = false;
    int[] XOmatrix = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    String winner = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        Button temp = (Button) findViewById(v.getId());
        if (!currentButtonValue) {
            temp.setText("X");
            currentButtonValue = true;
        } else {
            temp.setText("O");
            currentButtonValue = false;
        }
        temp.setClickable(false);

        //----store values in a local array (XOmatrix)

        Button b = (Button) findViewById(R.id.button1);
        if (b.getText().equals("X")) XOmatrix[0] = -1;
        else if (b.getText().equals("O")) XOmatrix[0] = 1;
        else XOmatrix[0] = 0;

        b = (Button) findViewById(R.id.button2);
        if (b.getText().equals("X")) XOmatrix[1] = -1;
        else if (b.getText().equals("O")) XOmatrix[1] = 1;
        else XOmatrix[1] = 0;

        b = (Button) findViewById(R.id.button3);
        if (b.getText().equals("X")) XOmatrix[2] = -1;
        else if (b.getText().equals("O")) XOmatrix[2] = 1;
        else XOmatrix[2] = 0;

        b = (Button) findViewById(R.id.button4);
        if (b.getText().equals("X")) XOmatrix[3] = -1;
        else if (b.getText().equals("O")) XOmatrix[3] = 1;
        else XOmatrix[3] = 0;

        b = (Button) findViewById(R.id.button5);
        if (b.getText().equals("X")) XOmatrix[4] = -1;
        else if (b.getText().equals("O")) XOmatrix[4] = 1;
        else XOmatrix[4] = 0;

        b = (Button) findViewById(R.id.button6);
        if (b.getText().equals("X")) XOmatrix[5] = -1;
        else if (b.getText().equals("O")) XOmatrix[5] = 1;
        else XOmatrix[5] = 0;

        b = (Button) findViewById(R.id.button7);
        if (b.getText().equals("X")) XOmatrix[6] = -1;
        else if (b.getText().equals("O")) XOmatrix[6] = 1;
        else XOmatrix[6] = 0;

        b = (Button) findViewById(R.id.button8);
        if (b.getText().equals("X")) XOmatrix[7] = -1;
        else if (b.getText().equals("O")) XOmatrix[7] = 1;
        else XOmatrix[7] = 0;

        b = (Button) findViewById(R.id.button9);
        if (b.getText().equals("X")) XOmatrix[8] = -1;
        else if (b.getText().equals("O")) XOmatrix[8] = 1;
        else XOmatrix[8] = 0;


        //-------------To check the value of the boxes (if one player won over the other)---------//

        //----------Horizontally----------//
        if (XOmatrix[0] == XOmatrix[1] && XOmatrix[1] == XOmatrix[2]) {
            if (XOmatrix[0] == -1)
                winner = "X";
            else if (XOmatrix[0] == 1)
                winner = "O";
        } else if (XOmatrix[3] == XOmatrix[4] && XOmatrix[4] == XOmatrix[5]) {
            if (XOmatrix[3] == -1)
                winner = "X";
            else if (XOmatrix[3] == 1)
                winner = "O";
        } else if (XOmatrix[6] == XOmatrix[7] && XOmatrix[7] == XOmatrix[8]) {
            if (XOmatrix[6] == -1)
                winner = "X";
            else if (XOmatrix[6] == 1)
                winner = "O";
        }

        //----------Vertically----------//
        else if (XOmatrix[0] == XOmatrix[3] && XOmatrix[3] == XOmatrix[6]) {
            if (XOmatrix[0] == -1)
                winner = "X";
            else if (XOmatrix[0] == 1)
                winner = "O";
        } else if (XOmatrix[1] == XOmatrix[4] && XOmatrix[4] == XOmatrix[7]) {
            if (XOmatrix[1] == -1)
                winner = "X";
            else if (XOmatrix[1] == 1)
                winner = "O";
        } else if (XOmatrix[2] == XOmatrix[5] && XOmatrix[5] == XOmatrix[8]) {
            if (XOmatrix[2] == -1)
                winner = "X";
            else if (XOmatrix[2] == 1)
                winner = "O";
        }

        //----------Diagonally----------//
        else if (XOmatrix[0] == XOmatrix[4] && XOmatrix[4] == XOmatrix[8]) {
            if (XOmatrix[0] == -1)
                winner = "X";
            else if (XOmatrix[0] == 1)
                winner = "O";
        } else if (XOmatrix[2] == XOmatrix[4] && XOmatrix[4] == XOmatrix[6]) {
            if (XOmatrix[2] == -1)
                winner = "X";
            else if (XOmatrix[2] == 1)
                winner = "O";
        }

        //----------------------------------------------------------------------------------------//

        //----------------Announce winner-------------//
        if (!winner.equals("")) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Winner");
            alertDialog.setMessage("The Winner is " + winner);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Replay?",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            for (int i = 0; i < XOmatrix.length; i++)
                                XOmatrix[i] = 0;

                            winner = "";

                            Button b = (Button) findViewById(R.id.button1);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button2);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button3);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button4);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button5);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button6);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button7);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button8);
                            b.setText("");
                            b.setClickable(true);

                            b = (Button) findViewById(R.id.button9);
                            b.setText("");
                            b.setClickable(true);

                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
}
