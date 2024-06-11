package br.com.auttar.sampleimportsdk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.auttar.libctfclient.Constantes
import br.com.auttar.libctfclient.ui.CTFClientActivity
import br.com.auttar.mobile.libctfclient.sdk.AuttarSDK
import br.com.auttar.mobile.libctfclient.sdk.LibCTFClient
import br.com.auttar.sampleimportsdk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.login.setOnClickListener {
            val auttarSDK = AuttarSDK(applicationContext)
            startActivity(auttarSDK.createDefaultLoginIntent())
        }

        binding.config.setOnClickListener {
            val auttarSDK = AuttarSDK(applicationContext)
            startActivity(auttarSDK.configuration.createDefaultIntent())
        }

        binding.credit.setOnClickListener {
            val builder = LibCTFClient.IntentBuilder.from(Constantes.OperacaoCTFClient.CREDITO_GENERICO)
            val libCTFClient = LibCTFClient(this@MainActivity)
            libCTFClient.setCustomViewCTFClient(CTFClientActivity::class.java)
            libCTFClient.executeTransaction(builder, 12345)
        }

        binding.debit.setOnClickListener {
            val builder = LibCTFClient.IntentBuilder.from(Constantes.OperacaoCTFClient.DEBITO_GENERICO)
            val libCTFClient = LibCTFClient(this@MainActivity)
            libCTFClient.setCustomViewCTFClient(CTFClientActivity::class.java)
            libCTFClient.executeTransaction(builder, 12345)
        }

        val view = binding.root
        setContentView(view)
    }
}