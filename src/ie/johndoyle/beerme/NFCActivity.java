package ie.johndoyle.beerme;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcEvent;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class NFCActivity extends ActionBarActivity implements CreateNdefMessageCallback {

	TextView textView;
    NfcAdapter mNfcAdapter;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfc);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

     // Check for available NFC Adapter
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) {
            Toast.makeText(this, "NFC is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        // Register callback
        mNfcAdapter.setNdefPushMessageCallback(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nfc, menu);
		return true;
	}
	 @Override
	    public NdefMessage createNdefMessage(NfcEvent event) {
	        String text = ("Beam me up, Android!\n\n" +
	                "Beam Time: " + System.currentTimeMillis());
	        NdefMessage msg = new NdefMessage(NdefRecord.createMime( "application/com.example.android.beam", text.getBytes()));
	        return msg;
	    }

	    @Override
	    public void onResume() {
	        super.onResume();
	        // Check to see that the Activity started due to an Android Beam
	        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
	            processIntent(getIntent());
	        }
	    }

	    @Override
	    public void onNewIntent(Intent intent) {
	        // onResume gets called after this to handle the intent
	        setIntent(intent);
	    }

	    /**
	     * Parses the NDEF Message from the intent and prints to the TextView
	     */
	    void processIntent(Intent intent) {
	        textView = (TextView) findViewById(R.id.textView);
	        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
	                NfcAdapter.EXTRA_NDEF_MESSAGES);
	        // only one message sent during the beam
	        NdefMessage msg = (NdefMessage) rawMsgs[0];
	        // record 0 contains the MIME type, record 1 is the AAR, if present
	        textView.setText(new String(msg.getRecords()[0].getPayload()));
	    }
}
