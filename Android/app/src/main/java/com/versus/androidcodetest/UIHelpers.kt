package com.versus.androidcodetest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.versus.androidcodetest.databinding.DashboardItemBinding
import com.versus.androidcodetest.databinding.DetailViewHeaderBinding
import com.versus.androidcodetest.databinding.DetailViewItemBinding

class DashboardViewAdapter : RecyclerView.Adapter<DashboardViewAdapter.Companion.Holder>() {
    private val data: List<Helper.AmiiboSummary> = testData

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data.elementAt(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
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
                Helper.AmiiboType.FIGURE,
                "Mario"
            ),
            Helper.AmiiboSummary(
                "Isabelle - Winter",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_01810101-00b40502.png",
                "Animal Crossing",
                "Animal Crossing",
                Helper.AmiiboType.CARD,
                "Isabelle"
            ),
            Helper.AmiiboSummary(
                "Fox",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_05800000-00050002.png",
                "Super Smash Bros.",
                "Star Fox",
                Helper.AmiiboType.FIGURE,
                "Fox"
            ),
            Helper.AmiiboSummary(
                "Inkling Boy",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_08000200-003f0402.png",
                "Splatoon",
                "Splatoon",
                Helper.AmiiboType.FIGURE,
            "Inkling Boy"
            ),
            Helper.AmiiboSummary(
                "Peach",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_09c20301-02750e02.png",
                "Mario Sports Superstars",
                "Mario Sports Superstars",
                Helper.AmiiboType.CARD,
                "Peach"
            ),
            Helper.AmiiboSummary(
                "Rathian",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_35020100-02e40f02.png",
                "Monster Hunter",
                "Monster Hunter",
                Helper.AmiiboType.FIGURE,
                "Rathian"
            ),
            Helper.AmiiboSummary(
                "Marth",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_21000000-000b0002.png",
                "Super Smash Bros.",
                "Fire Emblem",
                Helper.AmiiboType.FIGURE,
                "Marth"
            )
        )

        class Holder(private val view: DashboardItemBinding) : RecyclerView.ViewHolder(view.root) {
            fun bind(data: Helper.AmiiboSummary) {
                view.apply {
                    labelItemCount.text = 1.toString()
                    labelSubtitle.text = data.gameSeries
                    labelTitle.text = data.character
                }

                // TODO: Make Glide Work
                Glide
                    .with(view.root.context)
                    .load(data.image)
                    .placeholder(R.drawable.winnie_icon)
                    .into(view.previewImage)
            }
        }
    }
}

// RecyclerView.Adapter for Detail View
class DetailViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: List<Helper.AmiiboSummary> = testData

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailItemHolder -> holder.bind(data.elementAt(position))
            is HeaderHolder -> holder.bind(data.elementAt(position))
            else -> throw Exception("Incorrectly Configured!")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data.elementAt(position).type == Helper.AmiiboType.NONE) {
            true -> 0
            false -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemWidth = parent.measuredWidth / 2.10
        val itemHeight = parent.height / 3.25

        return when (viewType) {
            // Header View Type
            0 -> {
                DetailViewHeaderBinding
                    .inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ).let {
                        HeaderHolder(it)
                    }
            }
            // Item View Type
            else -> {
                DetailViewItemBinding
                    .inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ).let {
                        DetailItemHolder(it.apply {
                            root.maxWidth = itemWidth.toInt()
                            root.maxHeight = itemHeight.toInt()
                        })
                    }
            }
        }
    }

    companion object {
        val testData: List<Helper.AmiiboSummary> = listOf(
            Helper.AmiiboSummary(
                "Mario",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000000-00000002.png",
                "Super Mario",
                "Mario Brothers 2",
                Helper.AmiiboType.NONE,
                "Mario"
            ),
            Helper.AmiiboSummary(
                "Mario",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000000-00000002.png",
                "Super Mario",
                "Mario Brothers 2",
                Helper.AmiiboType.FIGURE,
                "Mario"
            ),
            Helper.AmiiboSummary(
                "Mario",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_09c00501-026d0e02.png",
                "Mario Sports Superstars",
                "Mario Sports Superstars",
                Helper.AmiiboType.CARD,
                "Mario - Horse Racing"
            ),
            Helper.AmiiboSummary(
                "Mario",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_09c00401-026c0e02.png",
                "Mario Sports Superstars",
                "Mario Sports Superstars",
                Helper.AmiiboType.CARD,
                "Mario - Golf"
            ),
            Helper.AmiiboSummary(
                "Mario",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_09c00201-026a0e02.png",
                "Mario Sports Superstars",
                "Mario Sports Superstars",
                Helper.AmiiboType.CARD,
                "Mario - Baseball"
            ),
            Helper.AmiiboSummary(
                "Mario",
                "https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000100-00190002.png",
                "Super Smash Bros.",
                "Super Mario",
                Helper.AmiiboType.FIGURE,
                "Dr. Mario"
            )
        )

        class HeaderHolder(private val view: DetailViewHeaderBinding) : RecyclerView.ViewHolder(view.root) {
            fun bind(data: Helper.AmiiboSummary) {
                view.apply {
                    // TODO: Set Toolbar title
                    headerLabelItemCount.text = 1.toString()
                }
            }
        }

        class DetailItemHolder(private val view: DetailViewItemBinding) : RecyclerView.ViewHolder(view.root) {
            fun bind(data: Helper.AmiiboSummary) {
                view.apply {
                    // TODO: Finish binding detail items
                    itemTitle.text = data.gameSeries
                }
            }
        }
    }
}