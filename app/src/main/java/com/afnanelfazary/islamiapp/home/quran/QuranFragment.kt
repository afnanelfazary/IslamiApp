package com.afnanelfazary.islamiapp.home.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.afnanelfazary.islamiapp.Constants
import com.afnanelfazary.islamiapp.R
import com.afnanelfazary.islamiapp.databinding.FragmentQuranBinding
import com.afnanelfazary.islamiapp.home.quran.adapter.SuraNamesAdapter
import com.afnanelfazary.islamiapp.suradetails.SuraDetailsActivity


class QuranFragment : Fragment() {


    private lateinit var fragbinding: FragmentQuranBinding
    val aiatNumbers = listOf(
        "7",
        "286",
        "200",
        "176",
        "120",
        "165",
        "206",
        "75",
        "129",
        "109",
        "123",
        "111",
        "43",
        "52",
        "99",
        "128",
        "111",
        "110",
        "98",
        "135",
        "112",
        "78",
        "118",
        "64",
        "77",
        "227",
        "93",
        "88",
        "69",
        "60",
        "34",
        "30",
        "73",
        "54",
        "45",
        "83",
        "182",
        "88",
        "75",
        "85",
        "54",
        "53",
        "89",
        "59",
        "37",
        "35",
        "38",
        "29",
        "18",
        "45",
        "60",
        "49",
        "62",
        "55",
        "78",
        "96",
        "29",
        "22",
        "24",
        "13",
        "14",
        "11",
        "11",
        "18",
        "12",
        "12",
        "30",
        "52",
        "52",
        "44",
        "28",
        "28",
        "20",
        "56",
        "40",
        "31",
        "50",
        "40",
        "46",
        "42",
        "29",
        "19",
        "36",
        "25",
        "22",
        "17",
        "19",
        "26",
        "30",
        "20",
        "15",
        "21",
        "11",
        "8",
        "8",
        "19",
        "5",
        "8",
        "8",
        "11",
        "11",
        "8",
        "3",
        "9",
        "5",
        "4",
        "7",
        "3",
        "6",
        "3",
        "5",
        "4",
        "5",
        "6"
    )
    val suraNames = listOf(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //   R.layout.fragment_quran, container, false
        fragbinding = FragmentQuranBinding.inflate(inflater, container, false)
        return fragbinding.root

    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SuraNamesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        adapter = SuraNamesAdapter(suraNames, aiatNumbers)
        adapter.onItemClickListener = object : SuraNamesAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int, suraitems: String, aiatitems: String) {

                showSuraDetails(pos, suraitems, aiatitems)
            }

        }
        recyclerView.adapter = adapter
    }


    fun showSuraDetails(pos: Int, suraname: String, aiatnum: String) {
        val intent = Intent(context, SuraDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_SURA_NAME, suraname)
        intent.putExtra(Constants.EXTRA_SURA_Position, pos)
        intent.putExtra(Constants.EXTRA_AIAT_NUM, aiatnum)

        startActivity(intent)
    }
}