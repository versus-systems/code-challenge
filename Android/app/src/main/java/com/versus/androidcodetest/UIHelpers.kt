package com.versus.androidcodetest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.versus.androidcodetest.databinding.DashboardItemBinding

class DashboardViewAdapter : RecyclerView.Adapter<DashboardViewAdapter.Companion.Holder>() {
    private val data: List<Helper.AmiiboSummary> = testData

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data.elementAt(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // TODO: Add the header viewType here
        val itemWidth = parent.measuredWidth / 2.10
        val itemHeight = parent.height / 3.25

        DashboardItemBinding
            .inflate(
                LayoutInflater.from(parent.context), parent, false
            ).let {
                return Holder(it.apply {
                    root.maxWidth = itemWidth.toInt()
                    root.maxHeight = itemHeight.toInt()
                })
            }
    }



    companion object {
        val testData: List<Helper.AmiiboSummary> = listOf(
            Helper.AmiiboSummary(
                "Mario",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000000-00000002.png",
                "Super Mario",
                "Mario Brothers 2",
                Helper.AmiiboType.FIGURE
            ),
            Helper.AmiiboSummary(
                "Isabelle - Winter",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_01810101-00b40502.png",
                "Animal Crossing",
                "Animal Crossing",
                Helper.AmiiboType.CARD
            ),
            Helper.AmiiboSummary(
                "Fox",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_05800000-00050002.png",
                "Super Smash Bros.",
                "Star Fox",
                Helper.AmiiboType.FIGURE
            ),
            Helper.AmiiboSummary(
                "Inkling Boy",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_08000200-003f0402.png",
                "Splatoon",
                "Splatoon",
                Helper.AmiiboType.FIGURE
            ),
            Helper.AmiiboSummary(
                "Peach",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_09c20301-02750e02.png",
                "Mario Sports Superstars",
                "Mario Sports Superstars",
                Helper.AmiiboType.CARD
            ),
            Helper.AmiiboSummary(
                "Rathian",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_35020100-02e40f02.png",
                "Monster Hunter",
                "Monster Hunter",
                Helper.AmiiboType.FIGURE
            ),
            Helper.AmiiboSummary(
                "Marth",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_21000000-000b0002.png",
                "Super Smash Bros.",
                "Fire Emblem",
                Helper.AmiiboType.FIGURE
            )
        )

        class Holder(private val view: DashboardItemBinding) : RecyclerView.ViewHolder(view.root) {
            fun bind(data: Helper.AmiiboSummary) {
                view.apply {
                    labelItemCount.text = 1.toString()
                    labelSubtitle.text = data.gameSeries
                    labelTitle.text = data.character
                }
            }
        }
    }
}

