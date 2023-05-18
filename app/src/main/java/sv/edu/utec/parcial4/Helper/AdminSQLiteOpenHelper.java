package sv.edu.utec.parcial4.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MD_Clientes (id_Cliente int primary key, " +
                "sNombreCliente text,sApellidoCliente text, sDireccionCliente text, sCiudadCliente text)");

        db.execSQL("CREATE TABLE MD_ClienteVehiculo (id_Cliente int, id_Vehiculo int primary key, " +
                "sMatricula text,iKilometros text)");

        db.execSQL("CREATE TABLE MD_Vehiculos (id_Vehiculo int primary key, " +
                "sMarca text,sModelo text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
