package fragments

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.albedo_icon,
            R.drawable.barbara_icon,
            R.drawable.bennett_icon,
            R.drawable.chongyun_icon,
            R.drawable.collei_icon,
            R.drawable.diluc_icon,
            R.drawable.hu_tao_icon,
            R.drawable.kaedehara_kazuha_icon,
            R.drawable.qiqi_icon,
            R.drawable.xiao_icon,
        )

        title = arrayOf(
            getString(R.string.albedo),
            getString(R.string.barbara),
            getString(R.string.bennet),
            getString(R.string.chongyun),
            getString(R.string.collei),
            getString(R.string.diluc),
            getString(R.string.hu_tao),
            getString(R.string.kazuha),
            getString(R.string.qiqi),
            getString(R.string.xiao),
        )
        description = arrayOf(
            getString(R.string.desc_albedo),
            getString(R.string.desc_barbara),
            getString(R.string.desc_bennet),
            getString(R.string.desc_chongyun),
            getString(R.string.desc_collei),
            getString(R.string.desc_diluc),
            getString(R.string.desc_hu_tao),
            getString(R.string.desc_kazuha),
            getString(R.string.desc_qiqi),
            getString(R.string.desc_kazuha),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
