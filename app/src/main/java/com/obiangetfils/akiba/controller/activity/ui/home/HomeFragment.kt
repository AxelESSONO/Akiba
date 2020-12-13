package com.obiangetfils.akiba.controller.activity.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.glide.slider.library.SliderLayout
import com.glide.slider.library.animations.DescriptionAnimation
import com.glide.slider.library.indicators.PagerIndicator
import com.glide.slider.library.slidertypes.BaseSliderView
import com.glide.slider.library.slidertypes.TextSliderView
import com.glide.slider.library.tricks.ViewPagerEx
import com.obiangetfils.akiba.R
import com.obiangetfils.akiba.adapter.AllHandymanAdapter
import com.obiangetfils.akiba.adapter.BestRatedAdapter
import com.obiangetfils.akiba.adapter.CategoryAdapter
import com.obiangetfils.akiba.my_data.SourceData
import com.obiangetfils.akiba.util.GridItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(), BaseSliderView.OnSliderClickListener,
    ViewPagerEx.OnPageChangeListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var slider: com.glide.slider.library.SliderLayout
    private lateinit var custom_indicator: PagerIndicator
    private lateinit var rv_category: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        slider = root.findViewById(R.id.slide)
        custom_indicator = root.findViewById(R.id.custom_indicator)


        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        val requestOptions = RequestOptions()
        requestOptions.centerCrop()

        for ((name, valeur) in SourceData.slideMap) {
            var sliderView: TextSliderView = TextSliderView(context)
            sliderView
                .image(valeur)
                .description(name)
                .setRequestOption(requestOptions)
                .setProgressBarVisible(true)
                .setOnSliderClickListener(this)

            //add your extra information
            //add your extra information
            sliderView.bundle(Bundle())
            sliderView.bundle.putString("extra", name)
            slider.addSlider(sliderView)

        }

        // set Slider Transition Animation
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion)
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        slider.setCustomAnimation(DescriptionAnimation())
        slider.setDuration(3000)
        slider.addOnPageChangeListener(this)
        slider.stopCyclingWhenTouch(true)

        /** --------------------START ALL CATEGORIES--------------------------- **/
        val mLayoutManagerCategory = LinearLayoutManager(context)
        mLayoutManagerCategory.orientation = LinearLayoutManager.HORIZONTAL

        root.recycler_category_home.layoutManager = mLayoutManagerCategory
        root.recycler_category_home.itemAnimator = DefaultItemAnimator()
        root.recycler_category_home.adapter = CategoryAdapter(SourceData.categoryMap.toTypedArray()) {
            //Utilisation de ANKO
            Toast.makeText(
                context,
                "Catégorie sélectionnée : ${it.categoryName}",
                Toast.LENGTH_LONG
            ).show()
        }
        /** -----------------END ALL CATEGORIES--------------------------- **/


        /** -----------START THE BEST RATES---------------- **/

        val mLayoutManagerBestRate = LinearLayoutManager(context)
        mLayoutManagerBestRate.orientation = LinearLayoutManager.HORIZONTAL

        root.recycler_best_rated.layoutManager = mLayoutManagerBestRate
        root.recycler_best_rated.itemAnimator = DefaultItemAnimator()
        root.recycler_best_rated.adapter = BestRatedAdapter(SourceData.handyManList.toTypedArray()) {
            //Utilisation de ANKO
            Toast.makeText(
                context,
                "Artisan sélectionné : ${it.handyManFirstName} ${it.handyManName}",
                Toast.LENGTH_LONG
            ).show()
        }
        /** ------------------END THE BEST RATES--------------------- **/


        /** ----------- START VIEW ALL HANDYMAN ---------------- **/

        val mLayoutManagerViewAll = GridLayoutManager(context, 2)
            //LinearLayoutManager(context)
        //mLayoutManagerViewAll.orientation = GridLayoutManager.VERTICAL

        root.recycler_view_all.layoutManager = mLayoutManagerViewAll
        root.recycler_view_all.itemAnimator = DefaultItemAnimator()
        root.recycler_view_all.adapter = AllHandymanAdapter(SourceData.handyManList.toTypedArray()) {
            //Utilisation de ANKO
            Toast.makeText(
                context,
                "Artisan sélectionné : ${it.handyManFirstName} ${it.handyManName}",
                Toast.LENGTH_LONG
            ).show()
        }

        //initView(root)
        /** ----------- END VIEW ALL HANDYMAN ---------------- **/

        return root
    }

/*    private fun initView(root: View) {

        root.recycler_view_all.layoutManager = GridLayoutManager(context,2)

        //This will for default android divider
        root.recycler_view_all.addItemDecoration(GridItemDecoration(10, 2))

        val movieListAdapter = MovieListGridRecyclerAdapter()
        root.recycler_view_all.adapter = movieListAdapter
        movieListAdapter.setMovieList(generateDummyData())

    }*/

    override fun onStop() {
        slider.startAutoCycle()
        super.onStop()
    }

    override fun onSliderClick(slider: BaseSliderView?) {
        Toast.makeText(context, slider?.getBundle()?.getString("extra") + "", Toast.LENGTH_SHORT)
            .show()
        this.slider.setDuration(3000)
        this.slider.startAutoCycle()
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {}

    override fun onPageScrollStateChanged(state: Int) {}
}