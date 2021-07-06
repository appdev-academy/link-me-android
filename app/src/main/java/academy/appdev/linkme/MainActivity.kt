package academy.appdev.linkme

import academy.appdev.linkme.databinding.ActivityMainBinding
import android.os.Bundle
import android.text.util.Linkify
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import me.saket.bettermovementmethod.BetterLinkMovementMethod


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = """
Lorem ipsum https://loripsum.net dolor sit amet https://medium.com/@Saketme/a-better-way-to-handle-links-in-textview-27bb70b2d31c,
One link:\n
https://medium.com/@Saketme/a-better-way-to-handle-links-in-textview-27bb70b2d31c
Another link:\n
https://medium.com/@Saketme/a-better-way-to-handle-links-in-textview-27bb70b2d31c
consectetur adipiscing elit. Quid Zeno? Odium autem et invidiam facile vitabis. Quae diligentissime contra Aristonem dicuntur a Chryippo. Sed fortuna fortis 
"""

        binding.textView.text = text
        Linkify.addLinks(binding.textView, Linkify.ALL)
        binding.textView.movementMethod = BetterLinkMovementMethod.newInstance().apply {
            setOnLinkClickListener { textView, url ->
                Log.d("======", "URL clicked ${url}")
                // Handle click or return false to let the framework handle this link.
                true
            }
            setOnLinkLongClickListener { textView, url ->
                // Handle long-click or return false to let the framework handle this link.
                true
            }
        }
    }
}