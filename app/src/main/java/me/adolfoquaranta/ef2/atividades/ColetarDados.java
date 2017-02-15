package me.adolfoquaranta.ef2.atividades;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.RegexpValidator;

import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;
import me.adolfoquaranta.ef2.R;
import me.adolfoquaranta.ef2.auxiliares.DBAuxilar;
import me.adolfoquaranta.ef2.modelos.Dado;
import me.adolfoquaranta.ef2.modelos.Modelo;
import me.adolfoquaranta.ef2.modelos.Tratamento;
import me.adolfoquaranta.ef2.modelos.Variavel;

public class ColetarDados extends AppCompatActivity {
    private DBAuxilar dbAuxilar;
    private List<Tratamento> tratamentos;
    private List<Variavel> variaveis;
    private Modelo modelo;
    private Integer tratamentoAtual, repeticaoAtual, replicacaoAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletar_dados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbAuxilar = new DBAuxilar(getApplicationContext());

        Intent coletarDados = getIntent();
        final Long id_Formulario = coletarDados.getLongExtra("id_Formulario", 0);
        final Long id_Coleta = coletarDados.getLongExtra("id_Coleta", 0);

        //recarregar dados
        tratamentoAtual = coletarDados.getIntExtra("tratamentoAtual", 0);
        replicacaoAtual = coletarDados.getIntExtra("replicacaoAtual", 0);
        repeticaoAtual = coletarDados.getIntExtra("repeticaoAtual", 0);

        Log.d("tratamentoAtual", tratamentoAtual.toString());

        modelo = dbAuxilar.lerModelo(id_Formulario, "DIC");
        tratamentos = dbAuxilar.lerTodosTratamentos(id_Formulario);
        variaveis = dbAuxilar.lerTodasVariaveis(id_Formulario);

        final RegexpValidator naoNulo = new RegexpValidator(getString(R.string.err_msg_valorVariavel), "^(?!\\s*$).+");

        View.OnFocusChangeListener validar = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v instanceof MaterialEditText && v.isEnabled() && v.hasFocus()) {
                    MaterialEditText editText = (MaterialEditText) v;
                    editText.validateWith(naoNulo);
                }
                if (v instanceof MaterialSpinner) {
                    MaterialSpinner spinner = (MaterialSpinner) v;
                    if (spinner.getSelectedItemPosition() == 0) {
                        spinner.setError("Error");
                    } else {
                        spinner.setError(null);
                    }
                }
            }
        };

        LinearLayout myLayout = (LinearLayout) findViewById(R.id.ll_ColetarDados);

        final TextView infoColetaAtual = (TextView) findViewById(R.id.tv_infoColetaAtual);
        infoColetaAtual.setText("TRAT " + (tratamentoAtual + 1) + " | REP " + (repeticaoAtual + 1) + " | REPLI " + (replicacaoAtual + 1));

        for (int i = 0; i < variaveis.size(); i++) {
            final LinearLayout layoutInterno = new LinearLayout(this);
            layoutInterno.setOrientation(LinearLayout.HORIZONTAL);
            layoutInterno.setWeightSum(3);

            //nome tratamento
            final MaterialEditText etValorVariavel = new MaterialEditText(this); // Pass it an Activity or Context
            etValorVariavel.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
            etValorVariavel.setId(i);
            etValorVariavel.setOnFocusChangeListener(validar);
            etValorVariavel.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
            etValorVariavel.setHint(variaveis.get(i).getNome_Variavel());
            etValorVariavel.setFloatingLabelText(variaveis.get(i).getNome_Variavel());
            etValorVariavel.setFloatingLabelAnimating(true);
            layoutInterno.addView(etValorVariavel);

            final ToggleButton anularVariavel = new ToggleButton(getApplicationContext());
            anularVariavel.setText(R.string.anular);
            anularVariavel.setId(i + variaveis.size());
            anularVariavel.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2f)); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
            anularVariavel.setId(i + variaveis.size());
            anularVariavel.setTextOn(getString(R.string.nulo));
            anularVariavel.setTextOff(getString(R.string.anular));
            layoutInterno.addView(anularVariavel);
            myLayout.addView(layoutInterno);

            final int finalI = i;
            anularVariavel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MaterialEditText etAtual = (MaterialEditText) layoutInterno.findViewById(v.getId() - variaveis.size());
                    if (etAtual.isEnabled()) {
                        etAtual.setText(null);
                        etAtual.setHint(R.string.nulo);
                        etAtual.setEnabled(false);
                    } else {
                        etAtual.setHint(variaveis.get(finalI).getNome_Variavel());
                        etAtual.setEnabled(true);
                    }
                }
            });

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((replicacaoAtual + 1) >= modelo.getQuantidadeReplicacoes_Modelo() && (tratamentoAtual) >= modelo.getQuantidadeTratamentos_Modelo()) {
                    Snackbar infoColetaCompleta = Snackbar.make(view, R.string.info_ColetaCompleta, Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent inicio = new Intent(ColetarDados.this, Inicio.class);
                            startActivity(inicio);
                        }
                    });
                    infoColetaCompleta.setActionTextColor(Color.WHITE);
                    infoColetaCompleta.show();
                } else {
                    Intent recarregar = new Intent(ColetarDados.this, ColetarDados.class);
                    recarregar.putExtra("id_Formulario", id_Formulario);
                    recarregar.putExtra("id_Coleta", id_Coleta);
                    Integer id = 0;

                    while (findViewById(id) instanceof MaterialEditText) {
                        Dado dado = new Dado();
                        dado.setIdColeta_Dado(id_Coleta);
                        dado.setIdTratamento_Dado(tratamentos.get(tratamentoAtual).getId_Tratamento());
                        dado.setIdVariavel_Dado(variaveis.get(id).getId_Variavel());
                        MaterialEditText etVariavel = (MaterialEditText) findViewById(id);
                        if (etVariavel.isEnabled() && etVariavel.getText().toString().equals("")) {
                            Snackbar.make(view, R.string.info_PreechaOuAnule, Snackbar.LENGTH_LONG).show();
                            return;
                        } else if (!etVariavel.isEnabled()) {
                            Log.d("etVariavel", " ");
                            dado.setValor_Dado(" ");
                        } else {
                            Log.d("etVariavel", etVariavel.getText().toString());
                            dado.setValor_Dado(etVariavel.getText().toString());
                        }
                        id++;
                    }

                    if ((tratamentoAtual + 1) >= tratamentos.size()) {
                        replicacaoAtual++;
                        tratamentoAtual = 0;
                        recarregar.putExtra("replicacaoAtual", replicacaoAtual);
                        recarregar.putExtra("tratamentoAtual", tratamentoAtual);
                        startActivity(recarregar);
                    } else {
                        tratamentoAtual++;
                        recarregar.putExtra("tratamentoAtual", tratamentoAtual);
                        recarregar.putExtra("replicacaoAtual", replicacaoAtual);
                        startActivity(recarregar);
                    }
                }
            }
        });

    }

    public void onBackPressed() {
        if (tratamentoAtual != 0) {
            tratamentoAtual--;
            finish();
        } else {
            Toast.makeText(this, R.string.info_EmBreve, Toast.LENGTH_SHORT).show();
        }
    }
}