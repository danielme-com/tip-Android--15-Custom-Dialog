package com.danielme.tipsandroid.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.danieme.tipsandroid.dialog.R;

/**
 * 
 * @author danielme.com
 *
 */
public class MainActivity extends Activity
{

	Dialog customDialog = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	}
	
	public void mostrar(View view)
	{
		// con este tema personalizado evitamos los bordes por defecto
		customDialog = new Dialog(this,R.style.Theme_Dialog_Translucent);
		//deshabilitamos el título por defecto
		customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//obligamos al usuario a pulsar los botones para cerrarlo
		customDialog.setCancelable(false);
		//establecemos el contenido de nuestro dialog
		customDialog.setContentView(R.layout.dialog);
		
		TextView titulo = (TextView) customDialog.findViewById(R.id.titulo);
		titulo.setText("Título del Dialog");
		
		TextView contenido = (TextView) customDialog.findViewById(R.id.contenido);
		contenido.setText("Mensaje con el contenido del dialog");
		
	    ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view)
			{
				customDialog.dismiss();
				Toast.makeText(MainActivity.this, R.string.aceptar, Toast.LENGTH_SHORT).show();
				
			}
		});
	    
	    ((Button) customDialog.findViewById(R.id.cancelar)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view)
			{
				customDialog.dismiss();
				Toast.makeText(MainActivity.this, R.string.cancelar, Toast.LENGTH_SHORT).show();
				
			}
		});
		
		customDialog.show();
	}	
	
}
