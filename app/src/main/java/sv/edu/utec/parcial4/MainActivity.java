package sv.edu.utec.parcial4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.parcial4.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    EditText txtIdCliente,txtNombreCliente,txtApellidoCliente, txtDireccionCliente, txtCiudadCliente;

    Button  btnInsertar,btnActualizar,btnEliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtIdCliente=findViewById(R.id.editTextTextP5ersonName5);
        txtNombreCliente=findViewById(R.id.editTextTextPersonName);
        txtApellidoCliente=findViewById(R.id.editTextTextPersonName2);
        btnInsertar=findViewById(R.id.btnInsertar);
        btnActualizar=findViewById(R.id.btnActualizar);
        btnEliminar=findViewById(R.id.btnEliminar);


        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String id=txtIdCliente.getText().toString();
                String nom=txtNombreCliente.getText().toString();
                String ape=txtApellidoCliente.getText().toString();
                String dire=txtDireccionCliente.getText().toString();
                String ciudad=txtCiudadCliente.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("id_Cliente",id);
                informacion.put("sNombreCliente",nom);
                informacion.put("sApellidoCliente",ape);
                informacion.put("sDireccionCliente",dire);
                informacion.put("sCiudadCliente",ciudad);


                try {
                    bd.insert("MD_Clientes", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto el cliente", Toast.LENGTH_LONG).show();
                    bd.close();

                } catch (Exception e){
                    //pendiente imprimir error
                    Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                }

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"clientes",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtIdCliente.getText().toString();

                int cat=bd.delete("MD_Clientes",
                        "id_Cliente="+cod,null);
                bd.close();
                txtIdCliente.setText("");
                txtNombreCliente.setText("");
                txtApellidoCliente.setText("");
                txtDireccionCliente.setText("");
                txtCiudadCliente.setText("");

                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se borro el cliente",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro el cliente",Toast.LENGTH_LONG).show();

                }
            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"cliente",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String id=txtIdCliente.getText().toString();
                String nom=txtNombreCliente.getText().toString();
                String ape=txtApellidoCliente.getText().toString();
                String dire=txtDireccionCliente.getText().toString();
                String ciudad=txtCiudadCliente.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("id_Cliente",id);
                informacion.put("sNombreCliente",nom);
                informacion.put("sApellidoCliente",ape);
                informacion.put("sDireccionCliente",dire);
                informacion.put("sCiudadCliente",ciudad);


                int cat=bd.update("MD_Clientes",informacion,
                        "id_Cliente="+id,null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el cliente",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico el cliente",Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}