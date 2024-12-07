package com.example.placesinqena.MainPackage

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.example.placesinqena.AdapterPackage.RecycleAdapter
import com.example.placesinqena.R
import com.example.placesinqena.dataPackage.DataPlaces
import com.example.placesinqena.databinding.PageContentBinding

class ContentPage : AppCompatActivity() {

    lateinit var binding: PageContentBinding
    var places: ArrayList<DataPlaces> = ArrayList()
    private val recycleAdapter by lazy { RecycleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PageContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // show welcome username
        showWelcome()
        // add elements in the array list
        addItemsToArray()

        // create the adapter
        creatingAdapterAndSendingData()


        // while clicking in more
        binding.tvMore.setOnClickListener{
            morePlaces()
            binding.tvMore.visibility = View.GONE
        }
    }

    private fun morePlaces () {
        places.addAll(
            arrayListOf(
                DataPlaces("The Faculty of Engineering", "The Faculty of Engineering near Ma'bar in Qena was originally part of South Valley University. Some departments have since moved to a new campus, but it still offers essential engineering programs like civil, electrical, and mechanical engineering. The faculty remains a key institution in the region.", "Egypt - Qena Governorate - Qena - Ma'bar Area.", R.drawable.faculty),
                DataPlaces("Dreams Aqua Park", "In New Qena is a popular water park offering a variety of fun attractions and water slides for visitors of all ages. It’s a great spot for families and groups looking for an exciting day of entertainment, with its modern facilities and well-maintained pools.","Egypt - Qena Governorate - New Qena - Dreams Aqua Park.", R.drawable.aqua),
            )
        )
        recycleAdapter.getItems(places)
    }

    private fun creatingAdapterAndSendingData () {

        binding.recyclerView.adapter = recycleAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        recycleAdapter.getItems(places)
    }

    private fun addItemsToArray () {
        places.addAll(
            arrayListOf(
                DataPlaces("Creativa","Creativa Innovation Hubs, supported by Egypt’s Ministry of Communications, collaborate with organizations like ITI, NTI, and TIEC. They provide training, resources, and mentorship while offering spaces for studying and collaborative work","In 13 different City", R.drawable.creativa),
                DataPlaces("South Valley University (SVU)","(SVU) in Qena is one of the largest universities in Egypt in terms of land area. It offers a broad range of academic programs and plays a crucial role in the development of Upper Egypt through its commitment to education, research, and community service.","Egypt - Qena Governorate, Qena, South Valley University.", R.drawable.south_valley_university),
                DataPlaces("Misr Public Library Qena","Is a public library located in Qena, offering a wide collection of books, research resources, and educational tools. It hosts community events, workshops, and cultural activities, serving as a center for learning and intellectual development. The library is equipped with modern facilities like computer labs, study areas, and multimedia resources to cater to students, researchers, and the general public.","Egypt - Qena Governorate, Qena - Dolphin Square - Transportation Road.",R.drawable.library),
                DataPlaces("El Sayed Abdel Rahim El Qenawy Mosque","Is the largest mosque in Qena, Egypt. It serves as a key religious and cultural landmark in the city, attracting many worshippers and visitors. The mosque is known for its significant role in the local community, offering a place for prayer, reflection, and spiritual connection.","Egypt - Qena Governorate, Qena - Sayed Abdel Rahim El Qenawy Mosque.", R.drawable.mosque),
                DataPlaces("The Qena Corniche","Is a scenic area along the Nile River, perfect for a relaxing stroll or enjoying the river view. It's a popular spot for locals and visitors alike to unwind and appreciate the natural beauty of the surroundings.","Egypt - Qena Governorate, Qena - Corniche Street, Nile River Side.",R.drawable.corniche),
                DataPlaces("Dandara Template","Is an ancient temple complex in Qena, dedicated to Hathor. It's one of Egypt's best-preserved sites, known for its remarkable architecture, intricate carvings, and famous zodiac.","Egypt - Qena Governorate, Dendera, Temple Complex.", R.drawable.dandara),
                DataPlaces("The Sahrij","The Sahrij area in Qena is a lively market offering a variety of goods, from fresh produce to poultry and other essentials. It is an important community spot where locals gather to shop and socialize. The market's vibrant atmosphere and range of products reflect the authentic energy of Qena, making it a significant part of the city's daily life.","Egypt - Qena Governorate, Qena - Sahrij Area, near the railway station.", R.drawable.sahrij),
                DataPlaces("Faculty of Computer Science and Information","A key faculty at South Valley University, offering programs in computer science and IT, focusing on software development, data management, and IT infrastructure. It's a leading educational hub in Qena, dedicated to equipping students with essential skills for the tech industry.","Egypt - Qena Governorate, Qena - South Valley University Campus.", R.drawable.university),
            )
        )
    }

    private fun showWelcome() {
        var name = intent.getStringExtra("username")
        name = "Welcome $name"
        binding.tvUsername.text = name
    }
}