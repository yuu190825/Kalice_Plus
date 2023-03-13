package com.itoria.kaliceplus

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.itoria.kaliceplus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method

        // Load
        binding.screenMain.text = "0 "
        binding.screenOou.text = "4/5"
        binding.screenDot.text = "0"

        // Weight Listener
        binding.seekBarOou.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                when (p1) {
                    0 -> binding.screenOou.text = getString(R.string.stringOut)
                    1 -> binding.screenOou.text = getString(R.string.string4Out5Up)
                    2 -> binding.screenOou.text = getString(R.string.stringUp)
                }
                setOouControl(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // nothing
            }
        })

        binding.seekBarDot.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.screenDot.text = setDotControl(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // nothing
            }
        })

        binding.buttonClear.setOnClickListener { binding.screenMain.text = myClear() }
        binding.buttonNeg.setOnClickListener { binding.screenMain.text = myNegative() }
        binding.buttonBS.setOnClickListener { binding.screenMain.text = backSpace() }
        binding.buttonMR.setOnClickListener { binding.screenMain.text = memoryRead() }
        binding.buttonMW.setOnClickListener { memoryWrite() }
        binding.buttonPowTwo.setOnClickListener { binding.screenMain.text = powTwo() }
        binding.buttonSqrt.setOnClickListener { binding.screenMain.text = mySqrt() }
        binding.buttonSeven.setOnClickListener { binding.screenMain.text = sendNumber("7") }
        binding.buttonEight.setOnClickListener { binding.screenMain.text = sendNumber("8") }
        binding.buttonNine.setOnClickListener { binding.screenMain.text = sendNumber("9") }
        binding.buttonDiv.setOnClickListener { binding.screenMain.text = sendOperator(4) }
        binding.buttonFour.setOnClickListener { binding.screenMain.text = sendNumber("4") }
        binding.buttonFive.setOnClickListener { binding.screenMain.text = sendNumber("5") }
        binding.buttonSix.setOnClickListener { binding.screenMain.text = sendNumber("6") }
        binding.buttonMul.setOnClickListener { binding.screenMain.text = sendOperator(3) }
        binding.buttonOne.setOnClickListener { binding.screenMain.text = sendNumber("1") }
        binding.buttonTwo.setOnClickListener { binding.screenMain.text = sendNumber("2") }
        binding.buttonThree.setOnClickListener { binding.screenMain.text = sendNumber("3") }
        binding.buttonSub.setOnClickListener { binding.screenMain.text = sendOperator(2) }
        binding.buttonZero.setOnClickListener { binding.screenMain.text = sendNumber("0") }
        binding.buttonDot.setOnClickListener { binding.screenMain.text = sendDot() }
        binding.buttonEqual.setOnClickListener { binding.screenMain.text = getResult() }
        binding.buttonAdd.setOnClickListener { binding.screenMain.text = sendOperator(1) }
    }

    /**
     * A native method that is implemented by the 'kaliceplus' native library,
     * which is packaged with this application.
     */
    private external fun setOouControl(myValue: Int): Void
    private external fun setDotControl(myValue: Int): String
    private external fun myClear(): String
    private external fun myNegative(): String
    private external fun backSpace(): String
    private external fun memoryRead(): String
    private external fun memoryWrite(): Void
    private external fun powTwo(): String
    private external fun mySqrt(): String
    private external fun sendNumber(mySend: String): String
    private external fun sendOperator(mySend: Int): String
    private external fun sendDot(): String
    private external fun getResult(): String

    companion object {
        // Used to load the 'kaliceplus' library on application startup.
        init {
            System.loadLibrary("kaliceplus")
        }
    }
}
