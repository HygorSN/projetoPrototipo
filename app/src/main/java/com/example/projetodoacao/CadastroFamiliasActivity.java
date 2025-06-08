package com.example.projetodoacao;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroFamiliasActivity extends AppCompatActivity {

    private EditText editNomeFamilia, editNomeResponsavel, editCpfResponsavel, editQuantidadePessoas, editRendaMedia;
    private EditText editBairro, editRua, editCidade, editEstado;
    private CheckBox checkSemLarFixo;
    private Button btnSalvarFamilia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_familias);

        // Inicializa os campos
        editNomeFamilia = findViewById(R.id.editNomeFamilia);
        editNomeResponsavel = findViewById(R.id.editNomeResponsavel);
        editCpfResponsavel = findViewById(R.id.editCpfResponsavel);
        editQuantidadePessoas = findViewById(R.id.editQuantidadePessoas);
        editRendaMedia = findViewById(R.id.editRendaMedia);

        editBairro = findViewById(R.id.editBairro);
        editRua = findViewById(R.id.editRua);
        editCidade = findViewById(R.id.editCidade);
        editEstado = findViewById(R.id.editEstado);

        checkSemLarFixo = findViewById(R.id.checkSemLarFixo);
        btnSalvarFamilia = findViewById(R.id.btnSalvarFamilia);

        // Receber dados passados via Intent para mostrar perfil (preenchimento dos campos)
        Intent intent = getIntent();
        if (intent != null) {
            // Se veio a flag de visualização, desabilita edição
            boolean visualizar = intent.getBooleanExtra("visualizar", false);

            String nomeFamilia = intent.getStringExtra("nomeFamilia");
            String nomeResponsavel = intent.getStringExtra("nomeResponsavel");
            String cpfResponsavel = intent.getStringExtra("cpfResponsavel");
            String qtdPessoas = intent.getStringExtra("qtdPessoas");
            String rendaMedia = intent.getStringExtra("rendaMedia");
            String bairro = intent.getStringExtra("bairro");
            String rua = intent.getStringExtra("rua");
            String cidade = intent.getStringExtra("cidade");
            String estado = intent.getStringExtra("estado");
            boolean semLarFixo = intent.getBooleanExtra("semLarFixo", false);

            editNomeFamilia.setText(nomeFamilia);
            editNomeResponsavel.setText(nomeResponsavel);
            editCpfResponsavel.setText(cpfResponsavel);
            editQuantidadePessoas.setText(qtdPessoas);
            editRendaMedia.setText(rendaMedia);
            editBairro.setText(bairro);
            editRua.setText(rua);
            editCidade.setText(cidade);
            editEstado.setText(estado);
            checkSemLarFixo.setChecked(semLarFixo);

            if (visualizar) {
                // Desabilita edição dos campos para só visualizar
                setCamposEditaveis(false);
                btnSalvarFamilia.setVisibility(Button.GONE);
            }
        }

        // Controlar habilitação dos campos endereço conforme checkbox
        checkSemLarFixo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editBairro.setEnabled(!isChecked);
            editRua.setEnabled(!isChecked);
            editCidade.setEnabled(!isChecked);
            editEstado.setEnabled(!isChecked);

            if (isChecked) {
                editBairro.setText("");
                editRua.setText("");
                editCidade.setText("");
                editEstado.setText("");
            }
        });

        btnSalvarFamilia.setOnClickListener(v -> {
            // Validação básica dos campos obrigatórios
            String nomeFamilia = editNomeFamilia.getText().toString().trim();
            String nomeResponsavel = editNomeResponsavel.getText().toString().trim();
            String cpfResponsavel = editCpfResponsavel.getText().toString().trim();
            String qtdPessoas = editQuantidadePessoas.getText().toString().trim();
            String rendaMedia = editRendaMedia.getText().toString().trim();

            if (TextUtils.isEmpty(nomeFamilia)) {
                Toast.makeText(this, "Informe o nome da família", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(nomeResponsavel)) {
                Toast.makeText(this, "Informe o nome do responsável", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(cpfResponsavel) || cpfResponsavel.length() != 11) {
                Toast.makeText(this, "Informe um CPF válido com 11 dígitos", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(qtdPessoas)) {
                Toast.makeText(this, "Informe a quantidade de pessoas", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(rendaMedia)) {
                Toast.makeText(this, "Informe a renda média", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!checkSemLarFixo.isChecked()) {
                // Validar endereço somente se não for sem lar fixo
                if (TextUtils.isEmpty(editBairro.getText().toString().trim()) ||
                        TextUtils.isEmpty(editRua.getText().toString().trim()) ||
                        TextUtils.isEmpty(editCidade.getText().toString().trim()) ||
                        TextUtils.isEmpty(editEstado.getText().toString().trim())) {
                    Toast.makeText(this, "Informe o endereço completo ou marque 'Não possui lar fixo'", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            // Aqui você pode salvar os dados no banco ou SharedPreferences
            // Por enquanto, só mostra uma mensagem:
            Toast.makeText(this, "Dados da família salvos com sucesso!", Toast.LENGTH_SHORT).show();

            // Finalizar Activity após salvar
            finish();
        });
    }

    // Método para ativar/desativar edição dos campos
    private void setCamposEditaveis(boolean habilitar) {
        editNomeFamilia.setEnabled(habilitar);
        editNomeResponsavel.setEnabled(habilitar);
        editCpfResponsavel.setEnabled(habilitar);
        editQuantidadePessoas.setEnabled(habilitar);
        editRendaMedia.setEnabled(habilitar);
        editBairro.setEnabled(habilitar);
        editRua.setEnabled(habilitar);
        editCidade.setEnabled(habilitar);
        editEstado.setEnabled(habilitar);
        checkSemLarFixo.setEnabled(habilitar);
    }
}
