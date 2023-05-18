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
        db.execSQL("CREATE TABLE Clientes (id_Cliente int primary key, " +
                "sNombreCliente text,sApellidoCliente, sDireccionCliente, sCiudadCliente)");

        db.execSQL("CREATE TABLE ClienteVehiculo (id_Cliente int, id_Vehiculo primary key, " +
                "sNombreCliente text,sApellidoCliente, sDireccionCliente, sCiudadCliente)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
